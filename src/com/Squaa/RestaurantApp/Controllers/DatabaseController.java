package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.IO.Database;

import java.sql.SQLException;
import java.util.ArrayList;

import com.Squaa.RestaurantApp.DataLogic.Dish;
import com.Squaa.RestaurantApp.DataLogic.MenuItem;

public class DatabaseController {
	private Database db;
	
	public DatabaseController() {
		db = new Database();
	}
	
	public void addDish(String name, int prepTime, int cost) {
		db.addDish(name, prepTime, cost);
	}

	void deleteDish(int id)
	{
		db.deleteDish(id);
	}

	public ArrayList<Dish> getDishes() {
		try {
			return db.getDishes();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	return null;
	}

	public Dish getDish()
	{
	 return null;
	}
	
	public void updateDish(String name,int price, int preptime, int id ){
		db.updateDish(id, name, preptime, price);
	}
}
