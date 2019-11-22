                                                                                                                                                                                                                                                                                                                                                                                                     package com.Squaa.RestaurantApp.DataLogic;

import com.Squaa.RestaurantApp.DataLogic.MenuItem;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> order;
	private int orderNumber;
	private String date;
	private String time;
	private OrderChangedListener orderChangedListener;

	public int getMaxTime(){
		int max = 0;
		for(OrderItem item: order){
			if(item.getOrderTime()>max)
				max = item.getOrderTime();
		}
		return max;
	}

	public ArrayList<OrderItem> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<OrderItem> order) {
		this.order = order;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Order(int orderNumber, String date, String time) {
		this.orderNumber = orderNumber;
		this.date = date;
		this.time = time;
	}

	public Order(int orderNumber, String date, String time, ArrayList<OrderItem> orderList) {
		this.orderNumber = orderNumber;
		this.date = date;
		this.time = time;
		this.order = orderList;
	}
	public  Order(){
		order = new ArrayList<>();
	}

	public ArrayList<OrderItem> getOrderItems(){
		return order;
	}

	public void notifyOrderChangedListener(){
		orderChangedListener.onQuantityChanged(getTotal(), getMaxTime());
	}

	public OrderItem addOrderItem(MenuItem menuItem){
		OrderItem item = new OrderItem(menuItem);
		order.add(item);
		notifyOrderChangedListener();
		return item;
	}

	public int getTotal(){
		int total = 0;
		for(OrderItem orderItem: order)
			total+=orderItem.subTotal();
		return total;
	}

	public void setOrderChangedListener(OrderChangedListener orderChangedListener) {
		this.orderChangedListener = orderChangedListener;
	}

	public void startOrder(){
		for(OrderItem orderItem: order){
			orderItem.start();
		}
	}

}
