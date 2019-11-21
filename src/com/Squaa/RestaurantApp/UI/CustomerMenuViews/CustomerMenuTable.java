package com.Squaa.RestaurantApp.UI.CustomerMenuViews;

import com.Squaa.RestaurantApp.Controllers.AbstractOrderController;
import com.Squaa.RestaurantApp.UI.CustomerMenuTableModel;
import com.Squaa.RestaurantApp.UI.MenuItemNameRenderer;
import com.Squaa.RestaurantApp.UI.MenuTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerMenuTable extends JTable {
    CustomerMenuTableModel model;
    AbstractOrderController controller;


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

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                controller.addOrderItem(model.getDishAt(row).getid());
            }
        });

    }

    public void setController(AbstractOrderController controller){
        this.controller = controller;
    }

}
