package com.Squaa.RestaurantApp.DataLogic;

public class MenuItem {
	private int cost;
	private int prepTime;
	private int id;
	
	public MenuItem(int cost, int prepTime, int id) {
		super();
		this.cost = cost;
		this.prepTime = prepTime;
		this.id = id;
		
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}
	
	public int getid() 
	{
		return id;
	}
	public void setid(int id) 
	{
		this.id = id;
	}

}
