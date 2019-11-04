package com.Squaa.RestaurantApp.DataLogic;

public class OrderItem extends MenuItem {
	private int quantity;
	public OrderItem(int cost, int prepTime, int id, int quantity) {
		super(cost, prepTime, id);
		// TODO Auto-generated constructor stub
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
