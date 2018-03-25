package convert;

public class Person {

	private int id;
	private String name;
	private String mbox_sha1sum;
	private String country;
    private int publisher;
    private String publishDate;
    
    
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mbox_sha1sum=" + mbox_sha1sum + ", country=" + country
				+ ", publisher=" + publisher + ", publishDate=" + publishDate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMbox_sha1sum() {
		return mbox_sha1sum;
	}
	public void setMbox_sha1sum(String mbox_sha1sum) {
		this.mbox_sha1sum = mbox_sha1sum;
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
