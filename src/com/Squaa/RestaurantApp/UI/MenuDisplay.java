package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.Controllers.AuthController;
import com.Squaa.RestaurantApp.Controllers.DatabaseController;
import com.Squaa.RestaurantApp.DataLogic.Dish;
import com.Squaa.RestaurantApp.DataLogic.MenuItem;
import com.Squaa.RestaurantApp.DataLogic.State;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuDisplay extends JPanel {
    JTable display;

    public static void main(String[] args){
        DatabaseController dc = new DatabaseController();
        ArrayList<Dish> list = dc.getDishes();
        MenuTableModel model = new MenuTableModel(list);
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.addAuthController(new AuthController(State.getApplicationState()));
        MenuDisplay temp = new MenuDisplay(model);

        frame.add(temp, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public MenuDisplay(MenuTableModel m){
        display = new JTable(m);
        display.setShowVerticalLines(false);
        display.getColumnModel().getColumn(1).setCellRenderer(new MenuItemNameRenderer());
        display.setRowHeight(25);
        add(new JScrollPane(display));
    }
}
