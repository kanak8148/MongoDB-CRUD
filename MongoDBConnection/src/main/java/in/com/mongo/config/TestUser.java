package in.com.mongo.config;

public class TestUser {
	public static void main(String[] args) {
		//testadd();
		testdelete();
	}

	private static void testdelete() {
		UserModel model = new UserModel();
		UserDto dto = new UserDto();
		dto.setId(1); ;
		model.delete(dto);
		
	}

	private static void testadd() {
		UserModel model = new UserModel();
		UserDto dto = new UserDto();
		dto.setName("shyam");
		dto.setAge(29);
		dto.setDob("1996-01-18");
		dto.setAddress("agra");
		model.add(dto);

	}

}
