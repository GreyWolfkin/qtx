package pojo;

public class User {
	
	private String id;
	private String email;
	private String first_name;
	private String last_name;
	private String avatar;
	
	public User(String id, String email, String first_name, String last_name, String avatar) {
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.avatar = avatar;
	}
	
	public void printUser() {
		System.out.println("id: " + this.id);
		System.out.println("email: " + this.email);
		System.out.println("first_name: " + this.first_name);
		System.out.println("last_name: " + this.last_name);
		System.out.println("avatar: " + this.avatar);
	}
}
