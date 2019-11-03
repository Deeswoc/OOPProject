package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.Controllers.AuthController;
import com.Squaa.RestaurantApp.Controllers.FrameController;
import com.Squaa.RestaurantApp.DataLogic.Level;
import com.Squaa.RestaurantApp.DataLogic.State;
import sun.swing.SwingAccessor;

import javax.swing.*;

public class AppFrame extends JFrame implements AppWindow{
    JPanel view;

    public AppFrame(){
        super("Main");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.addAuthController(new AuthController(State.getApplicationState()));
        setView(loginPanel);
        add(loginPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void setView(JPanel view) {
        getContentPane().removeAll();
        revalidate();
        this.view = view;
        add(this.view);
        revalidate();
    }
}
