package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.IO.Database;
import com.Squaa.RestaurantApp.DataLogic.IO.Recept;
import com.Squaa.RestaurantApp.DataLogic.MenuItem;
import com.Squaa.RestaurantApp.DataLogic.Order;
import com.Squaa.RestaurantApp.DataLogic.OrderChangedListener;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeChangedListener;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimerListener;
import com.Squaa.RestaurantApp.UI.CustomerMenuTableModel;
import com.Squaa.RestaurantApp.UI.CustomerMenuViews.CurrentOrderView;
import com.Squaa.RestaurantApp.UI.OrderTableModel;

public class AddOrderItemController  implements AbstractOrderController, OrderChangedListener{
	Database data = new Database();
	public OrderTableModel orderItems;
	public CustomerMenuTableModel menuTableModel;
	private CurrentOrderView currentOrderView;

	@Override
	public void startOrder(Order order) {
		orderItems.startOrder();
		int receiptNumber = data.addOrder(order);
		Order receiptOrder = data.DisplayOrder(receiptNumber);
        currentOrderView.startTimer();
		new Recept(receiptOrder).CreateFileDirectory();
		new Recept(receiptOrder).writeFile(receiptOrder);
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
		this.orderItems.setOrderChangedListener(this);
	}

	@Override
    public void setCurrentOrderView(CurrentOrderView currentOrderView) {
        this.currentOrderView = currentOrderView;
    }

    @Override
    public void onQuantityChanged(int subTotal, int maxTime) {
        currentOrderView.setRemainingTime(maxTime);
        currentOrderView.setTotalCost(subTotal);
    }

}
