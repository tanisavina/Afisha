package by.htp.afisha.logic.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.Writer;

import by.htp.afisha.entity.Afisha;
import by.htp.afisha.entity.Event;
import by.htp.afisha.logic.impl.AfishaVisitor;

public class FileAfishaVisitor implements AfishaVisitor {

	@Override
	public void loadAfisha(Afisha afisha) {
		// TODO Auto-generated method stub
				
		File file = new File("src\\main\\resources\\AfishaWriter.txt");
	
		for(Event event: afisha.getEvents()){
		
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));	
				writer.write(event.toString()+ "\r\n");
				writer.flush();				
			}
			catch(IOException ex){
				System.out.println(ex.getMessage());
			}
		}
	}	
}

