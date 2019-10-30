package com.Squaa.RestaurantApp.DataLogic;

public class MenuItem {
	private int cost;
	private int prepTime;
	private int id;
	private boolean alcoholic;
	public MenuItem(int cost, int prepTime, int id, boolean alcoholic) {
		super();
		this.cost = cost;
		this.prepTime = prepTime;
		this.id = id;
		this.alcoholic = alcoholic;
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
	public boolean getalcoholic() 
	{
		return alcoholic;
	}
	public void setalchoholic(boolean alcoholic) 
	{
		this.alcoholic= alcoholic;
	}
}
