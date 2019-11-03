package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.AuthListener;
import com.Squaa.RestaurantApp.DataLogic.Level;
import com.Squaa.RestaurantApp.UI.AppFrame;
import com.Squaa.RestaurantApp.UI.MainView;
import com.Squaa.RestaurantApp.UI.ManagerMenu;

import javax.swing.*;

public class ManagerController implements  FrameController, AuthListener {
    private AppFrame window;


    public ManagerController(AppFrame window){
        this.window = window;
    }
    @Override
    public void updateFrame(JPanel view) {
        window.setView(view);
        window.revalidate();
    }

    @Override
    public void onAuth(Level level) {
        if(level == Level.ADMIN){
            ManagerMenu menu = new ManagerMenu();
            menu.setFrameController(this);
            window.setJMenuBar(menu);
            window.setView(new MainView());
            window.revalidate();
        }else if (level == Level.CUSTOMER){
            //TODO Add the customer level menu
        }

    }
}
