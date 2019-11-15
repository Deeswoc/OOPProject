package com.Squaa.RestaurantApp.UI.CustomerMenuViews;

import com.Squaa.RestaurantApp.UI.CustomerMenuTableModel;
import com.Squaa.RestaurantApp.UI.MenuItemNameRenderer;
import com.Squaa.RestaurantApp.UI.MenuTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomerMenuTable extends JTable {
    CustomerMenuTableModel model;

    CustomerMenuTable(CustomerMenuTableModel model){
        super(model);
        setShowVerticalLines(false);
        getColumnModel().getColumn(0).setCellRenderer(new MenuItemNameRenderer());
        getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setBorder(BorderFactory.createEmptyBorder(0, 10 , 0, 10));
                setHorizontalAlignment(JLabel.RIGHT);
                return component;
            }
        });
        getColumnModel().getColumn(2).setPreferredWidth(50);
        getColumnModel().getColumn(2).setPreferredWidth(50);
        setRowHeight(25);
    }

}
