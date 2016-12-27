package by.htp.afisha.runner;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import by.htp.afisha.entity.Afisha;
import by.htp.afisha.entity.Exhibition;
import by.htp.afisha.entity.Film;
import by.htp.afisha.entity.Genre;
import by.htp.afisha.entity.Opera;
import by.htp.afisha.entity.Singer;
import by.htp.afisha.logic.impl.AfishaVisitor;
import by.htp.afisha.logic.impl.ConsoleAfishaVisitor;
import by.htp.afisha.logic.impl.FileAfishaVisitor;

public class MainBD {
	public static void main(String[] args){		
		
		Date date = null;
		String title = null;
		String time = null;
		String place = null;
		BigDecimal cost = null;
		Double rating = null;
		Genre genre = null;
		Singer singer = null;
		String author = null;
		String theme = null;
		
		Film film = new Film();
		Opera opera = new Opera();
		Exhibition exhibition = new Exhibition();
		
		
		Connection connection = null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afisha", "root", "root");			
			
			Statement st = connection.createStatement();			
			ResultSet rs = st.executeQuery("select * from event WHERE name = 'film';");
			
			while(rs.next()){
				
				date = rs.getDate("date");
				title = rs.getString("title");
				time = rs.getString("time");
				place = rs.getString("place");
				cost = rs.getBigDecimal("cost");
				rating = rs.getDouble("rating");
				genre = Genre.valueOf(rs.getString("genre"));
								
				film.setDate(date);
				film.setTitle(title);
				film.setTime(time);
				film.setPlace(place);
				film.setCost(cost);				
				film.setRating(rating);
				film.setGenre(genre);
								
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afisha", "root", "root");			
			
			Statement st = connection.createStatement();			
			ResultSet rs = st.executeQuery("select * from event WHERE name = 'opera';");
			
			while(rs.next()){
				
				date = rs.getDate("date");
				title = rs.getString("title");
				time = rs.getString("time");
				place = rs.getString("place");
				cost = rs.getBigDecimal("cost");
				singer = new Singer(rs.getString("singer"));
				
											
				opera.setDate(date);
				opera.setTitle(title);
				opera.setTime(time);
				opera.setPlace(place);
				opera.setCost(cost);					
				opera.setSinger(singer);
								
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afisha", "root", "root");			
			
			Statement st = connection.createStatement();			
			ResultSet rs = st.executeQuery("select * from event WHERE name = 'exhibition';");
			
			while(rs.next()){
				
				date = rs.getDate("date");
				title = rs.getString("title");
				time = rs.getString("time");
				place = rs.getString("place");
				author = rs.getString("author");
				theme = rs.getString("theme");
											
				exhibition.setDate(date);
				exhibition.setTitle(title);
				exhibition.setTime(time);
				exhibition.setPlace(place);
				exhibition.setCost(cost);					
				exhibition.setAuthor(author);
				exhibition.setTheme(theme);
								
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afisha", "root", "root");			
			
			Statement st = connection.createStatement();			
			int rs = st.executeUpdate("insert into event(id, title, cost, time, date, rating, place, genre, name) values('4', 'Amelie', '7', '21:15', '2016-12-26', '5', 'Belarus', 'DRAMA', 'film')");		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	/*	try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afisha", "root", "root");			
			
			Statement st = connection.createStatement();			
			int rs = st.executeUpdate("update event set genre = 'COMEDY' where id = '4'");		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/afisha", "root", "root");			
			
			Statement st = connection.createStatement();			
			int rs = st.executeUpdate("delete from event where id = '4'");		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
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
