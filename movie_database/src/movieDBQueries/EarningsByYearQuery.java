package movieDBQueries;

import java.util.HashMap;

import movieDBModel.Database;
import movieDBModel.Movie;

public class EarningsByYearQuery extends DatabaseQuery
{
	HashMap<String, Integer> earningsByYear = new HashMap<>();
	
	public EarningsByYearQuery(Database database) {
		super(database);
		databaseMovies = database.getAllMovies();
	}

	@Override
	protected void generateQueryResult() {
		for (Movie movie : databaseMovies)
		{
			int earnings = movie.get
			Integer count = earningsByYear.get(director);
			if (count == null) {
				earningsByYear.put(director, 1);
			}
			else {
				earningsByYear.put(director, count + 1);
			}
		}
		
	}

	@Override
	protected void printQueryResult() {
		// TODO Auto-generated method stub
		
	}

}
