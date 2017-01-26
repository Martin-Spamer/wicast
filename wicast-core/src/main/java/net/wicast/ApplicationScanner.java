/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */
package net.wicast;

/**
 * The ApplicationScanner Class.
 */
public class ApplicationScanner {
    /**
     * org.w3c.dom.Document document
     */
    org.w3c.dom.Document document;

    /**
     * Create new ApplicationScanner with org.w3c.dom.Document.
     * @param document the document
     */
    public ApplicationScanner(final org.w3c.dom.Document document) {
        this.document = document;
    }

    /**
     * Scan through org.w3c.dom.Document document.
     */
    public void visitDocument() {
        final org.w3c.dom.Element element = document.getDocumentElement();
        if (element != null && element.getTagName().equals("wicast:Application")) {
            visitElement_wicast_Application(element);
        }
        if (element != null && element.getTagName().equals("Name")) {
            visitElement_Name(element);
        }
        if (element != null && element.getTagName().equals("Version")) {
            visitElement_Version(element);
        }
        if (element != null && element.getTagName().equals("Description")) {
            visitElement_Description(element);
        }
        if (element != null && element.getTagName().equals("Url")) {
            visitElement_Url(element);
        }
        if (element != null && element.getTagName().equals("Organization")) {
            visitElement_Organization(element);
        }
        if (element != null && element.getTagName().equals("Licenses")) {
            visitElement_Licenses(element);
        }
        if (element != null && element.getTagName().equals("Licence")) {
            visitElement_Licence(element);
        }
        if (element != null && element.getTagName().equals("Id")) {
            visitElement_Id(element);
        }
        if (element != null && element.getTagName().equals("Title")) {
            visitElement_Title(element);
        }
        if (element != null && element.getTagName().equals("Properties")) {
            visitElement_Properties(element);
        }
        if (element != null && element.getTagName().equals("Encoding")) {
            visitElement_Encoding(element);
        }
        if (element != null && element.getTagName().equals("Core")) {
            visitElement_Core(element);
        }
        if (element != null && element.getTagName().equals("Tools")) {
            visitElement_Tools(element);
        }
        if (element != null && element.getTagName().equals("Tool")) {
            visitElement_Tool(element);
        }
        if (element != null && element.getTagName().equals("name")) {
            visitElement_name(element);
        }
        if (element != null && element.getTagName().equals("class")) {
            visitElement_class(element);
        }
        if (element != null && element.getTagName().equals("Server")) {
            visitElement_Server(element);
        }
        if (element != null && element.getTagName().equals("Scheduler")) {
            visitElement_Scheduler(element);
        }
        if (element != null && element.getTagName().equals("Task")) {
            visitElement_Task(element);
        }
        if (element != null && element.getTagName().equals("Channel")) {
            visitElement_Channel(element);
        }
        if (element != null && element.getTagName().equals("Message")) {
            visitElement_Message(element);
        }
        if (element != null && element.getTagName().equals("Uri")) {
            visitElement_Uri(element);
        }
        if (element != null && element.getTagName().equals("File")) {
            visitElement_File(element);
        }
        if (element != null && element.getTagName().equals("WebAdmin")) {
            visitElement_WebAdmin(element);
        }
        if (element != null && element.getTagName().equals("Port")) {
            visitElement_Port(element);
        }
        if (element != null && element.getTagName().equals("Client")) {
            visitElement_Client(element);
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Channel.
     * @param element the element
     */
    void visitElement_Channel(final org.w3c.dom.Element element) {
        // <Channel>
        // element.getValue();
        final org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            final org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("port")) {
            }
            if (attr.getName().equals("ip")) {
            }
            if (attr.getName().equals("name")) {
            }
        }
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                if (nodeElement.getTagName().equals("Message")) {
                    visitElement_Message(nodeElement);
                }
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named class.
     * @param element the element
     */
    void visitElement_class(final org.w3c.dom.Element element) {
        // <class>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            case org.w3c.dom.Node.TEXT_NODE:
                // ((org.w3c.dom.Text)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Client.
     * @param element the element
     */
    void visitElement_Client(final org.w3c.dom.Element element) {
        // <Client>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                if (nodeElement.getTagName().equals("Scheduler")) {
                    visitElement_Scheduler(nodeElement);
                }
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Core.
     * @param element the element
     */
    void visitElement_Core(final org.w3c.dom.Element element) {
        // <Core>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            case org.w3c.dom.Node.TEXT_NODE:
                // ((org.w3c.dom.Text)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Description.
     * @param element the element
     */
    void visitElement_Description(final org.w3c.dom.Element element) {
        // <Description>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            case org.w3c.dom.Node.TEXT_NODE:
                // ((org.w3c.dom.Text)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Encoding.
     * @param element the element
     */
    void visitElement_Encoding(final org.w3c.dom.Element element) {
        // <Encoding>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            case org.w3c.dom.Node.TEXT_NODE:
                // ((org.w3c.dom.Text)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named File.
     * @param element the element
     */
    void visitElement_File(final org.w3c.dom.Element element) {
        // <File>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Id.
     * @param element the element
     */
    void visitElement_Id(final org.w3c.dom.Element element) {
        // <Id>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Licence.
     * @param element the element
     */
    void visitElement_Licence(final org.w3c.dom.Element element) {
        // <Licence>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
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
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Licenses.
     * @param element the element
     */
    void visitElement_Licenses(final org.w3c.dom.Element element) {
        // <Licenses>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                if (nodeElement.getTagName().equals("Licence")) {
                    visitElement_Licence(nodeElement);
                }
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Message.
     * @param element the element
     */
    void visitElement_Message(final org.w3c.dom.Element element) {
        // <Message>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                if (nodeElement.getTagName().equals("Uri")) {
                    visitElement_Uri(nodeElement);
                }
                if (nodeElement.getTagName().equals("File")) {
                    visitElement_File(nodeElement);
                }
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            case org.w3c.dom.Node.TEXT_NODE:
                // ((org.w3c.dom.Text)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named name.
     * @param element the element
     */
    void visitElement_name(final org.w3c.dom.Element element) {
        // <name>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            case org.w3c.dom.Node.TEXT_NODE:
                // ((org.w3c.dom.Text)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Name.
     * @param element the element
     */
    void visitElement_Name(final org.w3c.dom.Element element) {
        // <Name>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            case org.w3c.dom.Node.TEXT_NODE:
                // ((org.w3c.dom.Text)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Organization.
     * @param element the element
     */
    void visitElement_Organization(final org.w3c.dom.Element element) {
        // <Organization>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            case org.w3c.dom.Node.TEXT_NODE:
                // ((org.w3c.dom.Text)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Port.
     * @param element the element
     */
    void visitElement_Port(final org.w3c.dom.Element element) {
        // <Port>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            case org.w3c.dom.Node.TEXT_NODE:
                // ((org.w3c.dom.Text)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Properties.
     * @param element the element
     */
    void visitElement_Properties(final org.w3c.dom.Element element) {
        // <Properties>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                if (nodeElement.getTagName().equals("Encoding")) {
                    visitElement_Encoding(nodeElement);
                }
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Scheduler.
     * @param element the element
     */
    void visitElement_Scheduler(final org.w3c.dom.Element element) {
        // <Scheduler>
        // element.getValue();
        final org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            final org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("class")) {
            }
            if (attr.getName().equals("name")) {
            }
        }
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                if (nodeElement.getTagName().equals("Task")) {
                    visitElement_Task(nodeElement);
                }
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Server.
     * @param element the element
     */
    void visitElement_Server(final org.w3c.dom.Element element) {
        // <Server>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                if (nodeElement.getTagName().equals("Scheduler")) {
                    visitElement_Scheduler(nodeElement);
                }
                if (nodeElement.getTagName().equals("WebAdmin")) {
                    visitElement_WebAdmin(nodeElement);
                }
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Task.
     * @param element the element
     */
    void visitElement_Task(final org.w3c.dom.Element element) {
        // <Task>
        // element.getValue();
        final org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            final org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("class")) {
            }
            if (attr.getName().equals("name")) {
            }
        }
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                if (nodeElement.getTagName().equals("Channel")) {
                    visitElement_Channel(nodeElement);
                }
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Title.
     * @param element the element
     */
    void visitElement_Title(final org.w3c.dom.Element element) {
        // <Title>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Tool.
     * @param element the element
     */
    void visitElement_Tool(final org.w3c.dom.Element element) {
        // <Tool>
        // element.getValue();
        final org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            final org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("class")) {
            }
            if (attr.getName().equals("name")) {
            }
        }
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                if (nodeElement.getTagName().equals("name")) {
                    visitElement_name(nodeElement);
                }
                if (nodeElement.getTagName().equals("class")) {
                    visitElement_class(nodeElement);
                }
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Tools.
     * @param element the element
     */
    void visitElement_Tools(final org.w3c.dom.Element element) {
        // <Tools>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                if (nodeElement.getTagName().equals("Tool")) {
                    visitElement_Tool(nodeElement);
                }
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Uri.
     * @param element the element
     */
    void visitElement_Uri(final org.w3c.dom.Element element) {
        // <Uri>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Url.
     * @param element the element
     */
    void visitElement_Url(final org.w3c.dom.Element element) {
        // <Url>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            case org.w3c.dom.Node.TEXT_NODE:
                // ((org.w3c.dom.Text)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Version.
     * @param element the element
     */
    void visitElement_Version(final org.w3c.dom.Element element) {
        // <Version>
        // element.getValue();
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            case org.w3c.dom.Node.TEXT_NODE:
                // ((org.w3c.dom.Text)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named WebAdmin.
     * @param element the element
     */
    void visitElement_WebAdmin(final org.w3c.dom.Element element) {
        // <WebAdmin>
        // element.getValue();
        final org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            final org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("class")) {
            }
        }
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                if (nodeElement.getTagName().equals("Url")) {
                    visitElement_Url(nodeElement);
                }
                if (nodeElement.getTagName().equals("Port")) {
                    visitElement_Port(nodeElement);
                }
                break;
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named wicast:Application.
     * @param element the element
     */
    void visitElement_wicast_Application(final org.w3c.dom.Element element) {
        // <wicast:Application>
        // element.getValue();
        final org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            final org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("xsi:schemaLocation")) {
            }
            if (attr.getName().equals("xmlns:xsi")) {
            }
            if (attr.getName().equals("xmlns:wicast")) {
            }
        }
        final org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            final org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
            case org.w3c.dom.Node.CDATA_SECTION_NODE:
                // ((org.w3c.dom.CDATASection)node).getData();
                break;
            case org.w3c.dom.Node.ELEMENT_NODE:
                final org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
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
            case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                // ((org.w3c.dom.ProcessingInstruction)node).getData();
                break;
            }
        }
    }
}
