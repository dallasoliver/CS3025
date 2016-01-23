package applogic;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import java.util.ListIterator;

import objects.*;

public class ResponseWriter {

	public static void saveConfigResponse(LinkedList<Response> responses, Integer postId,
			String configFile) throws Exception {
		
		// create an XMLOutputFactory
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

		// create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory
				.createXMLEventWriter(new FileOutputStream(configFile));

		// create an EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");

		// create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);
		eventWriter.add(end);

		ListIterator<Response> iterator = (ListIterator<Response>) responses.iterator();
		openRootNode(eventWriter);
		while (iterator.hasNext()) {
			Response responseIn = iterator.next();
			responseIn.setPostId(postId);

			// create config open tag
			StartElement configStartElement = eventFactory
					.createStartElement("", "", "Response");
			eventWriter.add(configStartElement);
			eventWriter.add(end);

			// Write the different nodes
			createNode(eventWriter, "postId", ""
					+ postId);
			createNode(eventWriter, "message", ""
					+ responseIn.getMessage());
			createNode(eventWriter, "contactBy",
					("" + (responseIn.getContactBy())));
			eventWriter.add(eventFactory.createEndElement("", "",
					"Response"));
			eventWriter.add(end);
		}
		closeRootNode(eventWriter);
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close();
	}

	/**
	 * creates and formats a new node in the .xml data store
	 * 
	 * @param eventWriter
	 * @param name
	 *            the name of the node to be written
	 * @param value
	 *            to be help in the node
	 * @throws XMLStreamException
	 */
	private static void createNode(XMLEventWriter eventWriter, String name,
			String value) throws XMLStreamException {

		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tab);
		eventWriter.add(sElement);
		// create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);
		// create End node
		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);

	}

	/**
	 * Writes the first tag in the .xml file, to be closed at the end of the
	 * file using closeRootNode()
	 * 
	 * @param eventWriter
	 * @throws XMLStreamException
	 */
	private static void openRootNode(XMLEventWriter eventWriter)
			throws XMLStreamException {
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createSpace("\n");

		StartElement sElement = eventFactory.createStartElement("", "",
				"responses");

		eventWriter.add(sElement);
		eventWriter.add(end);

	}

	/**
	 * Writes the final node to the xml file after all nodes are written
	 * 
	 * @param eventWriter
	 * @throws XMLStreamException
	 */
	private static void closeRootNode(XMLEventWriter eventWriter)
			throws XMLStreamException {
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createSpace("\n");

		EndElement eElement = eventFactory.createEndElement("", "",
				"responses");
		eventWriter.add(eElement);
		eventWriter.add(end);

	}
}