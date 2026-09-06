package in.com.mongo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

//mongo DB me method nahi, function hote hai
public class mongoDBConnection {

	private static MongoClient client;
	private static MongoDatabase database;

	//(:)collen bolte hai
	private static final String CONNECTION_STRING = "mongodb://localhost:27017";
	private static final String DATABASE_NAME = "MongoDB";

	//private constructor - koi bahar se objecct nahi bana sakta
	private mongoDBConnection() {
	}

	//singleton - agar connection already bana hai toh wahi return karo
	public static MongoDatabase getDatabase() {
		if (database == null) {
			//connectvite provide karega jub usme database nahi mil raha hoga tab
			client = MongoClients.create(CONNECTION_STRING);
			database = client.getDatabase(DATABASE_NAME);
			System.out.println("MongoDB connection successful...");
		}
		return database;
	}

	//Application band karte waqt call karna  
	public static void closeConnection() {
		if (client != null) {
			client.close();
			client = null;
			database = null;
			System.out.println("MongoDB connection closed...");
		}
	}

}
