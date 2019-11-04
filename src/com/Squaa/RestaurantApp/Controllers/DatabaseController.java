package com.Squaa.RestaurantApp.Controllers;
import java.util.Scanner;

import com.Squaa.RestaurantApp.DataLogic.IO.database;

public class DatabaseController {
	private database db;
	
	this.database db = new database();
	
	
void addDish(String name,int price, int Preptime) {
	
	db.addDish(name, Preptime, price);
	}

void deleteDish(int id)
{ 
	db.deleteDish(id);
}

void displayDish()
{
 db.
}
}