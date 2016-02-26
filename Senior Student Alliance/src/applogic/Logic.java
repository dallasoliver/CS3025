package applogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import objects.Post;
import objects.Response;

public class Logic {

	private LinkedList<Post> posts;
	private LinkedList<Response> responses;
	private String configFilePost;
	private String configFileResponse;
	private int postIdCount = 0;


	public Logic(String configFilePost, String configFileResponse) {
		this.configFilePost = configFilePost;
		posts = PostParser.readConfig(configFilePost);
		this.configFileResponse = configFileResponse;
		responses = ResponseParser.readConfig(configFileResponse);
	}
	
	public void delete(int pId) throws Exception {
	
		Iterator<Post> it = posts.iterator();
		while (it.hasNext()) {
			Post post = it.next();
			if (post.getPostId() == pId) {
				posts.remove(post);
			}
		}
		deletePostXML(-1);
	}

	public void addPost(String wanted, String offer, String user, Date date) throws Exception {
		
		String errorMessage = "The following errors have occurred:\n";
		boolean isError = false;
		postIdCount++;
		

		// Performs check for any errors in input.
		if (wanted.isEmpty()) {
			errorMessage += "The task you need assistance with must be specified.\n";
			isError = true;
		}
		
		if (offer.isEmpty()) {
			errorMessage += "The task you offer in return must be specified.\n";
			isError = true;
		}
		
		if (user.isEmpty()) {
			errorMessage += "Please specify whether you are a student or a senior.\n";
			isError = true;
		}
		
		Date now = new Date();
		now.setTime(System.currentTimeMillis());
		if (date == null || date.before(now)) {
			errorMessage += "The date must be on or after today.\n";
			isError = true;
		}

		if (isError) {
			throw new Exception(errorMessage);
		}

		Post newPost = new Post(wanted, offer, user, date, postIdCount);
		posts.add(newPost);
		savePostXML();
	}
	
	public void addResponse(String message, String contactBy, Integer postId) throws Exception {
		String errorMessage = "The following errors have occurred:\n";
		boolean isError = false;

		// Performs check for any errors in input.
		if (message.isEmpty()) {
			errorMessage += "Your response must be specified.\n";
			isError = true;
		}
		
		if (contactBy.isEmpty()) {
			errorMessage += "Your contact information must be specified.\n";
			isError = true;
		}
		
		if (postId == null) {
			errorMessage += "The postId must be specified.\n";
			isError = true;
		}
		if (isError) {
			throw new Exception(errorMessage);
		}

		Response newResponse = new Response(message, contactBy, postId);
		responses.add(newResponse);
		saveResponseXML(postId);
	}

	private void savePostXML() throws Exception {
		PostWriter.saveConfigPost(posts, configFilePost);
	}

	private void deletePostXML(int postId) throws Exception {
		PostWriter.saveConfigPost(posts, configFilePost);
	}
	
	private void saveResponseXML(Integer postId) throws Exception {
		ResponseWriter.saveConfigResponse(responses, postId, configFileResponse);
	}

	public Object[] filterBySeniorUser(String userType) throws Exception {
		ArrayList<Post> resultsList = new ArrayList<Post>();
		Iterator<Post> it = posts.iterator();
		while (it.hasNext()) {
			Post act = it.next();
			if (act.getUser().equalsIgnoreCase("senior")) {
				resultsList.add(act);
			}
		}
		return getList(resultsList);
	}
	
	public Object[] filterByStudentUser(String userType) throws Exception {
		ArrayList<Post> resultsList = new ArrayList<Post>();
		Iterator<Post> it = posts.iterator();
		while (it.hasNext()) {
			Post act = it.next();
			if (act.getUser().equalsIgnoreCase("student")) {
				resultsList.add(act);
			}
		}
		return getList(resultsList);
	}

	private String displayResponses(ArrayList<Response> responses) {
		String ret = "";
		Iterator<Response> it = responses.iterator();
		while (it.hasNext()) {
			Response response = it.next();
			ret += response.toString() + "\n";
		}
		if (ret.isEmpty()) {
			ret = "You have not recieved any responses to this post.";
		}
		return ret;
	}
	
	public Object[] showAll() throws Exception {
		ArrayList<Post> resultsList = new ArrayList<Post>();
		Iterator<Post> it = posts.iterator();
		while (it.hasNext()) {
			Post post = it.next();
			if (post.getPostId() != -1) {
				resultsList.add(post);
			}
		}
		return getList(resultsList);
	}
	
	public Object[] showMyPosts(String user) throws Exception {
		ArrayList<Post> resultsList = new ArrayList<Post>();
		Iterator<Post> it = posts.iterator();
		while (it.hasNext()) {
			Post post = it.next();
			if (post.getUser().equals(user) && post.getPostId() != -1) {
				resultsList.add(post);
			}
		}
		return getList(resultsList);
	}
	
	private Object[] getList(ArrayList<Post> posts) {
		if (!posts.isEmpty()) {
			return posts.toArray();			
		}else {
			return null;
		}
	}
	
	public String showResponses(Integer postId) throws Exception {
		ArrayList<Response> resultsList = new ArrayList<Response>();
		Iterator<Response> it = responses.iterator();
		while (it.hasNext()) {
			Response response = it.next();
			if (response.getPostId().intValue() == postId.intValue()) {
				resultsList.add(response);
			}
		}
		return displayResponses(resultsList);
	}
	
	public Integer countResponses(Integer postId) throws Exception {
		ArrayList<Response> resultsList = new ArrayList<Response>();
		Iterator<Response> it = responses.iterator();
		while (it.hasNext()) {
			Response response = it.next();
			if (response.getPostId().intValue() == postId.intValue()) {
				resultsList.add(response);
			}
		}
		return resultsList.size();
	}
}