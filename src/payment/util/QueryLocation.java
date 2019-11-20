package payment.util;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import payment.util.Constants;
/*
 * This class use to load SQL queris from PaymentQueries.xml
 * 
 */
public class QueryLocation{
	public static String paymentQueryIDs(String id) throws SAXException, IOException, ParserConfigurationException {
		
		NodeList nodeList;
		
		//Represents an element in an HTML or XML document
		Element elem = null;

		//obtain a parser that produces DOM object trees(tree structure) from XML documents.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//obtain a Document from XML
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//Parse PaymentQuerie.xml nodes to nodeList
		nodeList = builder.parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\EventPlaningWebApp\\WEB-INF\\PaymentQuery.xml")).getElementsByTagName(Constants.TAG);
		
		/*
		 * Extract the node from node list using query id
		 */
		for (int count = 0; count < nodeList.getLength(); count++) {
			
			elem = (Element) nodeList.item(count);
			
			if (elem.getAttribute(Constants.ID).equals(id)) {
				break;
			}
				
		}
		return elem.getTextContent().trim();
	}
}
