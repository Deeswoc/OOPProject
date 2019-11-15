package com.Squaa.RestaurantApp.UI.CustomerMenuViews;

import com.Squaa.RestaurantApp.Controllers.DatabaseController;
import com.Squaa.RestaurantApp.UI.CustomerMenuTableModel;
import com.Squaa.RestaurantApp.UI.MenuTableModel;

import javax.swing.*;

public class CurrentMenuView extends JPanel {
    CustomerMenuTable currentCustomerMenuTable;


    CurrentMenuView(){
        CustomerMenuTableModel model = new CustomerMenuTableModel(new DatabaseController().getDishes());

        currentCustomerMenuTable = new CustomerMenuTable(model);
        add(new JScrollPane(currentCustomerMenuTable));
    }
}
