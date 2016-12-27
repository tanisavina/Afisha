
package by.htp.afisha.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

public class MainReadFile {	
	
private final static Logger log = LogManager.getLogger();
	
	public static void main(String[] args){		
		
		File file = new File("src\\main\\resources\\AfishaReader.txt");
		
		FileReader reader = null;
		
		try {
			reader = new FileReader(file);			
		} catch (Exception e) {			
			log.error("File Not Found");		
		}
		
		char[] array = new char[(int)file.length()];
		
		try {
			reader.read(array);
		} catch (Exception e) {
			log.error("Not Read File");
		}
		
		String str = String.valueOf(array);		
		String[] strArray = str.split(", ");
		
		SimpleDateFormat format = new SimpleDateFormat();		
	    format.applyPattern("dd.MM.yyyy");
	    
		Date date1 = null, date2 = null, date3 = null;
		String title1 = null, title2 = null, title3 = null;
		String time1 = null, time2 = null, time3 = null;
		String place1 = null, place2 = null, place3 = null;
		BigDecimal cost1 = null, cost2 = null, cost3 = null;
		double rating1 = 0;		
		Genre genre1 = null;
		Singer singer2 = null;
		String author = null;
		String theme = null;		
		String author3 = null;
		String theme3 = null;
		
		for(int i = 0; i < strArray.length; i++){
			try {
				date1 = format.parse(strArray[0]);
				title1 = strArray[1];
				time1 = strArray[2];
				place1 = strArray[3];
				cost1 = new BigDecimal(strArray[4]);
				rating1 = new Double(strArray[5]);
				genre1 = Genre.parse(strArray[6]);
				
				date2 = format.parse(strArray[7]);
				title2 = strArray[8];
				time2 = strArray[9];
				place2 = strArray[10];
				cost2 = new BigDecimal(strArray[11]);
				singer2 = new Singer(strArray[12]);
				
				date3 = format.parse(strArray[13]);
				title3 = strArray[14];
				time3 = strArray[15];
				place3 = strArray[16];
				cost3 = new BigDecimal(strArray[17]);
				author3 = strArray[18];
				theme3 = strArray[19];				
				
			} catch (Exception e) {
				log.error("Some error happens");
			}				
		}	 
	    
		Event film = new Film(date1, title1,  time1, place1, cost1, rating1, genre1);		
		Event opera = new Opera(date2, title2,  time2, place2, cost2, singer2);		
		Event exhibition = new Exhibition(date3, title3,  time3, place3, cost3, author3, theme3);
		
		Afisha afisha = new Afisha("Minsk");
		Afisha.addEvent(film);
		Afisha.addEvent(opera);
		Afisha.addEvent(exhibition);
		
		AfishaVisitor visitor = new ConsoleAfishaVisitor();
		visitor.loadAfisha(afisha);
		
		AfishaVisitor visitor1 = new FileAfishaVisitor();
		visitor1.loadAfisha(afisha);			
		
	}
}
