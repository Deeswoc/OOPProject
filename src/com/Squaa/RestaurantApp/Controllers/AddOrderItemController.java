package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.IO.Database;
import com.Squaa.RestaurantApp.DataLogic.IO.Recept;
import com.Squaa.RestaurantApp.DataLogic.MenuItem;
import com.Squaa.RestaurantApp.DataLogic.Order;
import com.Squaa.RestaurantApp.DataLogic.OrderItem;
import com.Squaa.RestaurantApp.UI.CustomerMenuTableModel;
import com.Squaa.RestaurantApp.UI.CustomerMenuViews.CustomerOrderTable;
import com.Squaa.RestaurantApp.UI.MenuTableModel;
import com.Squaa.RestaurantApp.UI.OrderTableModel;

public class AddOrderItemController  implements AbstractOrderController{
	Database data = new Database();
	public OrderTableModel orderItems;
	public CustomerMenuTableModel menuTableModel;

	@Override
	public void startOrder(Order order) {
		orderItems.startOrder();
		data.addOrder(order);
		Order recieptOrder = data.DisplayOrder(data.addOrder(order));
		new Recept(recieptOrder).CreateFileDirectory();
		new Recept(recieptOrder).writeFile(recieptOrder);
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
		orderItems.fireTableDataChanged();
	}

	@Override
	public void removeOrderItem(int orderItemID) {
		orderItems.removeOrderItem(orderItemID);

	}

	@Override
	public void addCustomerMenuTableModel(CustomerMenuTableModel model) {
		this.menuTableModel = model;
	}

	@Override
	public void addOrderTableModel(OrderTableModel model) {
		this.orderItems = model;
	}


}
