package com.Squaa.RestaurantApp.DataLogic;

import com.Squaa.RestaurantApp.DataLogic.TimeLogic.Stopwatch;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeChangedListener;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimerListener;

public class OrderItem{
	private int quantity;
	private MenuItem itemOrdered;
	private Stopwatch prepTime;
	private OrderChangedListener orderChangedListener;

	public OrderItem(MenuItem menuItem) {
		this.itemOrdered = menuItem;
		prepTime = new Stopwatch();
		quantity = 1;
		prepTime.addTime(itemOrdered.getPrepTime());
	}

	public OrderItem(MenuItem menuItem, int quantity) {
		this.itemOrdered = menuItem;
		prepTime = new Stopwatch();
		this.quantity = quantity;
		prepTime.addTime(itemOrdered.getPrepTime());
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
		prepTime.addTime(itemOrdered.getPrepTime());
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
	public int getOrderTime(){
		return prepTime.getTimeRemaining();
	}
	public int getSubtotal(){
		return	quantity * itemOrdered.getCost();
	}
	public void start(){
		prepTime.startTimer();
	}
}
