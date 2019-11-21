package com.Squaa.RestaurantApp.UI.CustomerMenuViews;

import com.Squaa.RestaurantApp.Controllers.AbstractOrderController;
import com.Squaa.RestaurantApp.Controllers.DatabaseController;
import com.Squaa.RestaurantApp.UI.CustomerMenuTableModel;
import com.Squaa.RestaurantApp.UI.MenuTableModel;

import javax.swing.*;

public class CurrentMenuView extends JPanel {
    CustomerMenuTable currentCustomerMenuTable;


    CurrentMenuView(AbstractOrderController controller){
        CustomerMenuTableModel model = new CustomerMenuTableModel(new DatabaseController().getDishes());
        controller.addCustomerMenuTableModel(model);

        currentCustomerMenuTable = new CustomerMenuTable(model);
        currentCustomerMenuTable.setController(controller);
        add(new JScrollPane(currentCustomerMenuTable));
    }
}
