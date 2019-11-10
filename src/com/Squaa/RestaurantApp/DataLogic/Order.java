                                                                                                                                                                                                                                                                                                                                                                                                     package com.Squaa.RestaurantApp.DataLogic;

import com.Squaa.RestaurantApp.DataLogic.MenuItem;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> order;
	private int orderNumber;
	private String date;
	private String time;
	public int netTotal()
	{
		int total = 0;
		for(int i=0;i<order.size();i++)
		{
			total+=order.get(i).subTotal();
		}
		
		return total;
	}

	public Order(int orderNumber, String date, String time) {
		this.orderNumber = orderNumber;
		this.date = date;
		this.time = time;
	}

	public  Order(){
		order = new ArrayList<>();
	}

	public ArrayList<OrderItem> getOrderItems(){
		return order;
	}

	public void addOrderItem(MenuItem menuItem){
		for (OrderItem item: order) {
			if (item.getItemID() == menuItem.getid()) {
				item.incrementQuantity();
				return;
			}
		}
		order.add(new OrderItem(menuItem));
	}

	public void startOrder(){
		for(OrderItem orderItem: order){
			orderItem.start();
		}
	}

}
