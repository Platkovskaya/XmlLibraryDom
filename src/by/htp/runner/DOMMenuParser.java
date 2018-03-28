package by.htp.runner;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMMenuParser {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(new File("resources/library.xml"));

		String root = document.getDocumentElement().getNodeName();
		System.out.println("root = " + root);
		NodeList editionNodes = document.getElementsByTagName("edition");

		String name = " ";
		String author = " ";
		System.out.println("name / author");
		for (int i = 0; i < editionNodes.getLength(); i++) {
			Element editionElement = (Element) editionNodes.item(i);
			name = editionElement.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
			author = editionElement.getElementsByTagName("author").item(0).getChildNodes().item(0).getNodeValue();
			System.out.println(name + "" + " / " + author + "");

		}
	}
}