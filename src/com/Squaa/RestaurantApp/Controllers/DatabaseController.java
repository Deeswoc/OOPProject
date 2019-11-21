package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.IO.Database;

import java.sql.SQLException;
import java.util.ArrayList;

import com.Squaa.RestaurantApp.DataLogic.Dish;
import com.Squaa.RestaurantApp.DataLogic.MenuItem;
import com.Squaa.RestaurantApp.DataLogic.Order;
import com.Squaa.RestaurantApp.DataLogic.OrderItem;

public class DatabaseController {
	private Database db;
	
	public DatabaseController() {
		db = new Database();
	}
	
	public void addDish(String name, int prepTime, int cost) {
		db.addDish(name, prepTime, cost);
	}

	public ArrayList<Dish> getDishes() {
		//try {
			return db.getDishes();
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}	return null;
	}
	
	
	//FOR DISHES
	public Dish getDish(int id)
	{
	 return db.getDish(id);
	}
	
	public void updateDish( int id, String name,int price, int preptime){
		db.updateDish(id, name, preptime, price);
	}
	public void deleteDish(int ID) 
	{
		db.deleteDish(ID);
	}
	
	//FOR MENU
	public void addMenu() 
	{
		db.addMenu();
	}
	
	public void displayMenu(int id)
	{
		db.displayMenu(id);
	}
	
	
	//FOR MENU_and_MENUTITEM
	public void  addMenu_Item_to_MENU(int id, int menu_id, String detail) 
	{
		db.addMenu_Item_to_MENU(id, menu_id, detail);
	}
	
	public ArrayList<Dish> displayMenu_and_Menu_Item(int MenuID)
	{
		return db.displayMenu_and_Menu_Item(MenuID);
	}
	
	//FOR MENU_ITEM_and_ORDERS
	public void addMenu_Item_to_Orders(int amount, int id ,int order_id)
	{
		db.addMenu_Item_to_Orders(amount, id, order_id);
	}
	
	public ArrayList<OrderItem> Display_Menu_item_and_Orders(int MenuItemId)
	{
		return db.Display_Menu_item_and_Orders(MenuItemId);
	}
	
	//FOR ORDER TABLE
	public int addOrder(Order order)
	{
		return db.addOrder(order);
	}
	
	public void DisplayOrders()
	{
		db.DisplayOrders();
	}
	
	public void DisplayOrder(int id)
	{
		db.DisplayOrder(id);
	}
	
	//FOR MENU_SCHEDULE

		public void  addMenu_Schedule() 
		{}
		
	public void writeFile(int a, String t) 
	{
		//db.writeFile(a, t);
	}	
}
