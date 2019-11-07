package com.Squaa.RestaurantApp.DataLogic;

public class Beverages extends MenuItem{
private boolean alcoholic;

	public Beverages(String name, int cost, int prepTime, int id) {
		super(name, cost, prepTime, id);
		// TODO Auto-generated constructor stub
	}

	public boolean isAlcoholic() {
		return alcoholic;
	}

	public void setAlcoholic(boolean alcoholic) {
		this.alcoholic = alcoholic;
	}

}
