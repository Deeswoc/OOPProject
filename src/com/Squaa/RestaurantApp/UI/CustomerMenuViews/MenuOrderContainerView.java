package com.Squaa.RestaurantApp.UI.CustomerMenuViews;

import com.Squaa.RestaurantApp.Controllers.AddOrderItemController;

import javax.swing.*;
import java.awt.*;

public class MenuOrderContainerView extends JPanel {
    AddOrderItemController OrderController;
    private CurrentMenuView currentMenu;
    private CurrentOrderView orderView;

    public MenuOrderContainerView(){
        OrderController = new AddOrderItemController();
        currentMenu = new CurrentMenuView(OrderController);
        orderView = new CurrentOrderView(OrderController);

        setLayout(new FlowLayout());
        add(currentMenu);
        add(orderView);
    }
}
