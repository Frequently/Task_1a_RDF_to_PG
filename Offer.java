package convert;

import java.util.ArrayList;

public class Offer {
	
	private int id;
	private int product;
	private int vendor;
	private double price;
	private ArrayList<String> validFrom;
	private int deliveryDays;
	private String offerWebpage;
	private int publisher;
    private String publishDate;
    
    
    
   	@Override
	public String toString() {
		return "Offer [id=" + id + ", product=" + product + ", vendor=" + vendor + ", price=" + price + ", validFrom="
				+ validFrom + ", deliveryDays=" + deliveryDays + ", offerWebpage=" + offerWebpage + ", publisher="
				+ publisher + ", publishDate=" + publishDate + "]";
	}

	public ArrayList<String> getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(ArrayList<String> validFrom) {
		this.validFrom = validFrom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	public int getVendor() {
		return vendor;
	}
	public void setVendor(int vendor) {
		this.vendor = vendor;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDeliveryDays() {
		return deliveryDays;
	}
	public void setDeliveryDays(int deliveryDays) {
		this.deliveryDays = deliveryDays;
	}
	public String getOfferWebpage() {
		return offerWebpage;
	}
	public void setOfferWebpage(String offerWebpage) {
		this.offerWebpage = offerWebpage;
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
