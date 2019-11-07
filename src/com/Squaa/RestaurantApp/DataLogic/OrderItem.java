package com.Squaa.RestaurantApp.DataLogic;

import com.Squaa.RestaurantApp.DataLogic.TimeLogic.Stopwatch;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeChangedListener;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimerListener;

public class OrderItem{
	private int quantity;
	private MenuItem itemOrdered;
	private Stopwatch prepTime;
	private QuantityChangedListener quantityChangedListener;

	public OrderItem(MenuItem menuItem) {
		this.itemOrdered = menuItem;
	}
	public int subTotal(){
		return itemOrdered.getCost() * quantity;
	}

	public int getCost(){
		return itemOrdered.getCost();
	}

	public String getName(){
		return itemOrdered.getName();
	}

	public int getItemID(){
		return itemOrdered.getid();
	}



	public int decrementQuantity(){
		return --quantity;
	}

	public int incrementQuantity(){
		return ++quantity;
	}

	public void setTimerListener(TimerListener listenerForAlarm, TimeChangedListener timeChangedListener){
		prepTime.addTimerLister(listenerForAlarm);
		prepTime.addTimeChangedListener(timeChangedListener);
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
