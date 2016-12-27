package by.htp.afisha.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Film extends Event{
	private double rating;
	private Genre genre;

	
	public Film(){
		super();
	}

	public Film(Date date, String title, String time, String place, BigDecimal cost, double rating, Genre genre) {
		super(date, title,time, place, cost);
		
		
		this.rating = rating;
		this.genre = genre;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (genre != other.genre)
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "rating=" + rating + ", " + "genre=" + genre;
	}
	
	
		

	
	

}
