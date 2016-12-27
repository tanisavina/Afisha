
package by.htp.afisha.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.afisha.entity.*;
import by.htp.afisha.logic.impl.AfishaVisitor;
import by.htp.afisha.logic.impl.ConsoleAfishaVisitor;
import by.htp.afisha.logic.impl.FileAfishaVisitor;

public class Main {	
	
private final static Logger log = LogManager.getLogger();
	
	public static void main(String[] args){
	
	    SimpleDateFormat format = new SimpleDateFormat();
	    format.applyPattern("dd-MM-yyyy");
	    
		Date date1 = null;
		Date date2 = null;
		Date date3 = null;
		
	    
	    try {	
	    	date1 = format.parse("12-11-2016");
	    	date2 = format.parse("23-11-2016");
	    	date3 = format.parse("30-11-2016");
	    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Some error happens");
		}
	    
		Event film = new Film(date1, "White shark",  "18:30", "Moskva", new BigDecimal(2.00), 5, Genre.COMEDY);
		Event opera = new Opera(date2, "Snegurochka", "17:00", "Russkiy", new BigDecimal(4.50), new Singer("Ivanov"));
		Event exhibition = new Exhibition(date3, "Impressionizm", "09:00", "ArtMuzeum", new BigDecimal(1.50), "Petrov", "Art");
		
		Afisha afisha = new Afisha("Minsk");
		Afisha.addEvent(film);
		Afisha.addEvent(opera);
		Afisha.addEvent(exhibition);
		
		AfishaVisitor visitor = new ConsoleAfishaVisitor();
		visitor.loadAfisha(afisha);
		
		AfishaVisitor visitor1 = new FileAfishaVisitor();
		visitor1.loadAfisha(afisha);	
		
		/*			
		
		try {
			ResourceBundle bundleRu = ResourceBundle.getBundle("config",new Locale("ru_Ru"));
			ResourceBundle bundleEN = ResourceBundle.getBundle("config",Locale.ENGLISH);
			System.out.println(bundleRu.getString("name"));
			System.out.println(bundleEN.getString("name"));
		} 

		catch (Exception e) {	
			log.error("Some error happens");
			log.info("new event was created");
			
		}*/
	}
}

