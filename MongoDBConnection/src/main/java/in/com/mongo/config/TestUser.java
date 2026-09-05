package in.com.mongo.config;

public class TestUser {
public static void main(String[] args) {
	

		
		
		
	
	
	
	UserModel user = new UserModel();
	UserDto dto = new UserDto();
	

	dto.setName("Kankeshwari");
	dto.setAge(78);
	dto.setAddress("kalani nagr");
	dto.setGender("female");
	
	user.add(dto);
	
	
	
   }
	
}

