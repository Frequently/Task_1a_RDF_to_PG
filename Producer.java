package convert;

public class Producer {

	private int id;
	private String label;
    private String comment;
    private String homepage;
    private String country;
    private int publisher;
    private String publishDate;
    
    
	@Override
	public String toString() {
		return "Producer [id=" + id + ", label=" + label + ", comment=" + comment + ", homepage=" + homepage
				+ ", country=" + country + ", publisher=" + publisher + ", publishDate=" + publishDate + "]";
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
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
