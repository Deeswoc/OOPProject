package com.Squaa.RestaurantApp.DataLogic.IO;
import com.Squaa.RestaurantApp.DataLogic.Dish;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
	private static Connection con=null;
	private static boolean hasData = false;
	
	public ArrayList getDishes() throws ClassNotFoundException, SQLException
	{
		if(con==null)
		{
			getConnection();
		}
		ArrayList <Dish> dishes =  new ArrayList<>();
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("Select*FROM Dish");
		while(res.next())
		{
			dishes.add(new Dish(res.getString ("name"),res.getInt("id"), res.getInt("time"),res.getInt("price")));
		}
		return dishes ;
	}
	
	
	public void addDish(String name, int preptime,double cost)
	{
		if(con==null)
		{
			getConnection();
		}
		try {
		String dish_name =String.valueOf(name);
		PreparedStatement prep = con.prepareStatement("INSERT INTO Dish values(null, ?, ?, ?);");
		prep.setString(1, dish_name);
		prep.setInt(2, preptime);
		prep.setDouble(3, cost);
		prep.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void updateDish(int ID, String name, int preptime, int amount,int cost)
	{
		if(con==null)
		{
			getConnection();
		}
		try {
		PreparedStatement prep = con.prepareStatement(
			"UPDATE Dish SET " +
					"time =" + preptime +", " +
					"quantity = " + amount + "," +
					"price = " + cost +" " +
					"where id ="+ID);
		prep.execute();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void search(int ID)
	{
		if(con==null)
		{
			getConnection();
		}
		try {
			PreparedStatement prep = con.prepareStatement("SELECT*FROM Dish where id = "+ID);
			prep.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteDish(int ID)
	{
		if(con==null)
		{
			getConnection();
		}
		try {
		PreparedStatement prep = con.prepareStatement(
			"DELETE FROM Dish where id ="+ID);
		System.out.println(ID+" has been deleted.");
		prep.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}


	private void getConnection() 
	{
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:SQLite Test Food Court.db");
			initialise();
		}
		catch (ClassNotFoundException |SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	private void initialise() {
		if(!hasData)
		{
			hasData = true;
			Statement state;
			try {
				state = con.createStatement();
				ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table'AND name='Dish'");
				if(!res.next())
				{
					System.out.println("Building the dish table\n");
					//need to build table
					Statement state2 = con.createStatement();
					state2.execute(
					"CREATE TABLE Dish(" +
							"id INTEGER PRIMARY KEY AUTOINCREMENT, "+
							"name VARCHAR(30), " +
							"preptime INTEGER, "+
							"price INTEGER); "+
					"CREATE TABLE Order("+
							"order_num INTEGER PRIMARY KEY AUTOINCREMENT, "+
							"Time INTEGER, "
							);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
