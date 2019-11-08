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
					//Statement state2 = con.createStatement();
					//state2.execute(
					state.execute("CREATE TABLE Menu("+
							"menu_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
							"Time_period varchar (20)); ");
					state.execute("CREATE TABLE Dish(" +
							"id INTEGER PRIMARY KEY AUTOINCREMENT, " +
							"name VARCHAR(30), " +
							"preptime INTEGER, " +
							"price INTEGER); ");
 					state.execute("CREATE TABLE Orders("+
							"Order_num INTEGER PRIMARY KEY AUTOINCREMENT, "+
							"Date_and_Time INTEGER); ");
 					state.execute(
							"CREATE TABLE Menu_and_MenuItem("+
							"id INTEGER, "+
							"m_id INTEGER, "+
							"detail VARCHAR(255), "+
							"Constraint fk_dishid FOREIGN KEY (id) REFERENCES Dish(id), "+
							"Constraint fk_menuid FOREIGN KEY (m_id) REFERENCES Menu(menu_id), "+
							"Constraint pk_ids PRIMARY KEY (id,m_id));");
 					state.execute(
							"CREATE TABLE MenuItem_and_Orders("+
							"quantity INTEGER, "+
							"id INTEGER, "+
							"orderid INTEGER, "+
							"Constraint fk_menuitem FOREIGN KEY (id) REFERENCES Dish(id), "+
							"Constraint fk_orderid FOREIGN KEY (orderid) REFERENCES Orders(Order_num),"+
							"Constraint pk_menorder PRIMARY KEY (id,orderid));");
					/*+
					"CREATE TABLE Dish(" +
							"id INTEGER PRIMARY KEY AUTOINCREMENT, "+
							"name VARCHAR(30), " +
							"preptime INTEGER, "+
							"price INTEGER); "+
					"CREATE TABLE Order("+
							"Order_num INTEGER PRIMARY KEY AUTOINCREMENT, "+
							"Date_and_Time INTEGER);"
							);*/
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	//FOR DISHES
	public ArrayList<Dish> getDishes() throws ClassNotFoundException, SQLException
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
	
	
	public void addDish(String name, int preptime, int cost)
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
		prep.setInt(3, cost);
		prep.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void updateDish(int ID, String name, int preptime,int cost)
	{
		if(con==null)
		{
			getConnection();
		}
		try {
		PreparedStatement prep = con.prepareStatement(
			"UPDATE Dish SET " +
					"time =" + preptime +", " +
					"price = " + cost +" " +
					"where id ="+ID);
		prep.execute();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public ResultSet search(int ID)
	{
		ResultSet res = null;
		if(con==null)
		{
			getConnection();
		}
		try {
			Statement state = con.createStatement();
			res = state.executeQuery("SELECT*FROM Dish where id = "+ID);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return res;
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
	
	//FOR MENU
	public void addMenu(String Time_of_day){
		if(con==null)
		{
			getConnection();
		}
		try {
		String daytime = String.valueOf(Time_of_day);
		PreparedStatement prep = con.prepareStatement("INSERT INTO Menu values(null, ?);");
		prep.setString(1,daytime);
		prep.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void displayMenu(int id)
	{
		if(con==null)
		{
			getConnection();
		}
		Statement state;
		try {
			state = con.createStatement();
			ResultSet res = state.executeQuery("Select*FROM Menu");
			while(res.next())
			{
				 System.out.println(res.getInt("menu_id")+ " " +res.getString("Time_period"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//FOR MENU_AND_MENUITEM
	
	

}
