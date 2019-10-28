package com.Squaa.RestaurantApp.DataLogic;

import com.Squaa.RestaurantApp.DataLogic.MenuItem;

import java.util.ArrayList;

public class Order {
	private ArrayList<MenuItem> order;
	public int netTotal()
	{
		int total = 0;
		for(int i=0;i<order.size();i++)
		{
			total+=order.get(i).getCost();
		}
		
		return total;
	}
	public int newTime()
	{
		int total = 0;
		for(int i = 0;i<order.size();i++)
		{
			total+=order.get(i).getPrepTime();
		}
		return total;
	}


}
