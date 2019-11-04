package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.IO.Database;

public class DatabaseController {
	private Database db;
	
	public DatabaseController() {
		db = new Database();
	}
	
void addDish(String name,int price, int Preptime) {
	
	db.addDish(name, Preptime, price);
	}

	void deleteDish(int id)
	{ 
		db.deleteDish(id);
	}
	
	MenuItem getDishes() {
		
	}

	MenuItem getDish()
	{
	 
	}
}