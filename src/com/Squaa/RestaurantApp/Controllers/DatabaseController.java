package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.IO.Database;

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
		return db.getDishes();
		
	}

	getDish()
	{
	 db.getDishes();
	}
}