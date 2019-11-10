package com.Squaa.RestaurantApp.DataLogic.IO;
import com.Squaa.RestaurantApp.DataLogic.Dish;
import com.Squaa.RestaurantApp.DataLogic.Order;
import com.Squaa.RestaurantApp.DataLogic.OrderItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.*;

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
							"Date INTEGER, "+
							"Time INTEGER); ");
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
							"id INTEGER, "+
							"orderid INTEGER, "+
							"quantity INTEGER, "+
							"Constraint fk_menuitem FOREIGN KEY (id) REFERENCES Dish(id), "+
							"Constraint fk_orderid FOREIGN KEY (orderid) REFERENCES Orders(Order_num),"+
							"Constraint pk_menorder PRIMARY KEY (id,orderid));");
					state.execute("CREATE TABLE Schedule_Menu("+
							"Time_of_day Varchar(15), "+
							"menu_for_time INTEGER, "+
							"Constraint fk_menu FOREIGN KEY (menu_for_time) REFERENCES Menu(menu_id));");
							
					System.out.println("Table Buildt\n");
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
	
	//FOR DISHES
	public ArrayList<Dish> getDishes()
	{
		if(con==null)
		{
			getConnection();
		}
		ArrayList <Dish> dishes =  new ArrayList<>();
		Statement state;
		try {
			state = con.createStatement();
			ResultSet res = state.executeQuery("Select*FROM Dish");
				while(res.next())
				{
					dishes.add(new Dish(res.getString ("name"),res.getInt("id"), res.getInt("preptime"),res.getInt("price")));
				}
			}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return dishes ;
	}

	public Dish getDish(int id){
		if(con == null){
			getConnection();
		}
		Dish dish = null;
		try{
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery("SELECT * FROM Dish where id =" + id + ";");
			while (res.next()){
				dish = new Dish(res.getString ("name"),res.getInt("id"), res.getInt("preptime"),res.getInt("price"));
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return dish;
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
	
	public int updateDish(int ID, String name, int preptime,int cost)
	{
		if(con==null)
		{
			getConnection();
		}
		try {
			PreparedStatement prep = con.prepareStatement(
					"UPDATE Dish SET name = ?, preptime = ?, price = ? where id = ?"
			);
			prep.setString(1, name);
			prep.setInt(2, preptime);
			prep.setInt(3, cost);
			prep.setInt(4, ID);
			int changed = prep.executeUpdate();
			System.out.println(changed + " records changed");
			return changed;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	public int deleteDish(int ID)
	{
		if(con==null)
		{
			getConnection();
		}
		try {
		PreparedStatement prep = con.prepareStatement(
			"DELETE FROM Dish where id ="+ID);
		System.out.println(ID+" has been deleted.");
		int changed = prep.executeUpdate();
		return changed;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return -1;
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
			e.printStackTrace();
		}
		
	}
	
	//FOR MENU_and_MENUTITEM
	
	public void addMenu_Item_to_mENU(int id,int menu_id,String detail)
	{
		if(con==null)
		{
			getConnection();
		}
		try {
			String info = String.valueOf(detail);
			PreparedStatement prep =con.prepareStatement("INSERT INTO Menu_and_MenuItem values(?,?,?);");
			prep.setInt(1, id);
			prep.setInt(2, menu_id);
			prep.setString(3, info);
			prep.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void displayMenu_and_Menu_Item() 
	{
		if(con==null)
		{
			getConnection();
		}
		try {
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("Select*FROM Menu_and_MenuItem");
		
			while(res.next())
			{
			 System.out.println(res.getInt("id")+ " " +res.getInt("m_id")+ " "+res.getString("detail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//FOR MENU_ITEM_and_ORDERS
	public void addMenu_Item_to_Orders(int amount,int id,int order_id)
	{
		if(con==null)
		{
			getConnection();
		}
		try {
			PreparedStatement prep =con.prepareStatement("INSERT INTO  MenuItem_and_Orders values(?,?,?);");
			prep.setInt(1, id);
			prep.setInt(2, order_id);
			prep.setInt(3, amount);
			prep.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void Display_Menu_item_and_Orders()
	{
		if(con==null)
		{
			getConnection();
		}
		try {
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("Select*FROM MenuItem_and_Orders");
		
			while(res.next())
			{
			 System.out.println(res.getInt("id")+ " " +res.getInt("orderid")+ " "+res.getInt("qunatity"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//FOR ORDER TABLE
	public void addOrder()
	{
		LocalDate obj1 = LocalDate.now();
		LocalTime obj2 = LocalTime.now();
		if(con==null)
		{
			getConnection();
		}
		try {
			PreparedStatement prep =con.prepareStatement("INSERT INTO Orders values(null,?,?);");
			prep.setObject(1, obj1);
			prep.setObject(2, obj2);
			prep.execute();
			System.out.println("Order Added\n");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Order> DisplayOrders(){
		if(con == null){
			getConnection();
		}
		ArrayList <Order> order =  new ArrayList<>();
		try{
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery("SELECT * FROM Orders ;");
			while (res.next()){
				String data = res.getInt ("Order_num")+" "+res.getString("Date")+ " "+ res.getString("Time");
				int id = res.getInt("Order_num");
				writeFile(id,data);
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return order;
	}
	
	public Order DisplayOrder(int id){
		if(con == null){
			getConnection();
		}
		Order orders = null;
		try{
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery("SELECT * FROM Dish where id =" + id + ";");
			while (res.next()){
				//orders = new Order(res.getInt ("id"),res.getString("Date"), res.getString("Time"));
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return orders;
	}

	//FOR MENU_SCHEDULE

	public void  addMenu_Schedule()
		{
			
		}
	
	// FOR CREATION OF TXT FILE CONTAINING ORDER ID'S,DATE, TIME
	 public void writeFile(int a,String t)
	    {
	            File file = new File(a+".txt");
	            FileWriter fr = null;
	            try {
	                fr = new FileWriter(file);
	                fr.write(t);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	                try {
	                    fr.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            
}
}

	