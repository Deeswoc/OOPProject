package com.Squaa.RestaurantApp.UI.CustomerMenuViews;

import com.Squaa.RestaurantApp.UI.OrderTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;

public class CustomerOrderTable extends JTable{


    CustomerOrderTable(OrderTableModel model){
        super(model);
    }
}
