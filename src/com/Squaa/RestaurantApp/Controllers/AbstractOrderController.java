package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.Order;
import com.Squaa.RestaurantApp.UI.CustomerMenuTableModel;
import com.Squaa.RestaurantApp.UI.CustomerMenuViews.CustomerOrderTable;
import com.Squaa.RestaurantApp.UI.OrderTableModel;

import javax.swing.table.AbstractTableModel;

public interface AbstractOrderController {
    void startOrder(Order order);
    void increaseQuantity(int orderItemID);
    void decreaseQuantity(int orderItemID);
    void setOrderQuantity(int orderItemID, int orderItemQuantity);
    void addOrderItem(int menuItemID);
    void removeOrderItem(int orderItemID);

    void addCustomerMenuTableModel(CustomerMenuTableModel model);
    void addOrderTableModel(OrderTableModel model);
}
