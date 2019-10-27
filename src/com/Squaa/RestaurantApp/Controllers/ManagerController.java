package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.AuthListener;
import com.Squaa.RestaurantApp.DataLogic.Level;
import com.Squaa.RestaurantApp.UI.MainView;
import com.Squaa.RestaurantApp.UI.ManagerMenu;

import javax.swing.*;

public class ManagerController implements  FrameController, AuthListener {
    private JFrame window;


    public ManagerController(JFrame window){
        this.window = window;
    }
    @Override
    public void updateFrame(JPanel view) {
        window.removeAll();
        window.add(view);
    }

    @Override
    public void onAuth(Level level) {
        window.getContentPane().removeAll();
        window.setJMenuBar(new ManagerMenu());
        window.add(new MainView());
        window.revalidate();
    }
}
