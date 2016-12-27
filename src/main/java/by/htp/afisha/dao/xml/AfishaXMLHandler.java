 package by.htp.afisha.dao.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.afisha.entity.Event;
import by.htp.afisha.entity.Exhibition;
import by.htp.afisha.entity.Film;
import by.htp.afisha.entity.Opera;

public class AfishaXMLHandler extends DefaultHandler{
	
	private String value;
	
	boolean bTitle = false;
	boolean bDate = false;
	boolean bTime = false;
	boolean bPlace = false;
	boolean bCost = false;
	boolean bGenre = false;
	boolean bRating = false;
	boolean bSinger = false;	
	boolean bAuthor = false;	
	boolean bTheme = false;

	@Override
	public void characters(char[] ch, int start, int length) 
			throws SAXException {		
		if (bTitle){
			System.out.println("Title: " + new String(ch,start,length));
			bTitle = false;
		}else if (bDate){
			System.out.println("Date: " + new String(ch,start,length));
			bDate = false;
		} else if (bTime){
			System.out.println("Time: " + new String(ch,start,length));
			bTime = false;
		}else if (bPlace){
			System.out.println("Place: " + new String(ch,start,length));
			bPlace = false;
		} else if (bCost){
			System.out.println("Cost: " + new String(ch,start,length));
			bCost = false;
		} else if (bGenre){
			System.out.println("Genre: " + new String(ch,start,length));
			bGenre = false;
		} else if (bRating){
			System.out.println("Rating: " + new String(ch,start,length));
			bRating = false;
		} else if (bSinger){
			System.out.println("Singer: " + new String(ch,start,length));
			bSinger = false;
		} else if (bAuthor){
			System.out.println("Author: " + new String(ch,start,length));
			bAuthor = false;
		} else if (bTheme){
			System.out.println("Theme: " + new String(ch,start,length));
			bTheme = false;
		}	
		
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDocument");	
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("film")){
		System.out.println("endElement:" + qName);		
		}
		if (qName.equals("opera")){
			System.out.println("endElement:" + qName);		
		}
		if (qName.equals("exhibition")){
			System.out.println("endElement:" + qName);		
		}
	}

	@Override
	public void startDocument() throws SAXException {	
		System.out.println("startDocument: Afisha");		
	}

	@Override
	public void startElement(String uri, String licalName, String qName, Attributes attributes) throws SAXException {		
		Event event;
		if (qName.equals("events")){ 
			String type = attributes.getValue("qName");	
			System.out.println(qName);
			if (type!=null){
				switch (type){
					case "film":
						event = new Film();					
						break;
					case "opera":
						event = new Opera();
						break;
					case "exhibition":
						event = new Exhibition();
						break;
				}
			}
			
		} else if (qName.equals("film")){				
			String film = attributes.getValue("qName");
			System.out.println("startElement: " + qName);				
		} else if (qName.equals("opera")){				
			String opera = attributes.getValue("qName");
			System.out.println("startElement: " + qName);				
		} else if (qName.equals("exhibition")){					
			String exhibition = attributes.getValue("qName");
			System.out.println("startElement: " + qName);
			
		} else if (qName.equals("title")){
			bTitle = true;
		} else if (qName.equals("date")){
			bDate = true;
		} else if (qName.equals("time")){
			bTime = true;
		} else if (qName.equals("place")){
			bPlace = true;
		} else if (qName.equals("cost")){
			bCost = true;
		}else if (qName.equals("genre")){
			bGenre = true;
		}else if (qName.equals("rating")){
			bRating = true;			
		}else if (qName.equals("singer")){
			bSinger = true;
		}else if (qName.equals("author")){
			bAuthor = true;
		}else if (qName.equals("theme")){
			bTheme = true;
		}			
	}
}

	





	


