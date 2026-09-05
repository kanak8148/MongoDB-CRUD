package in.com.mongo.config;

import org.bson.Document;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

public class UserModel {
	
    private MongoDatabase database;

    public UserModel() {
        database = MongoDBConnection.getDatabase();
        
        
        
    }
    
    private int NextId() {
        // employees collection mein se id ke hisab se descending sort karo, sirf 1 document lo (highest id wala)
        Document highestIdDoc = database.getCollection("employees")
                .find()
                .sort(Sorts.descending("id"))
                .limit(1)
                .first();

        if (highestIdDoc == null) {
            // Agar collection khali hai (koi employee nahi hai abhi tak), toh id 1 se start karo
            return 1;
        }

        int highestId = highestIdDoc.getInteger("id");
        return highestId + 1;
    }
    
    
    
	 public void add(UserDto user) {
	        int nextId = NextId();
	        user.setId(nextId);

	        Document doc = new Document("id", user.getId())
	                .append("name", user.getName())
	                .append("age", user.getAge())
	                .append("gender", user.getGender())
	                .append("dob", user.getDob())
	                .append("address", user.getAddress());

	        database.getCollection("employees").insertOne(doc);
	        
	        System.out.println("Employee add ho gaya, ID: " + user.getId()+user.getAddress()+user.getAge());
	    }
}
