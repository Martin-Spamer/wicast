package net.wicast;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;

public class ApplicationScannerTest {

    /**
     * Test method for
     * {@link net.wicast.ApplicationScanner#ApplicationScanner(org.w3c.dom.Document)}.
     */
    @Test
    public void testApplicationScanner() {
        new ApplicationScanner();
    }

    @Test
    public void testApplicationScannerWithDocument() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = null;
        DocumentBuilder documentBuilder = null;
        Document document = null;

        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.newDocument();
        new ApplicationScanner(document);
    }

}
