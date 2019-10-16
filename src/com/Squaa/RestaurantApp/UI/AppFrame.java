package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.DataLogic.Level;


import javax.swing.*;

public class AppFrame extends JFrame {
    private Level accessLevel;
    public AppFrame(){
        super("Main");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new LoginPanel());
        setLocationRelativeTo(null);
        setVisible(true);


    }
}
