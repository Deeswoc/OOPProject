package com.Squaa.RestaurantApp.UI.CustomerMenuViews;

import javax.swing.*;
import java.awt.*;

public class MenuOrderContainerView extends JPanel {
    private CurrentMenuView currentMenu;
    private CurrentOrderView orderView;

    public MenuOrderContainerView(){
        currentMenu = new CurrentMenuView();
        orderView = new CurrentOrderView();

        setLayout(new FlowLayout());
        add(currentMenu);
        add(orderView);
    }
}
