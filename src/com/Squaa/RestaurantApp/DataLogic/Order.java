                                                                                                                                                                                                                                                                                                                                                                                                     package com.Squaa.RestaurantApp.DataLogic;

import com.Squaa.RestaurantApp.DataLogic.MenuItem;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> order;
	public int netTotal()
	{
		int total = 0;
		for(int i=0;i<order.size();i++)
		{
			total+=order.get(i).subTotal();
		}
		
		return total;
	}

	public void addOrderItem(MenuItem menuItem){
		for (OrderItem item: order) {
			if (item.getItemID() == menuItem.getid()){
				item.incrementQuantity();
				return;
			}
		}
	}

}
