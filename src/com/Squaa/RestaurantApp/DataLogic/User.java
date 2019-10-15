package com.Squaa.RestaurantApp.DataLogic;
import java.util.Arrays;

public class User {
	private String username;
	private char[] password;
	private Level accessLevel;
	
	private static User[] users = new User[]{
			new User("Manager", new char[] {'1', '2', '3', '4', '5', '6'}),
			new User("Customer", new char[]{'1', '2', '3', '4', '5', '6'})
	};

	private User(String username, char[] password) {
		this.username = username;
		this.password = password;
	}

	public static Level authorize(String username, char[] password) {
		if(users[0].checkCredentials(username, password)) {
			return users[0].getAccessLevel();
		} else if(users[1].checkCredentials(username, password)) {
			return users[1].getAccessLevel();
		} else {
			return Level.UNATHORIZED;
		}
	}
	
	private boolean checkCredentials(String username, char[] password) {
		if(username.equals(this.username) && Arrays.equals(password, this.password)) {
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
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
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
