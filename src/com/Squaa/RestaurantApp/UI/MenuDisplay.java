package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.Controllers.AuthController;
import com.Squaa.RestaurantApp.DataLogic.MenuItem;
import com.Squaa.RestaurantApp.DataLogic.State;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuDisplay extends JPanel {
    JTable display;

    public static void main(String[] args){

        ArrayList<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("Stew Pork", 400, 300, 1));
        list.add(new MenuItem("Ackee and Saltfish", 400, 300, 1));
        list.add(new MenuItem("Stew Beef", 500, 360, 1));
        list.add(new MenuItem("Rice & Peas with Fried Chicken", 400, 300, 1));
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
        add(new JScrollPane(display));
    }
}
