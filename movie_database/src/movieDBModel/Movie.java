package movieDBModel;

import java.util.Collection;
import java.util.Collections;

public class Movie 
{
	private String title;
	private int year;
	private String director;
	private Collection<String> cast;
	
	public Movie(String title, int year, String director, Collection<String> cast)
	{
		this.title = title;
		this.year = year;
		this.director = director;
		this.cast = cast;
	}


	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getDirector() {
		return director;
	}

	public Collection<String> getCast() {
		return cast;
	}


	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", director=" + director + ", cast=" + cast + "]";
	}
}
