package objects;

import java.util.Date;

public class Post {
	
	private Integer postId;
	private String wanted;
	private String offer;
	private String user;
	private Date date;
	
	public Post(String wanted, String offer, String user, Date date, Integer postId) {
		this.wanted = wanted;
		this.offer = offer;
		this.user = user;
		this.date = date;
		this.postId = postId;
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
