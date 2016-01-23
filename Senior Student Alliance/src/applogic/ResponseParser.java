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

import objects.Response;

public class ResponseParser {
	static final String ID = "postId";
	static final String MESSAGE = "message";
	static final String CONTACT_BY = "contactBy";
	static final String RESPONSE = "response";


	/**
	 * Returns a LinkedList of Activities read from a specified path to a .xml file
	 * @param configFile file path to desired data location
	 * @return A Linked List of Activities read from the data store
	 */
	public static LinkedList<Response> readConfig(String configFile) {
		LinkedList<Response> responses = new LinkedList<Response>();
		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			Response response = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					response = new Response();
					if (event.asStartElement().getName().getLocalPart()
							.equals(ID)) {
						event = eventReader.nextEvent();
						response.setPostId(Integer.parseInt(event
										.asCharacters().getData()));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(MESSAGE)) {
						event = eventReader.nextEvent();
						response.setMessage(event.asCharacters().getData());
						continue;
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(CONTACT_BY)) {
						event = eventReader.nextEvent();
						response.setContactBy(event.asCharacters().getData());
						continue;
					}	
				}
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (RESPONSE)) {
						responses.add(response);
					}
				}
			}
		} catch (FileNotFoundException e) {
			responses = new LinkedList<Response>();
		} catch (XMLStreamException e) {
			responses = new LinkedList<Response>();
		}
		return responses;
	}
}