package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.IO.Database;
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
	
	MenuItem getDishes() {
		return  null;
	}

	MenuItem getDish()
	{
	 return null;
	}
}