package applogic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import objects.Post;

public class PostParser {
	static final String USER = "user";
	static final String WANTED = "wanted";
	static final String OFFER = "offer";
	static final String CONTACT_BY = "contactBy";
	static final String POST = "post";

	/**
	 * Returns a LinkedList of Activities read from a specified path to a .xml file
	 * @param configFile file path to desired data location
	 * @return A Linked List of Activities read from the data store
	 */
	public static LinkedList<Post> readConfig(String configFile) {
		LinkedList<Post> posts = new LinkedList<Post>();
		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			Post post = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					post = new Post();

					if (event.asStartElement().getName().getLocalPart()
							.equals(WANTED)) {
						event = eventReader.nextEvent();
						post.setWanted(event.asCharacters().getData());
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(OFFER)) {
						event = eventReader.nextEvent();
						post.setOffer(event.asCharacters().getData());
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(CONTACT_BY)) {
						event = eventReader.nextEvent();
						post.setContactBy(event.asCharacters().getData());
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(USER)) {
						event = eventReader.nextEvent();
						post.setUser(event.asCharacters().getData());
						continue;
					}
				}
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (POST)) {
						posts.add(post);
					}
				}
			}
		} catch (FileNotFoundException e) {
			posts = new LinkedList<Post>();
		} catch (XMLStreamException e) {
			posts = new LinkedList<Post>();
		}
		return posts;
	}
}