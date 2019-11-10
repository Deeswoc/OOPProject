package com.Squaa.RestaurantApp.DataLogic;

import java.util.ArrayList;

public class Menu {
	int ID;
	String Description;
	ArrayList<MenuItem> menu;

	Menu(){};

	public Menu(int ID, String description) {
		this.ID = ID;
		Description = description;
		this.menu = new ArrayList<MenuItem>();
	}

	public void addItem(MenuItem menuItem){
		menu.add(menuItem);
	}
}
