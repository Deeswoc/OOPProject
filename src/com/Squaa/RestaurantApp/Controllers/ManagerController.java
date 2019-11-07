package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.AuthListener;
import com.Squaa.RestaurantApp.DataLogic.Level;
import com.Squaa.RestaurantApp.UI.AppFrame;
import com.Squaa.RestaurantApp.UI.CustomerMenu;
import com.Squaa.RestaurantApp.UI.MainView;
import com.Squaa.RestaurantApp.UI.ManagerMenu;

import javax.swing.*;

public class ManagerController implements  FrameController{
    private AppFrame window;


    public ManagerController(AppFrame window){
        this.window = window;
    }
    @Override
    public void updateFrame(JPanel view) {
        window.setView(view);
        window.revalidate();
    }

    public void setWindow(AppFrame window) {
        this.window = window;
    }
}
