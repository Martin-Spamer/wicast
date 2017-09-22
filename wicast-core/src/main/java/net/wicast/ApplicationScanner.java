

package net.wicast;

import javax.xml.parsers.*;

import org.slf4j.*;
import org.w3c.dom.*;

/**
 * Application Scanner class.
 */
public class ApplicationScanner {

	private static final Logger log = LoggerFactory.getLogger(ApplicationScanner.class);

	/**
	 * Instantiates a new application scanner.
	 */
	public ApplicationScanner() {
		final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			final Document document = documentBuilder.newDocument();
			visitDocument(document);
		} catch (final ParserConfigurationException parserConfigurationException) {
			ApplicationScanner.log.error(parserConfigurationException.toString());
		}
	}

	/**
	 * Scan through org.w3c.dom.Document document.
	 *
	 * @param document the document
	 */
	public void visitDocument(final Document document) {
		final Element element = document.getDocumentElement();
		if (element != null) {
			if (element.getTagName().equals("Application")) {
				visitElement_wicast_Application(element);
			}
			if (element.getTagName().equals("Name")) {
				visitElement_Name(element);
			}
			if (element.getTagName().equals("Version")) {
				visitElement_Version(element);
			}
			if (element.getTagName().equals("Description")) {
				visitElement_Description(element);
			}
			if (element.getTagName().equals("Url")) {
				visitElement_Url(element);
			}
			if (element.getTagName().equals("Organization")) {
				visitElement_Organization(element);
			}
			if (element.getTagName().equals("Licenses")) {
				visitElement_Licenses(element);
			}
			if (element.getTagName().equals("Licence")) {
				visitElement_Licence(element);
			}
			if (element.getTagName().equals("Id")) {
				visitElement_Id(element);
			}
			if (element.getTagName().equals("Title")) {
				visitElement_Title(element);
			}
			if (element.getTagName().equals("Properties")) {
				visitElement_Properties(element);
			}
			if (element.getTagName().equals("Encoding")) {
				visitElement_Encoding(element);
			}
			if (element.getTagName().equals("Core")) {
				visitElement_Core(element);
			}
			if (element.getTagName().equals("Tools")) {
				visitElement_Tools(element);
			}
			if (element.getTagName().equals("Tool")) {
				visitElement_Tool(element);
			}
			if (element.getTagName().equals("name")) {
				visitElement_name(element);
			}
			if (element.getTagName().equals("class")) {
				visitElement_class(element);
			}
			if (element.getTagName().equals("Server")) {
				visitElement_Server(element);
			}
			if (element.getTagName().equals("Scheduler")) {
				visitElement_Scheduler(element);
			}
			if (element.getTagName().equals("Task")) {
				visitElement_Task(element);
			}
			if (element.getTagName().equals("Channel")) {
				visitElement_Channel(element);
			}
			if (element.getTagName().equals("Message")) {
				visitElement_Message(element);
			}
			if (element.getTagName().equals("Uri")) {
				visitElement_Uri(element);
			}
			if (element.getTagName().equals("File")) {
				visitElement_File(element);
			}
			if (element.getTagName().equals("WebAdmin")) {
				visitElement_WebAdmin(element);
			}
			if (element.getTagName().equals("Port")) {
				visitElement_Port(element);
			}
			if (element.getTagName().equals("Client")) {
				visitElement_Client(element);
			}
		}
	}

	/**
	 * Scan through Element named Channel.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Channel(final Element element) {
		final NamedNodeMap attrs = element.getAttributes();
		for (int i = 0; i < attrs.getLength(); i++) {
			final Attr attr = (Attr) attrs.item(i);
			if (attr.getName().equals("port")) {
			}
			if (attr.getName().equals("ip")) {
			}
			if (attr.getName().equals("name")) {
			}
		}

		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("Message")) {
						visitElement_Message(nodeElement);
					}
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named class.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_class(final Element element) {
		// <class>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Client.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Client(final Element element) {
		// <Client>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("Scheduler")) {
						visitElement_Scheduler(nodeElement);
					}
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Core.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Core(final Element element) {
		// <Core>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Description.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Description(final Element element) {
		// <Description>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Encoding.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Encoding(final Element element) {
		// <Encoding>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named File.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_File(final Element element) {
		// <File>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Id.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Id(final Element element) {
		// <Id>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Licence.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Licence(final Element element) {
		// <Licence>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("Name")) {
						visitElement_Name(nodeElement);
					}
					if (nodeElement.getTagName().equals("Url")) {
						visitElement_Url(nodeElement);
					}
					if (nodeElement.getTagName().equals("Id")) {
						visitElement_Id(nodeElement);
					}
					if (nodeElement.getTagName().equals("Title")) {
						visitElement_Title(nodeElement);
					}
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Licenses.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Licenses(final Element element) {
		// <Licenses>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("Licence")) {
						visitElement_Licence(nodeElement);
					}
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Message.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Message(final Element element) {
		// <Message>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("Uri")) {
						visitElement_Uri(nodeElement);
					}
					if (nodeElement.getTagName().equals("File")) {
						visitElement_File(nodeElement);
					}
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named name.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_name(final Element element) {
		// <name>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Name.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Name(final Element element) {
		// <Name>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Organization.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Organization(final Element element) {
		// <Organization>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Port.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Port(final Element element) {
		// <Port>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
				case Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Properties.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Properties(final Element element) {
		// <Properties>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("Encoding")) {
						visitElement_Encoding(nodeElement);
					}
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Scheduler.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Scheduler(final Element element) {
		// <Scheduler>
		// element.getValue();
		final NamedNodeMap attrs = element.getAttributes();
		for (int i = 0; i < attrs.getLength(); i++) {
			final Attr attr = (Attr) attrs.item(i);
			if (attr.getName().equals("class")) {
			}
			if (attr.getName().equals("name")) {
			}
		}
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("Task")) {
						visitElement_Task(nodeElement);
					}
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Server.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Server(final Element element) {
		// <Server>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("Scheduler")) {
						visitElement_Scheduler(nodeElement);
					}
					if (nodeElement.getTagName().equals("WebAdmin")) {
						visitElement_WebAdmin(nodeElement);
					}
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((org.w3c.dom.ProcessingInstruction)node).getTarget();
					// ((org.w3c.dom.ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Task.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Task(final Element element) {
		// <Task>
		// element.getValue();
		final NamedNodeMap attrs = element.getAttributes();
		for (int i = 0; i < attrs.getLength(); i++) {
			final Attr attr = (Attr) attrs.item(i);
			if (attr.getName().equals("class")) {
			}
			if (attr.getName().equals("name")) {
			}
		}
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("Channel")) {
						visitElement_Channel(nodeElement);
					}
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((ProcessingInstruction)node).getTarget();
					// ((ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Title.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Title(final Element element) {
		// <Title>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((ProcessingInstruction)node).getTarget();
					// ((ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Tool.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Tool(final Element element) {
		// <Tool>
		// element.getValue();
		final NamedNodeMap attrs = element.getAttributes();
		for (int i = 0; i < attrs.getLength(); i++) {
			final Attr attr = (Attr) attrs.item(i);
			if (attr.getName().equals("class")) {
			}
			if (attr.getName().equals("name")) {
			}
		}
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("name")) {
						visitElement_name(nodeElement);
					}
					if (nodeElement.getTagName().equals("class")) {
						visitElement_class(nodeElement);
					}
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((ProcessingInstruction)node).getTarget();
					// ((ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Tools.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Tools(final Element element) {
		// <Tools>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("Tool")) {
						visitElement_Tool(nodeElement);
					}
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((ProcessingInstruction)node).getTarget();
					// ((ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Uri.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Uri(final Element element) {
		// <Uri>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((ProcessingInstruction)node).getTarget();
					// ((ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Url.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Url(final Element element) {
		// <Url>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((org.w3c.dom.CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((ProcessingInstruction)node).getTarget();
					// ((ProcessingInstruction)node).getData();
					break;
				case Node.TEXT_NODE:
					// ((org.w3c.dom.Text)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named Version.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_Version(final Element element) {
		// <Version>
		// element.getValue();
		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((ProcessingInstruction)node).getTarget();
					// ((ProcessingInstruction)node).getData();
					break;
				case Node.TEXT_NODE:
					// ((Text)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named WebAdmin.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_WebAdmin(final Element element) {
		// <WebAdmin>
		// element.getValue();
		final NamedNodeMap attrs = element.getAttributes();

		for (int i = 0; i < attrs.getLength(); i++) {
			final Attr attr = (Attr) attrs.item(i);
			if (attr.getName().equals("class")) {
			}
		}

		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((CDATASection)node).getData();
					break;
				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("Url")) {
						visitElement_Url(nodeElement);
					}
					if (nodeElement.getTagName().equals("Port")) {
						visitElement_Port(nodeElement);
					}
					break;
				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((ProcessingInstruction)node).getTarget();
					// ((ProcessingInstruction)node).getData();
					break;
			}
		}
	}

	/**
	 * Scan through Element named wicast:Application.
	 *
	 * element
	 *
	 * @param element the element
	 */
	void visitElement_wicast_Application(final Element element) {
		// <wicast:Application>
		// element.getValue();
		final NamedNodeMap attrs = element.getAttributes();

		for (int i = 0; i < attrs.getLength(); i++) {
			final Attr attr = (Attr) attrs.item(i);
			if (attr.getName().equals("xsi:schemaLocation")) {
			}
			if (attr.getName().equals("xmlns:xsi")) {
			}
			if (attr.getName().equals("xmlns:wicast")) {
			}
		}

		final NodeList nodes = element.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node node = nodes.item(i);
			switch (node.getNodeType()) {
				case Node.CDATA_SECTION_NODE:
					// ((CDATASection)node).getData();
					break;

				case Node.ELEMENT_NODE:
					final Element nodeElement = (Element) node;
					if (nodeElement.getTagName().equals("Name")) {
						visitElement_Name(nodeElement);
					}
					if (nodeElement.getTagName().equals("Version")) {
						visitElement_Version(nodeElement);
					}
					if (nodeElement.getTagName().equals("Description")) {
						visitElement_Description(nodeElement);
					}
					if (nodeElement.getTagName().equals("Url")) {
						visitElement_Url(nodeElement);
					}
					if (nodeElement.getTagName().equals("Organization")) {
						visitElement_Organization(nodeElement);
					}
					if (nodeElement.getTagName().equals("Licenses")) {
						visitElement_Licenses(nodeElement);
					}
					if (nodeElement.getTagName().equals("Properties")) {
						visitElement_Properties(nodeElement);
					}
					if (nodeElement.getTagName().equals("Core")) {
						visitElement_Core(nodeElement);
					}
					if (nodeElement.getTagName().equals("Tools")) {
						visitElement_Tools(nodeElement);
					}
					if (nodeElement.getTagName().equals("Server")) {
						visitElement_Server(nodeElement);
					}
					if (nodeElement.getTagName().equals("Client")) {
						visitElement_Client(nodeElement);
					}
					break;

				case Node.PROCESSING_INSTRUCTION_NODE:
					// ((ProcessingInstruction)node).getTarget();
					// ((ProcessingInstruction)node).getData();
					break;
			}
		}
	}
}
