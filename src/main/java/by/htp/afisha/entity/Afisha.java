package by.htp.afisha.entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;

public class Afisha {
	private static Set<Event> events;
	private static Set<Event> events1;
	private static Set<Event> events2;
	private String city;
	
	public Afisha(String city){
		events = new HashSet<Event>();	
		events1 = new HashSet<Event>();	
		events2 = new HashSet<Event>();	
		this.city = city; 
	}
	File file = new File("Afisha.txt");
	
	public Set<Event> viewEvents(){
		return events;
	}
	
	public Set<Event> viewEvents(Afisha afisha, Date dateQ){
		Scanner scanner = new Scanner(System.in);		
		System.out.print("введите дату");
		String s = scanner.nextLine();
		
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd-MM-yyyy");
		try {
			dateQ = format.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Event event: events){	
			
			if (dateQ.equals(event.getDate())){
				events1.add(event);						
			}
		}		
		return events1;			
	}	
	
	public Set<Event> viewEvents(Afisha afisha, Date begin, Date end){
		
		Scanner scanner = new Scanner(System.in);		
		System.out.print("введите начало периода дат");
		String p = scanner.nextLine();
		System.out.print("введите конец периода дат");
		String r = scanner.nextLine();
		System.out.println("события в указанный период дат: ");
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd-MM-yyyy");
		try {
			begin = format.parse(p);
			end = format.parse(r);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Event event: events){			
			if (begin.before(event.getDate())||(begin.equals(event.getDate()))&&(end.after(event.getDate())||(end.equals(event.getDate())))){
				events2.add(event);						
			}
		}		
		return events2;			
		
}

	
	public static boolean addEvent(Event event){
		if (event != null){
			return events.add(event);		
		}
		return false;
	}
		
	
	public Set<Event> getEvents() {
		return events;
	}



	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	
	@Override
	public String toString() {
		return "Afisha [events=" + events + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Afisha other = (Afisha) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		return true;
	}

	public String getCity() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
