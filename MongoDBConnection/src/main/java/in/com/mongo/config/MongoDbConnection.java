package in.com.mongo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDbConnection {
	
	
	private static MongoClient client ;
	
	private static MongoDatabase database;
	
	
	    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
	    private static final String DATABASE_NAME = "Mongodb";
	    
	    private MongoDbConnection() {
	    }
	    
	    public static MongoDatabase getDatabase() {
	        if (database == null) {
	            client = MongoClients.create(CONNECTION_STRING);
	            database = client.getDatabase(DATABASE_NAME);
	            System.out.println("MongoDB connection bana!");
	        }
	        return database;
	    }

	    
	    
	    

}
