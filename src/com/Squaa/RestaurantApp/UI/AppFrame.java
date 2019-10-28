package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.Controllers.AuthController;
import com.Squaa.RestaurantApp.Controllers.FrameController;
import com.Squaa.RestaurantApp.DataLogic.Level;
import com.Squaa.RestaurantApp.DataLogic.State;
import sun.swing.SwingAccessor;

import javax.swing.*;

public class AppFrame extends JFrame {
    public AppFrame(){
        super("Main");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.addAuthController(new AuthController(State.getApplicationState()));

        add(loginPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
