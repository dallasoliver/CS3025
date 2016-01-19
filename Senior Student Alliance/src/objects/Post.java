package objects;

public class Post {
	
	private String wanted;
	private String offer;
	private String contactBy;
	private String user;
	
	public Post(String wanted, String offer, String contactBy, String user) {
		this.wanted = wanted;
		this.offer = offer;
		this.contactBy = contactBy;
		this.user = user;
	}
	
	public Post() {
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
}
