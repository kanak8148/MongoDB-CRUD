package in.com.mongo.config;

import org.bson.Document;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

public class UserModel {

	//mongoDatabase  variable name
	private MongoDatabase database;
	
	public UserModel() {
		database = mongoDBConnection.getDatabase();
	}
	private int NextId() {
		Document highestIdDoc = database.getCollection("employee")
		.find()
		.sort(Sorts.descending("id"))
		.limit(1)
		.first();
		
		if(highestIdDoc==null) {
			return 1;
			
		}
		int hightId = highestIdDoc.getInteger("id");
		return hightId + 1;
	}
	public void add(UserDto user) {
		int nextId = NextId();
		user.setId(nextId);
		
		Document doc = new Document("id",user.getId())
				.append("name", user.getName())
				.append("age", user.getAge())
				.append("dob", user.getDob())
				.append("address", user.getAddress());
		database.getCollection("employee").insertOne(doc);
		System.out.println("Add employee "+user.getName()+" "+user.getAddress()+" "+user.getAge()+" "+user.getDob());
	}
	public void update(UserDto user) {
			
			Document filter = new Document("id",user.getId());
			Document update = new Document("$set",
					new Document ("name", user.getName())
						.append("age", user.getAge())
						.append("gender", user.getGender())
						.append("dob", user.getDob())
						.append("address", user.getAddress()));

			database.getCollection("employees").updateMany(filter, update);
			System.out.println("Data updated: "+user.getId());
		}
	
}
