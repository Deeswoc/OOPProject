package com.Squaa.RestaurantApp.DataLogic.IO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
	private static Connection con=null;
	private static boolean hasData = false;
	
	public ResultSet displayUsers() throws ClassNotFoundException, SQLException
	{
		if(con==null)
		{
			getConnection();
		}
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("Select*FROM Dish");
		return res;
	}
	
	
	public void addInfo(int ID,String name2,int preptime,int amount,double cost) throws ClassNotFoundException, SQLException {
		if(con==null)
		{
			getConnection();
		}
		String dish_name =String.valueOf(name2);
		PreparedStatement prep = con.prepareStatement("INSERT INTO user values(?,?,?,?,?);");
		prep.setInt(1, ID);
		prep.setString(2, dish_name);
		prep.setInt(3, preptime);
		prep.setInt(4, amount);
		prep.setDouble(5, cost);
		prep.execute();
	}

	private void getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:SQLite Test Food Court.db");
		initialise();
		
	}

	private void initialise() throws SQLException {
		if(!hasData)
		{
			hasData = true;
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table'AND name='Dish'");
			if(!res.next())
			{
				System.out.println("Building the user table with pre populated values\n");
				
				//need to build table
				Statement state2 = con.createStatement();
				state2.execute("CREATE TABLE Dish(id identity(100,1),"+ "name varchar(30)," + "time integer,"+ "quantity integer,"+"price numeric,"+"primary key(id));");
				//inserting some sample data
				/*PreparedStatement prep = con.prepareStatement("INSERT INTO user values(?,?,?);");
				prep.setInt(1, 23);
				prep.setString(2, "John");
				prep.setString(3, "Parks");
				prep.execute();
				
				PreparedStatement prep2 = con.prepareStatement("INSERT INTO user values(?,?,?);");
				prep2.setInt(1, 21);
				prep2.setString(2,"ham");
				prep2.setString(3,"bob");
				prep2.execute();*/
			}
		}
		
	}
	public void addUser(String firstname,String lastname) throws ClassNotFoundException, SQLException
	{
		if(con==null)
		{
			getConnection();
		}
		PreparedStatement prep = con.prepareStatement("INSERT INTO Dish values(?,?,?);");
		prep.setString(2,firstname);
		prep.setString(3,lastname);
		prep.execute();
	}

}
