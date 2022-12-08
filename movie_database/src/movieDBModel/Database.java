package movieDBModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Database 
{
	List<Movie> databaseMovies;
	
	HashMap<String, List<Movie>> moviesByRankings = new HashMap<String, List<Movie>>();
	
	//associate movie title with a rating and/or score value
	HashMap <String, Integer> ratingsAndScoreValues = new HashMap<String, Integer>();
	
	public void addDatabaseMovies(List<Movie> databaseMovies)
	{
		this.databaseMovies = databaseMovies;
	}
	
	public void addRankedMovies(String rankingType, List<String> titlesRanked)
	{
		moviesByRankings.put(rankingType, new ArrayList<Movie>());
		for(String title : titlesRanked)
		{
			int index = Collections.binarySearch(databaseMovies, title, (m1, m2) -> ((Movie) m1).getTitle().compareTo((String) m2));
			
			//if movie was found, add it to the ranked list and add the earnings
		    if (index >= 0) {
		        moviesByRankings.get(rankingType).add(databaseMovies.get(index));
		    }
		}
		
		/*Debug:
		for(Movie movie : moviesByRankings.get(rankingType))
		{
			System.out.println(movie.toString());
		}
		*/
	}
	
	public List<Movie> getAllMovies()
	{
		return databaseMovies;
	}
	
	public List<Movie> getRankedMovies(String rankingType)
	{
		return moviesByRankings.get(rankingType);	
	}
}
