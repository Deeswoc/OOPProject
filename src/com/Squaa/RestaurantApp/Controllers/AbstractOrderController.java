package com.Squaa.RestaurantApp.Controllers;

public interface AbstractOrderController {
    void startOrder();
    void increaseQuantity(int orderItemID);
    void decreaseQuantity(int orderItemID);
    void setOrderQuantity(int orderItemID, int orderItemQuantity);
    void addOrderItem(int menuItemID);
    void removeOrderItem(int orderItemID);

}
