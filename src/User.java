
public class User {
	private String username;
	private String password;
	private Level accessLevel;
	
	private static User[] users = new User[2];
	
	private static void setUsers() {
		users[0] = new User("Manager", "12345678");
		users[1] = new User("Customer", "12345678");
	}
	
	private User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public static Level authorize(String username, String password) {
		if(users[0].checkCredentials(username, password)) {
			return users[0].getAccessLevel();
		} else if(users[1].checkCredentials(username, password)) {
			return users[1].getAccessLevel();
		} else {
			return Level.UNATHORIZED;
		}
	}
	
	private boolean checkCredentials(String username, String password) {
		if(username == this.username && password == this.password) {
			return true;
		}else
			return false;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Level getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(Level accessLevel) {
		this.accessLevel = accessLevel;
	}
	public static User[] getUsers() {
		return users;
	}
	public static void setUsers(User[] users) {
		User.users = users;
	}
	
	
}
