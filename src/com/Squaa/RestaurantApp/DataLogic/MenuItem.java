package com.Squaa.RestaurantApp.DataLogic;

public class MenuItem extends Dish{
	private int cost;
	private int prepTime;
	public MenuItem(int cost, int prepTime) {
		super();
		this.cost = cost;
		this.prepTime = prepTime;
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
}
