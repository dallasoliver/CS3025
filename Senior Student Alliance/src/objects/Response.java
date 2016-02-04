package objects;


public class Response {
	
	private String message;
	private String contactBy;
	private Integer postId;
	
	public Response(String message, String contactBy, Integer postId) {
		this.setMessage(message);
		this.setPostId(postId);
		this.setContactBy(contactBy);
	}
	
	public Response() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getContactBy() {
		return contactBy;
	}

	public void setContactBy(String contactBy) {
		this.contactBy = contactBy;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	
	@Override
	public String toString() {
		return "Response:"
		+ "\n    Message: " + this.getMessage()
		+ "\n    Contact me at: " + this.getContactBy();
	}
}
