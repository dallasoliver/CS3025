package objects;

import java.util.Date;

public class Post {
	
	private Integer postId;
	private String wanted;
	private String offer;
	private String contactBy;
	private String user;
	private Date date;
	
	public Post(String wanted, String offer, String contactBy, String user, Date date) {
		this.wanted = wanted;
		this.offer = offer;
		this.contactBy = contactBy;
		this.user = user;
		this.setDate(date);
	}
	
	public Post() {
	}
	
	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getWanted() {
		return wanted;
	}
	
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	
	public String getOffer() {
		return offer;
	}
	
	public void setOffer(String offer) {
		this.offer = offer;
	}
	
	public String getContactBy() {
		return contactBy;
	}
	
	public void setContactBy(String contactBy) {
		this.contactBy = contactBy;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
