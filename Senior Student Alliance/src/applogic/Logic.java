package applogic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import objects.Post;

public class Logic {
	/** The list of posts. */
	private LinkedList<Post> posts;
	/** The name of the XML file in which data is stored/read. */
	private String configFile;

	public Logic(String configFile) {
		this.configFile = configFile;
		posts = PostParser.readConfig(configFile);
	}

	public void addPost(String wanted, String offer, String contactBy, String user) throws Exception {
		String errorMessage = "The following errors have occurred:\n";
		boolean isError = false;

		// Performs check for any errors in input.
		if (wanted.isEmpty()) {
			errorMessage += "The task you need assistance with must be specified.\n";
			isError = true;
		}
		
		if (offer.isEmpty()) {
			errorMessage += "The task you offer in return must be specified.\n";
			isError = true;
		}
		
		if (contactBy.isEmpty()) {
			errorMessage += "Your contact information must be specified.\n";
			isError = true;
		}
		
		if (user.isEmpty()) {
			errorMessage += "Please specify whether you are a student or a senior.\n";
			isError = true;
		}


		if (isError) {
			throw new Exception(errorMessage);
		}

		Post newPost = new Post(wanted, offer, contactBy, user);
		posts.add(newPost);
		saveXML();
	}

	private void saveXML() throws Exception {
		PostWriter.saveConfig(posts, configFile);
	}

	public String filterBySeniorUser(String userType) throws Exception {
		LinkedList<Post> resultsList = new LinkedList<Post>();
		Iterator<Post> it = posts.iterator();
		while (it.hasNext()) {
			Post act = it.next();
			if (act.getUser().equals("senior")) {
				resultsList.add(act);
			}
		}
		return display(resultsList);
	}
	
	public String filterByStudentUser(String userType) throws Exception {
		LinkedList<Post> resultsList = new LinkedList<Post>();
		Iterator<Post> it = posts.iterator();
		while (it.hasNext()) {
			Post act = it.next();
			if (act.getUser().equals("student")) {
				resultsList.add(act);
			}
		}
		return display(resultsList);
	}

	private String display(LinkedList<Post> posts) {
		String ret = "";
		Iterator<Post> it = posts.iterator();
		while (it.hasNext()) {
			Post post = it.next();
			ret += post.toString() + "\n";
		}
		if (ret.isEmpty()) {
			ret = "There are no recorded posts.";
		}
		return ret;
	}
	
	public Object[] showAll() throws Exception {
		ArrayList<Post> resultsList = new ArrayList<Post>();
		Iterator<Post> it = posts.iterator();
		while (it.hasNext()) {
			Post post = it.next();
			resultsList.add(post);
		}
		return getList(resultsList);
	}
	
	private Object[] getList(ArrayList<Post> posts) {
		if (posts != null) {
			return posts.toArray();			
		}else {
			return null;
		}
	}

}