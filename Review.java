package convert;

import java.util.ArrayList;

public class Review {

	private int id;
	private int reviewfor;
	private int reviewer;
	private String reviewDate;
	private String title;
	private String text;
	private ArrayList<Integer> rating;
	private int publisher;
    private String publishDate;
    
    
	
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewfor=" + reviewfor + ", reviewer=" + reviewer + ", reviewDate=" + reviewDate
				+ ", title=" + title + ", text=" + text + ", rating=" + rating + ", publisher=" + publisher
				+ ", publishDate=" + publishDate + "]";
	}
	public ArrayList<Integer> getRating() {
		return rating;
	}
	public void setRating(ArrayList<Integer> rating) {
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReviewfor() {
		return reviewfor;
	}
	public void setReviewfor(int reviewfor) {
		this.reviewfor = reviewfor;
	}
	public int getReviewer() {
		return reviewer;
	}
	public void setReviewer(int reviewer) {
		this.reviewer = reviewer;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
