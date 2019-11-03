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
	
	
	public void addDish(int ID,String name2,int preptime,int amount,double cost) 
	{
		if(con==null)
		{
			getConnection();
		}
		try {
		String dish_name =String.valueOf(name2);
		PreparedStatement prep = con.prepareStatement("INSERT INTO Dish values(?,?,?,?,?);");
		prep.setInt(1, ID);
		prep.setString(2, dish_name);
		prep.setInt(3, preptime);
		prep.setInt(4, amount);
		prep.setDouble(5, cost);
		prep.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void updateDish(int ID,String name2,int preptime,int amount,double cost) 
	{
		if(con==null)
		{
			getConnection();
		}
		try {
		PreparedStatement prep = con.prepareStatement("UPDATE Dish SET name ='"+name2+"',time ="+preptime+",quantity="+amount+",price ="+cost+" where id ="+ID);
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
					state2.execute("CREATE TABLE Dish(id identity(100,1),"+ "name varchar(30)," + "time integer,"+ "quantity integer,"+"price numeric,"+"primary key(id));");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
