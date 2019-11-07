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
	
void addDish(String name,int price, int prepTime) {
	
	db.addDish(name, prepTime, price);
	}

	void deleteDish(int id)
	{ 
		db.deleteDish(id);
	}
	
	ArrayList<Dish> getDishes() {
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

	Dish getDish()
	{
	 return null;
	}
	
	void updateDish(String name,int price, int preptime, int id ){
		db.updateDish(id, name, preptime,0, price);
	}
}
