package convert;

import java.util.ArrayList;

public class Product {
	
	private int id;
	private String label;
    private String comment;
    private ArrayList<Integer> type;
    private int producer;
    private ArrayList<Integer> ProductPropertyNumeric;
    private ArrayList<String> ProductPropertyTextual;
    private ArrayList<Integer> ProductFeature;
    private int publisher;
    private String publishDate;
    
    
   
	@Override
	public String toString() {
		return "Product [id=" + id + ", label=" + label + ", comment=" + comment + ", type=" + type + ", producer="
				+ producer + ", ProductPropertyNumeric=" + ProductPropertyNumeric + ", ProductPropertyTextual="
				+ ProductPropertyTextual + ", ProductFeature=" + ProductFeature + ", publisher=" + publisher
				+ ", publishDate=" + publishDate + "]";
	}
	public ArrayList<Integer> getType() {
		return type;
	}
	public void setType(ArrayList<Integer> type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public int getProducer() {
		return producer;
	}
	public void setProducer(int producer) {
		this.producer = producer;
	}
	
	public ArrayList<Integer> getProductPropertyNumeric() {
		return ProductPropertyNumeric;
	}
	public void setProductPropertyNumeric(ArrayList<Integer> productPropertyNumeric) {
		ProductPropertyNumeric = productPropertyNumeric;
	}
	public ArrayList<String> getProductPropertyTextual() {
		return ProductPropertyTextual;
	}
	public void setProductPropertyTextual(ArrayList<String> productPropertyTextual) {
		ProductPropertyTextual = productPropertyTextual;
	}
	public ArrayList<Integer> getProductFeature() {
		return ProductFeature;
	}
	public void setProductFeature(ArrayList<Integer> productFeature) {
		ProductFeature = productFeature;
	}
	public int getPublisher() {
		return publisher;
	}
	public void setPublisher(int publisher) {
		this.publisher = publisher;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
    
    
}
