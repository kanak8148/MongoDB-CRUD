package in.com.Mongo.config;

public class TestUser {
	public static void main(String[] args) {

		UserModel model = new UserModel();
		UserDto dto = new UserDto();

		dto.setName("karuna");
		dto.setGender("female");
		dto.setAge(21);
		dto.setAddress("indore");
		dto.setDob("19-11-2002");
		model.add(dto);
//		update();
	}

	private static void update() {
		UserModel model = new UserModel();
		UserDto dto = new UserDto();
		dto.setId(1);
		dto.setName("Harshit Shrivastava ");
		dto.setGender("male");
		dto.setAge(24);
		dto.setAddress("Bhopal");

		model.update(dto);

	}

}
