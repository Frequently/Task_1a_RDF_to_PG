package convert;

// Add the Apache Tinkerpop library (blueprints-core-2.0.0.jar) in the Java Build Path 

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLWriter;

public class Converter {

	private static List<ProductType> typeList = new ArrayList<ProductType>();
	private static List<ProductFeature> featurelist = new ArrayList<ProductFeature>();	
    private static List<Producer> producerList = new ArrayList<Producer>();
    private static List<Product> productList = new ArrayList<Product>();
    private static List<Vendor> vendorList = new ArrayList<Vendor>();
    private static List<Offer> offerList = new ArrayList<Offer>();
    private static List<Person> personList = new ArrayList<Person>();
    private static List<Review> reviewList = new ArrayList<Review>();
    
    // Path for input scale_2785.xml file
    private static String filePath = "C:/Users/Harshal/workspace/temp/src/convert/input/scale_2785.xml";
    
    // Path for output GraphML file 
	private static String output_path = "C:/Users/Harshal/workspace/temp/src/output.graphml";
    
	public static void main(String[] args) {

		
		
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            
            // Storing the XML File into classes  
            
            
            NodeList nodeList = doc.getElementsByTagName("dataFromStandardizationInstitution");
            
            for (int i = 0; i < nodeList.getLength(); i++) 
            {	
            	Node node =   nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                	Element element = (Element) node;
                	

                	NodeList tempList1 = element.getElementsByTagName("ProductType");
                	
                	for (int j = 0; j < tempList1.getLength(); j++) 
                		typeList.add(getType(tempList1.item(j)));
                	
                	
                	NodeList tempList = element.getElementsByTagName("ProductFeature");
                	for (int j = 0; j < tempList.getLength(); j++) 
                		featurelist.add(getFeature(tempList.item(j)));
                	
                	
                	}
                
            }
            
            nodeList = doc.getElementsByTagName("dataFromProducer");
           
            for (int i = 0; i < nodeList.getLength(); i++) 
            {	
            	Node node =   nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                	Element element = (Element) node;
                	
                	NodeList tempList = element.getElementsByTagName("Producer");
                	for (int j = 0; j < tempList.getLength(); j++) 
                		producerList.add(getProducer(tempList.item(j)));
                	
                	NodeList tempList1 = element.getElementsByTagName("Product");
                	
                	for (int j = 0; j < tempList1.getLength(); j++) 
                		productList.add(getProduct(tempList1.item(j)));
                	
                	}
                
               
            }

            nodeList = doc.getElementsByTagName("dataFromVendor");
            
            for (int i = 0; i < nodeList.getLength(); i++) 
            {	
            	Node node =   nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                	Element element = (Element) node;
                	
                	NodeList tempList = element.getElementsByTagName("Vendor");
                	for (int j = 0; j < tempList.getLength(); j++) 
                		vendorList.add(getVendor(tempList.item(j)));
                	
                	NodeList tempList1 = element.getElementsByTagName("Offer");
                	
                	for (int j = 0; j < tempList1.getLength(); j++) 
                		offerList.add(getOffer(tempList1.item(j)));
                		
                	
                	}
                
            }
          
            nodeList = doc.getElementsByTagName("dataFromRatingSite");
            
            for (int i = 0; i < nodeList.getLength(); i++) 
            {	
            	Node node =   nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                	Element element = (Element) node;
                	
                	NodeList tempList = element.getElementsByTagName("Person");
                	for (int j = 0; j < tempList.getLength(); j++) 
                		personList.add(getPerson(tempList.item(j)));
                	
                	NodeList tempList1 = element.getElementsByTagName("Review");
                	
//                	System.out.println("List size = "+ tempList1.getLength());
                	for (int j = 0; j < tempList1.getLength(); j++) 
                		reviewList.add(getReview(tempList1.item(j)));
                	
                	}                
            }
            
            // Converting it into a Graph 
            convertToGraph();
            
                       
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

	
        System.out.println("GraphMl file created at "+ output_path);
	}
	
	private static void convertToGraph() throws IOException
	{
			Graph graph = new TinkerGraph();
			
			// Adding Vertices and its property to the Graph
			
			Vertex featureVertices[] = new Vertex[featurelist.size()];
			Vertex typeVertices[] = new Vertex[typeList.size()];
			Vertex producerVertices[] = new Vertex[producerList.size()];
			Vertex productVertices[] = new Vertex[productList.size()];
			Vertex vendorVertices[] = new Vertex[vendorList.size()];
			Vertex offerVertices[] = new Vertex[offerList.size()];
			Vertex personVertices[] = new Vertex[personList.size()];
			Vertex reviewVertices[] = new Vertex[reviewList.size()];
	        
			int uniqueid = 1;
	        for(int i = 0; i < featureVertices.length;i++ )
	        {
//	        	featureVertices[i] = graph.addVertex(featurelist.get(i));
	        	featureVertices[i] = graph.addVertex(null);
	        	
	        	featureVertices[i].setProperty("uniqueid", uniqueid);
	        	featureVertices[i].setProperty("label", featurelist.get(i).getLabel());
	        	featureVertices[i].setProperty("comment", featurelist.get(i).getComment());
	        	featureVertices[i].setProperty("publisher", featurelist.get(i).getPublisher());
	        	featureVertices[i].setProperty("publishDate", featurelist.get(i).getPublishDate());
	        	
	        	uniqueid++;
	        }
	        
	        for(int i = 0; i < typeVertices.length;i++ )
	        {
//	        	typeVertices[i] = graph.addVertex(typeList.get(i));
	        	typeVertices[i] = graph.addVertex(null);
	        	
	        	typeVertices[i].setProperty("uniqueid", uniqueid);
	        	typeVertices[i].setProperty("label", typeList.get(i).getLabel());
	        	typeVertices[i].setProperty("comment", typeList.get(i).getComment());
	        	typeVertices[i].setProperty("subClassOf", typeList.get(i).getSubClassOf());
	        	typeVertices[i].setProperty("publisher", typeList.get(i).getPublisher());
	        	typeVertices[i].setProperty("publishDate", typeList.get(i).getPublishDate());
	        	
	        	uniqueid++;
	        }
			
	        for(int i = 0; i < producerVertices.length;i++ )
	        {
//	        	producerVertices[i] = graph.addVertex(producerList.get(i));
	        	producerVertices[i] = graph.addVertex(null);
	        	
	        	producerVertices[i].setProperty("uniqueid", uniqueid);	        	
	        	producerVertices[i].setProperty("label", producerList.get(i).getLabel());
	        	producerVertices[i].setProperty("comment", producerList.get(i).getComment());
	        	producerVertices[i].setProperty("homepage", producerList.get(i).getHomepage());
	        	producerVertices[i].setProperty("country", producerList.get(i).getCountry());
	        	producerVertices[i].setProperty("publisher", producerList.get(i).getPublisher());
	        	producerVertices[i].setProperty("publishDate", producerList.get(i).getPublishDate());
	        	
	        	uniqueid++;
	        }
	        
	        
	        for(int i = 0; i < productVertices.length;i++ )
	        {
//	        	productVertices[i] = graph.addVertex(productList.get(i));
	        	productVertices[i] = graph.addVertex(null);
	        	
	        	productVertices[i].setProperty("uniqueid", uniqueid);
	        	productVertices[i].setProperty("label", productList.get(i).getLabel());
	        	productVertices[i].setProperty("comment", productList.get(i).getComment());
	        	productVertices[i].setProperty("type", productList.get(i).getType());
	        	productVertices[i].setProperty("producer", productList.get(i).getProducer());
	        	productVertices[i].setProperty("ProductPropertyNumeric", productList.get(i).getProductPropertyNumeric());
	        	productVertices[i].setProperty("ProductPropertyTextual", productList.get(i).getProductPropertyTextual());
	        	productVertices[i].setProperty("ProductFeature", productList.get(i).getProductFeature());
	        	productVertices[i].setProperty("publisher", productList.get(i).getPublisher());
	        	productVertices[i].setProperty("publishDate", productList.get(i).getPublishDate());
	        	
	        	uniqueid++;
	        }

	        for(int i = 0; i < vendorVertices.length;i++ )
	        {
//	        	vendorVertices[i] = graph.addVertex(vendorList.get(i));
	        	vendorVertices[i] = graph.addVertex(null);
	        	
	        	vendorVertices[i].setProperty("uniqueid", uniqueid);
	        	vendorVertices[i].setProperty("label", vendorList.get(i).getLabel());
	        	vendorVertices[i].setProperty("comment", vendorList.get(i).getComment());
	        	vendorVertices[i].setProperty("homepage", vendorList.get(i).getHomepage());
	        	vendorVertices[i].setProperty("country", vendorList.get(i).getCountry());
	        	vendorVertices[i].setProperty("publisher", vendorList.get(i).getPublisher());
	        	vendorVertices[i].setProperty("publishDate", vendorList.get(i).getPublishDate());
	        	
	        	uniqueid++;
	        }
    
	        for(int i = 0; i < offerVertices.length;i++ )
	        {
//	        	offerVertices[i] = graph.addVertex(offerList.get(i));
	        	offerVertices[i] = graph.addVertex(null);
	        	
	        	offerVertices[i].setProperty("uniqueid", uniqueid);
	        	offerVertices[i].setProperty("product", offerList.get(i).getProduct());
	        	offerVertices[i].setProperty("vendor", offerList.get(i).getVendor());
	        	offerVertices[i].setProperty("price", offerList.get(i).getPrice());
	        	offerVertices[i].setProperty("validFrom", offerList.get(i).getValidFrom());
	        	offerVertices[i].setProperty("deliveryDays", offerList.get(i).getDeliveryDays());
	        	offerVertices[i].setProperty("offerWebpage", offerList.get(i).getOfferWebpage());
	        	offerVertices[i].setProperty("publisher", offerList.get(i).getPublisher());
	        	offerVertices[i].setProperty("publishDate", offerList.get(i).getPublishDate());
	        	
	        	uniqueid++;
	        }
            
	        for(int i = 0; i < personVertices.length;i++ )
	        {
//	        	personVertices[i] = graph.addVertex(personList.get(i));
	        	personVertices[i] = graph.addVertex(null);
	        	
	        	personVertices[i].setProperty("uniqueid", uniqueid);
	        	personVertices[i].setProperty("name", personList.get(i).getName());
	        	personVertices[i].setProperty("mbox_sha1sum", personList.get(i).getMbox_sha1sum());
	        	personVertices[i].setProperty("country", personList.get(i).getCountry());
	        	personVertices[i].setProperty("publisher", personList.get(i).getPublisher());
	        	personVertices[i].setProperty("publishDate", personList.get(i).getPublishDate());
	        	
	        	uniqueid++;
	        }
	        
	        
	        for(int i = 0; i < reviewVertices.length;i++ )
	        {
//	        	reviewVertices[i] = graph.addVertex(reviewList.get(i));
	        	reviewVertices[i] = graph.addVertex(null);
	        	
	        	reviewVertices[i].setProperty("uniqueid", uniqueid);
	        	reviewVertices[i].setProperty("reviewfor", reviewList.get(i).getReviewfor());
	        	reviewVertices[i].setProperty("reviewer", reviewList.get(i).getReviewer());
	        	reviewVertices[i].setProperty("reviewDate", reviewList.get(i).getReviewDate());
	        	reviewVertices[i].setProperty("title", reviewList.get(i).getTitle());
	        	reviewVertices[i].setProperty("text", reviewList.get(i).getText());
	        	reviewVertices[i].setProperty("rating", reviewList.get(i).getRating());
	        	
	        	reviewVertices[i].setProperty("publisher", reviewList.get(i).getPublisher());
	        	reviewVertices[i].setProperty("publishDate", reviewList.get(i).getPublishDate());
	        	
	        	uniqueid++;
	        }
	        
	        
	        // adding edges in the graph
	        
	        for(int i = 0; i < productVertices.length;i++ )
	        {
	        	    // Linking the Product with the  Producer 
		        	int producer = (int) productVertices[i].getProperty("producer");
		        	graph.addEdge(null, productVertices[i], producerVertices[producer-1], "produce by");
		        	
		        	// Linking the Product with its type
		        	ArrayList<Integer> temp = (ArrayList<Integer>) productVertices[i].getProperty("type");
		        	
		        	for(int j = 0; j < temp.size() ; j++ )
		        		graph.addEdge(null, productVertices[i], typeVertices[temp.get(j)-1], "type of");
		        	
		        	// Linking the Product with its Features
		        	temp = (ArrayList<Integer>) productVertices[i].getProperty("ProductFeature");
		        	
		        	for(int j = 0; j < temp.size() ; j++ )
		        		graph.addEdge(null, productVertices[i], featureVertices[temp.get(j)-1], "has feature");
		        	
	        }
	        
	        
	        for(int i = 0; i < offerVertices.length;i++ )
	        {
	        		// Linking offer to its Products 
		        	int product = (int) offerVertices[i].getProperty("product");
		        	graph.addEdge(null, offerVertices[i], productVertices[product-1], "offer on");
		        	
		        	// Linking Offer with the vendor
		        	int vendor = (int) offerVertices[i].getProperty("vendor");
		        	graph.addEdge(null, offerVertices[i], vendorVertices[vendor-1], "offered by");
	        }
	        
	        
	        for(int i = 0; i < reviewVertices.length;i++ )
	        {
	        		// Linking the review with its product 
		        	int product = (int) reviewVertices[i].getProperty("reviewfor");
		        	graph.addEdge(null, reviewVertices[i], productVertices[product-1], "review for");
		        	
		        	// Linking the review with the person
		        	int reviewer = (int) reviewVertices[i].getProperty("reviewer");
		        	graph.addEdge(null, reviewVertices[i], personVertices[reviewer-1], "review by");
	        }
	        
	        GraphMLWriter writer = new GraphMLWriter(graph);
	        OutputStream out = new FileOutputStream(output_path);
	        writer.outputGraph(out);
	}
	

/*
 *  All the below methods are used to set values to the classes
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
	
	
	private static Review getReview(Node node) {
        
		Review p = new Review();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element element = (Element) node;
            	
            	p.setId(Integer.parseInt(element.getAttribute("id")));
            	p.setReviewfor(Integer.parseInt(getTagValue("reviewfor", element)));
            	p.setReviewer(Integer.parseInt(getTagValue("reviewer", element)));
            	p.setReviewDate(getTagValue("reviewDate", element));
            	p.setTitle(getTagValue("title", element));
            	p.setText(getTagValue("text", element));
            	
            	int length = element.getElementsByTagName("rating").getLength();
            	ArrayList<Integer> list = new ArrayList<Integer>();
            	
            	for(int i = 0 ; i < length ; i++)
            	{
            		NodeList temp = element.getElementsByTagName("rating").item(i).getChildNodes();
            		Node node1 = (Node) temp.item(0);
        	        list.add(Integer.parseInt(node1.getNodeValue()));
            	}
            	p.setRating(list);
            	
	            p.setPublisher(Integer.parseInt(getTagValue("publisher", element)));
	            p.setPublishDate(getTagValue("publishDate", element));
	            
        }

	
        return p;
	}

	
	
	
	private static Person getPerson(Node node) {
       
		Person p = new Person();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element element = (Element) node;
            	
            	p.setId(Integer.parseInt(element.getAttribute("id")));
            	p.setName(getTagValue("name", element));
            	p.setMbox_sha1sum(getTagValue("mbox_sha1sum", element));
            	p.setCountry(getTagValue("country", element));
	            p.setPublisher(Integer.parseInt(getTagValue("publisher", element)));
	            p.setPublishDate(getTagValue("publishDate", element));
	            
        }

	
        return p;
	}

	
	private static Offer getOffer(Node node) {
       
		Offer p = new Offer();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element element = (Element) node;
            	
            	
            	p.setId(Integer.parseInt(element.getAttribute("id")));
            	p.setProduct(Integer.parseInt(getTagValue("product", element)));
            	p.setVendor(Integer.parseInt(getTagValue("vendor", element)));
            	p.setPrice(Double.parseDouble(getTagValue("price", element)));

            	int length = element.getElementsByTagName("validFrom").getLength();
            	ArrayList<String> list = new ArrayList<String>();
            	
            	for(int i = 0 ; i < length ; i++)
            	{
            		NodeList temp = element.getElementsByTagName("validFrom").item(i).getChildNodes();
            		Node node1 = (Node) temp.item(0);
        	        list.add(node1.getNodeValue());
            	}
            	p.setValidFrom(list);
            	
            	
            	p.setDeliveryDays(Integer.parseInt(getTagValue("deliveryDays", element)));
            	p.setOfferWebpage(getTagValue("offerWebpage", element));
	            p.setPublisher(Integer.parseInt(getTagValue("publisher", element)));
	            p.setPublishDate(getTagValue("publishDate", element));
	            
	            
        }

	
        return p;
	}

	private static Vendor getVendor(Node node) {
        
		Vendor p = new Vendor();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element element = (Element) node;
            
            	
            	p.setId(Integer.parseInt(element.getAttribute("id")));
            	p.setLabel(getTagValue("label", element));
            	p.setComment(getTagValue("comment", element));
            	p.setHomepage(getTagValue("homepage", element));
	            p.setCountry(getTagValue("country", element));
	            p.setPublisher(Integer.parseInt(getTagValue("publisher", element)));
	            p.setPublishDate(getTagValue("publishDate", element));
            
            
        }

	
        return p;
	}
	private static Product getProduct(Node node) {
       
		Product p = new Product();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element element = (Element) node;
            
            	
            	p.setId(Integer.parseInt(element.getAttribute("id")));
            	p.setLabel(getTagValue("label", element));
            	p.setComment(getTagValue("comment", element));
//            	System.out.println("length = "+length);
            	int length = element.getElementsByTagName("type").getLength();
            	ArrayList<Integer> list = new ArrayList<Integer>();
            	
            	for(int i = 0 ; i < length ; i++)
            	{
            		NodeList temp = element.getElementsByTagName("type").item(i).getChildNodes();
            		Node node1 = (Node) temp.item(0);
        	        list.add(Integer.parseInt(node1.getNodeValue()));
            	}
            	p.setType(list);
            	
            	length = element.getElementsByTagName("ProductPropertyNumeric").getLength();
            	list = new ArrayList<Integer>();
            	
            	for(int i = 0 ; i < length ; i++)
            	{
            		NodeList temp = element.getElementsByTagName("ProductPropertyNumeric").item(i).getChildNodes();
            		Node node1 = (Node) temp.item(0);
        	        list.add(Integer.parseInt(node1.getNodeValue()));
            	}
            	p.setProductPropertyNumeric(list);
            	
            	length = element.getElementsByTagName("ProductPropertyTextual").getLength();
            	ArrayList<String> list1 = new ArrayList<String>();
            	
            	for(int i = 0 ; i < length ; i++)
            	{
            		NodeList temp = element.getElementsByTagName("ProductPropertyTextual").item(i).getChildNodes();
            		Node node1 = (Node) temp.item(0);
        	        list1.add(node1.getNodeValue());
            	}
            	p.setProductPropertyTextual(list1);
            	
            	length = element.getElementsByTagName("ProductFeature").getLength();
            	list = new ArrayList<Integer>();
            	
            	for(int i = 0 ; i < length ; i++)
            	{
            		NodeList temp = element.getElementsByTagName("ProductFeature").item(i).getChildNodes();
            		Node node1 = (Node) temp.item(0);
        	        list.add(Integer.parseInt(node1.getNodeValue()));
            	}
            	p.setProductFeature(list);
            	
	            p.setProducer(Integer.parseInt(getTagValue("producer", element)));
	            p.setPublisher(Integer.parseInt(getTagValue("publisher", element)));
	            p.setPublishDate(getTagValue("publishDate", element));
            
            
        }

        return p;
    }

	private static Producer getProducer(Node node) {
        
		Producer p = new Producer();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element element = (Element) node;
            
            	
            	p.setId(Integer.parseInt(element.getAttribute("id")));
            	p.setLabel(getTagValue("label", element));
            	p.setComment(getTagValue("comment", element));
            	p.setHomepage(getTagValue("homepage", element));
	            p.setCountry(getTagValue("country", element));
	            p.setPublisher(Integer.parseInt(getTagValue("publisher", element)));
	            p.setPublishDate(getTagValue("publishDate", element));
            
            
        }

        return p;
    }

	
	private static ProductType getType(Node node) {
       
		ProductType p = new ProductType();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            	Element element = (Element) node;
            
            	
            	p.setId(Integer.parseInt(element.getAttribute("id")));
            	p.setLabel(getTagValue("label", element));
	            p.setComment(getTagValue("comment", element));
	            
	            if(element.hasAttribute("subClassOf"))
	            	p.setSubClassOf(Integer.parseInt(getTagValue("subClassOf", element)));
	            
	            p.setPublisher(Integer.parseInt(getTagValue("publisher", element)));
	            p.setPublishDate(getTagValue("publishDate", element));
            
            
        }

        return p;
    }

	
	 private static ProductFeature getFeature(Node node) {
	        
		 ProductFeature p = new ProductFeature();
	        if (node.getNodeType() == Node.ELEMENT_NODE) {
	            	Element element = (Element) node;
	            
	            	
	            	p.setId(Integer.parseInt(element.getAttribute("id")));
	            	p.setLabel(getTagValue("label", element));
		            p.setComment(getTagValue("comment", element));
		            p.setPublisher(Integer.parseInt(getTagValue("publisher", element)));
		            p.setPublishDate(getTagValue("publishDate", element));
	            
	            
	        }

	        return p;
	    }

	 
	 private static String getTagValue(String tag, Element element) {
		 
	        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
	        Node node = (Node) nodeList.item(0);
	        return node.getNodeValue();
	    }
}
