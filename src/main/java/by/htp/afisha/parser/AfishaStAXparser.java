package by.htp.afisha.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.SAXException;

public class AfishaStAXparser {
	 public static void main(String[] args) {
		 
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
			
	     try {
	    	 XMLInputFactory factory = XMLInputFactory.newInstance();
	         XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("src\\main\\resources\\Afisha.xml"));

	         while(eventReader.hasNext()){
	               XMLEvent event = eventReader.nextEvent();
	               
	               switch(event.getEventType()){
	               		case XMLStreamConstants.START_ELEMENT:
	               			StartElement startElement = event.asStartElement();
	               			String qName = startElement.getName().getLocalPart();
	               			
	               			if (qName.equals("film")) {
	               				System.out.println("Start Element : film");	                        
	               			} else if (qName.equals("opera")) {
		                        System.out.println("Start Element : opera");		                        
	               			} else  if (qName.equals("exhibition")) {
			                    System.out.println("Start Element : exhibition");    
		                        
	                        Iterator<Attribute> attributes = startElement.getAttributes();
	                      
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
	                    break;
	                     
	               		case XMLStreamConstants.CHARACTERS:
	               			Characters characters = event.asCharacters();
	               			
	               			if (bTitle){
	               				System.out.println("Title: " + characters.getData());
	               				bTitle = false;
	               			}else if (bDate){
	               				System.out.println("Date: " + characters.getData());
	               				bDate = false;
	               			} else if (bTime){
	               				System.out.println("Time: " + characters.getData());
	               				bTime = false;
	               			}else if (bPlace){
	               				System.out.println("Place: " + characters.getData());
	               				bPlace = false;
	               			} else if (bCost){
	               				System.out.println("Cost: " + characters.getData());
	               				bCost = false;
	               			} else if (bGenre){
	               				System.out.println("Genre: " + characters.getData());
	               				bGenre = false;
	               			} else if (bRating){
	               				System.out.println("Rating: " + characters.getData());
	               				bRating = false;
	               			} else if (bSinger){
	               				System.out.println("Singer: " + characters.getData());
	               				bSinger = false;
	               			} else if (bAuthor){
	               				System.out.println("Author: " + characters.getData());
	               				bAuthor = false;
	               			} else if (bTheme){
	               				System.out.println("Theme: " + characters.getData());
	               				bTheme = false;
	               			}	
	                    break;
	                     
	               		case XMLStreamConstants.END_ELEMENT:
	               			EndElement endElement = event.asEndElement();
	               			
	               			if(endElement.getName().getLocalPart().equals("film")){
	               				System.out.println("End Element : film");
	               			} else if(endElement.getName().getLocalPart().equals("opera")){
		                        System.out.println("End Element : opera");
	               			} else if(endElement.getName().getLocalPart().equals("exhibition")){
			                    System.out.println("End Element : exhibition");			                   
	               			}
	                    break;
	               	}		    
	            }
	         
	         } catch (XMLStreamException e) {
	            e.printStackTrace();
	         } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
}	 
	 

