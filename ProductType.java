package convert;

public class ProductType {
	
	private int id;
	private String label;
    private String comment;
    private int subClassOf;
    private int publisher;
    private String publishDate;
    
    
    
    
	@Override
	public String toString() {
		return "ProductType [id=" + id + ", label=" + label + ", comment=" + comment + ", subClassOf=" + subClassOf
				+ ", publisher=" + publisher + ", publishDate=" + publishDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubClassOf() {
		return subClassOf;
	}

	public void setSubClassOf(int subClassOf) {
		this.subClassOf = subClassOf;
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
