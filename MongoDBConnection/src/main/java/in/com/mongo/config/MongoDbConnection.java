package in.com.mongo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

	private static MongoClient client;
    private static MongoDatabase database;

    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "Mongodb";

    // Private constructor - koi bahar se object nahi bana sakta
    private MongoDBConnection() {
    }

    // Singleton - agar connection already bana hai toh wahi return karo
    public static MongoDatabase getDatabase() {
        if (database == null) {
            client = MongoClients.create(CONNECTION_STRING);
            database = client.getDatabase(DATABASE_NAME);
            System.out.println("MongoDB connection bana!");
        }
        return database;
    }

    // Application band karte waqt call karna
    public static void closeConnection() {
        if (client != null) {
            client.close();
            client = null;
            database = null;
            System.out.println("MongoDB connection band ho gaya!");
        }
    }
}