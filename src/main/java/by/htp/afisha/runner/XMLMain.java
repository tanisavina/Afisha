package by.htp.afisha.runner;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.afisha.dao.xml.AfishaXMLHandler;

public class XMLMain {

	public static void main(String[] args) throws SAXException, IOException{
		
		XMLReader reader = XMLReaderFactory.createXMLReader();
		
		InputSource source = new InputSource("src\\main\\resources\\Afisha.xml");
		
		AfishaXMLHandler handler = new AfishaXMLHandler();		
		reader.setContentHandler(handler);
		
		reader.parse(source);		
	}
}
