package com.Squaa.RestaurantApp.DataLogic.IO;
import com.Squaa.RestaurantApp.DataLogic.Dish;
import com.Squaa.RestaurantApp.DataLogic.MenuItem;
import com.Squaa.RestaurantApp.DataLogic.Order;
import com.Squaa.RestaurantApp.DataLogic.OrderItem;
import com.Squaa.RestaurantApp.DataLogic.TimePeriod;

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

import javax.swing.filechooser.FileSystemView;

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
							"menu_id INTEGER PRIMARY KEY AUTOINCREMENT);");
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
	public void addMenu(){
		if(con==null)
		{
			getConnection();
		}
		try {
		PreparedStatement prep = con.prepareStatement("INSERT INTO Menu values(null);");
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
	
	public void addMenu_Item_to_MENU(int id,int menu_id,String detail)
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
	
	public ArrayList<Dish> displayMenu_and_Menu_Item(int MenuID)
	{
		
		if(con==null)
		{
			getConnection();
		}
		ArrayList <Dish> dishes =  new ArrayList<>();
		try {
		PreparedStatement state = con.prepareStatement("SELECT * FROM Menu_and_MenuItem INNER JOIN Dish D on Menu_and_MenuItem.id = D.id where Menu_and_MenuItem.m_id = ?");
		state.setInt(1, MenuID);
		ResultSet res = state.executeQuery();
			while(res.next())
			{
				dishes.add(new Dish(res.getString ("name"),res.getInt("id"), res.getInt("preptime"),res.getInt("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dishes;
		
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
	
	public ArrayList<OrderItem> Display_Menu_item_and_Orders(int MenuItemId)
	{
		MenuItem menuitem = null;
		ArrayList<OrderItem> order =  new ArrayList<>();
		if(con==null)
		{
			getConnection();
		}
		try {
		PreparedStatement state = con.prepareStatement("Select*FROM MenuItem_and_Orders INNER JOIN Orders O on MenuItem_and_Order.orderid = O.Order_num where MenuItem_and_Order.id = ?");
		 state.setInt(1, MenuItemId);
		 ResultSet res = state.executeQuery();
			while(res.next())
			{
			 menuitem = new MenuItem(res.getString ("name"),res.getInt("id"), res.getInt("preptime"),res.getInt("price"));
			  order.add(new OrderItem(menuitem));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	
	//FOR ORDER TABLE
	public int addOrder(Order order)
	{
		int lastInsertedRow;
		if(con==null)
		{
			getConnection();
		}
		try {
			PreparedStatement state =con.prepareStatement("INSERT INTO Orders values(null,?,?);");
			PreparedStatement insertOrder = con.prepareStatement("INSERT INTO MenuItem_and_Orders values (?, ?, ?)");
			
			LocalDate obj1 = LocalDate.now();
			LocalTime obj2 = LocalTime.now();
			state.setObject(1, obj1);
			state.setObject(2, obj2);
			state.execute();
			lastInsertedRow = con.createStatement().executeQuery("SELECT last_insert_rowid(); as lastRow").getInt(1);
			
			for(OrderItem orderItem: order.getOrderItems()) {
				insertOrder.setInt(1, orderItem.getItemID());
				insertOrder.setInt(2, lastInsertedRow);
				insertOrder.setInt(3, orderItem.getQuantity());
				insertOrder.execute();
				System.out.println("last row id: "+lastInsertedRow);

			}
			System.out.println("Order Added\n");
			return lastInsertedRow;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return -1;
		
		
	}
	
	public ArrayList<OrderItem> DisplayOrders(int id){
		if(con == null){
			getConnection();
		}
		ArrayList <OrderItem> order =  new ArrayList<>();
		try{
			PreparedStatement state = con.prepareStatement("SELECT * FROM MenuItem_and_Orders join Dish on MenuItem_and_Orders.id = Dish.id" + " where orderid = ?;");
			state.setInt(1,id);
			ResultSet res = state.executeQuery();
			while (res.next()){
				order.add(new OrderItem(new MenuItem(res.getString("name"), res.getInt("id"), res.getInt("preptime"), res.getInt("price"))));
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return order;
	}
	
	public ArrayList<Order> DisplayOrders(){
		if(con == null){
			getConnection();
		}
		ArrayList <Order> order =  new ArrayList<>();
		try{
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery("SELECT * FROM Orders"+";");
			while (res.next()){
				order.add(new Order(res.getInt ("Order_num"),res.getString("Date"), res.getString("Time")));
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
			ArrayList<OrderItem> orderList = DisplayOrders(id);
			ResultSet res = state.executeQuery("SELECT * FROM Orders where Order_num =" + id + ";");
			orders = new Order(res.getInt ("Order_num"),res.getString("Date"), res.getString("Time"), orderList);

		}catch (Exception e){
			e.printStackTrace();
		}
		
		return orders;
	}

	//FOR MENU_SCHEDULE

	public void  SetMenuSchedule(String TimeOfDay, int MenuId)
	{
		if(con==null){
			getConnection();
		}
		try {
		String TimeValue =String.valueOf(TimeOfDay);
		PreparedStatement prep = con.prepareStatement("INSERT INTO Schedule_Menu values(?,?);");
		prep.setString(1, TimeValue);
		prep.setInt(2, MenuId);
		prep.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public int GetMenuSchedule(TimePeriod currentTimePeriod){
		int MenuID = 0;
		if(con == null){
			getConnection();
		}
		try{
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery("SELECT menu_for_time FROM Schedule_Menu where Time_of_day =" + currentTimePeriod + ";");
			MenuID = res.getInt ("menu_for_time");

		}catch (Exception e){
			e.printStackTrace();
		}
		return MenuID;
	}

	 
}

	