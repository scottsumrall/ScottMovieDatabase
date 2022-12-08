package movieDBController;

import java.util.HashMap;

import modelDBView.InputHandler;
import movieDBModel.Database;
import movieDBQueries.CastMemberQuery;
import movieDBQueries.DatabaseQuery;
import movieDBQueries.TopDirectorsQuery;
import movieDBQueries.allDirectorsQuery;

public class Controller 
{
	String[] queryTypes = new String[] {"C", "F", "D", "T"};
	
	private static final String ALL_MOVIES_FILE = "imdb_movies_cast.txt";
	HashMap<String, DatabaseQuery> moviesByRankings = new HashMap<String, DatabaseQuery>();
	Database database;
	public Controller()
	{
		database = new Database();
		moviesByRankings.put("C", new CastMemberQuery(database));
		moviesByRankings.put("F", new TopDirectorsQuery(database));
		moviesByRankings.put("D", new allDirectorsQuery(database));
		moviesByRankings.put("T", new allDirectorsQuery(database));
	}
	
	public void startDatabase()
	{
		DatabaseGenerator databaseGenerator = new DatabaseGenerator();
		databaseGenerator.addAllMoviesToDatabase(ALL_MOVIES_FILE, database);
		databaseGenerator.addSortedMoviesToDatabase(database);
		
		InputHandler inputHandler = new InputHandler(database);
		String queryType = inputHandler.getUserQuery();
		
		moviesByRankings.get(queryType).query();
	}
}
