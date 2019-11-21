package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.MenuItem;
import com.Squaa.RestaurantApp.DataLogic.OrderItem;
import com.Squaa.RestaurantApp.UI.MenuTableModel;
import com.Squaa.RestaurantApp.UI.OrderTableModel;

public class AddOrderItemController  implements AbstractOrderController{
	public OrderTableModel orderItems;
	public MenuTableModel menuTableModel;

	@Override
	public void startOrder() {
		orderItems.startOrder();
	}

	@Override
	public void increaseQuantity(int orderItemID) {
   
	}

	@Override
	public void decreaseQuantity(int orderItemID) {

	}

	@Override
	public void setOrderQuantity(int orderItemID, int orderItemQuantity) {
		
		
	}

	@Override
	public void addOrderItem(int menuItemID) {
		MenuItem menuItem= menuTableModel.search(menuItemID);
		orderItems.addOrderItem(menuItem);

	}

	@Override
	public void removeOrderItem(int orderItemID) {
		orderItems.removeOrderItem(orderItemID);

	}
}
