package by.htp.afisha.parser;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import by.htp.afisha.entity.Event;
import by.htp.afisha.entity.Exhibition;
import by.htp.afisha.entity.Film;
import by.htp.afisha.entity.Genre;
import by.htp.afisha.entity.Opera;
import by.htp.afisha.entity.Singer;


public class AfishaDOMparser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		Document document;
		Element afishaRoot;
		
		NodeList eventsNode = null;
		
		
		try {
			builder = factory.newDocumentBuilder();		
			document = builder.parse(new InputSource("src\\main\\resources\\Afisha.xml"));	
			
			afishaRoot = document.getDocumentElement(); //root element
			
			String att = afishaRoot.getAttribute("city");
			System.out.println(att);
		
		eventsNode = afishaRoot.getElementsByTagName("events"); //get all events as Nodes(tags)
		for (int i = 0; i < eventsNode.getLength(); i++){
			Element events = (Element) eventsNode.item(i); //get concrete event tag as Element edistvenn events
			
			NodeList allEvents = events.getChildNodes(); // get all event tags opera.film
			
			for (int j = 0; j < allEvents.getLength(); j++){
				Node eventNode = allEvents.item(j); // concrete event Node title.place
			
			Element eventElement;
			
			if (eventNode.getNodeType() == 1){   // govorot chto tip - element
				eventElement = (Element) eventNode;
				Event eventEntity = buildEvent(eventElement, eventNode.getNodeName());
				System.out.println(eventEntity);
			}
				
			}
		}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
			
		public static String getSingleElementContent(Element element, String tagName){
			
			NodeList list = element.getElementsByTagName(tagName);
			Element el = (Element) list.item(0);
			
			String content = el.getTextContent().trim();
			return content;
		}
		
		public static Event buildEvent(Element element, String nodeName) throws ParseException{
			Event event = null;
			System.out.println("nodeName: " + nodeName);
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			switch (nodeName) {
			case "film":
				Film film = new Film();
				film.setDate(df.parse(getSingleElementContent(element, "date")));
				film.setTitle(getSingleElementContent(element,"title"));
				film.setTime(getSingleElementContent(element, "time"));
				film.setPlace(getSingleElementContent(element, "place"));
				film.setCost(new BigDecimal(getSingleElementContent(element, "cost")));				
				film.setRating(Double.parseDouble(getSingleElementContent(element, "rating")));
				film.setGenre(Genre.valueOf(getSingleElementContent(element, "genre").toUpperCase()));
				event = film;
				break;
			case "opera":
				Opera opera = new Opera();
				opera.setTitle(getSingleElementContent(element,"title"));
				opera.setPlace(getSingleElementContent(element, "place"));
				opera.setCost(new BigDecimal(getSingleElementContent(element, "cost")));
				opera.setDate(df.parse(getSingleElementContent(element, "date")));
				opera.setTime(getSingleElementContent(element, "time"));
				opera.setSinger(new Singer(getSingleElementContent(element, "singer")));				
				event = opera;
				break;
			case "exhibition":
				Exhibition exhibition = new Exhibition();
				exhibition.setTitle(getSingleElementContent(element,"title"));
				exhibition.setPlace(getSingleElementContent(element, "place"));
				exhibition.setCost(new BigDecimal(getSingleElementContent(element, "cost")));
				exhibition.setDate(df.parse(getSingleElementContent(element, "date")));
				exhibition.setTime(getSingleElementContent(element, "time"));
				exhibition.setAuthor(getSingleElementContent(element, "author"));
				exhibition.setTheme(getSingleElementContent(element, "theme"));
				event = exhibition;
				break;				
			}
			return event;
		}

	}


