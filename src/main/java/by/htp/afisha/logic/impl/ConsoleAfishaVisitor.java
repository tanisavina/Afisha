package by.htp.afisha.logic.impl;

import java.util.Date;

import by.htp.afisha.entity.Afisha;
import by.htp.afisha.entity.Event;
import by.htp.afisha.logic.*;

public class ConsoleAfishaVisitor implements AfishaVisitor {
		
	@Override
	public void loadAfisha(Afisha afisha) {
		// TODO Auto-generated method stub
		System.out.println("Афиша: ");
		for(Event event: afisha.viewEvents()){			
			System.out.println(event);
		}
		
		Date dateQ = null;		
		for(Event event: afisha.viewEvents(afisha, dateQ)){
			System.out.println("События в указанную дату: " + event);			
		}
				
		Date begin = null;
		Date end = null;
		for(Event event: afisha.viewEvents(afisha, begin, end)){
			System.out.println(event);			
		}
	
	}
}
