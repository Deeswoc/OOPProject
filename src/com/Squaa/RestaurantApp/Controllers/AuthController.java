package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.AuthListener;
import com.Squaa.RestaurantApp.DataLogic.Level;
import com.Squaa.RestaurantApp.DataLogic.State;
import com.Squaa.RestaurantApp.UI.AppFrame;
import com.Squaa.RestaurantApp.UI.CustomerMenu;
import com.Squaa.RestaurantApp.UI.MainView;
import com.Squaa.RestaurantApp.UI.ManagerMenu;

import javax.swing.*;

public class AuthController implements FrameController, AuthListener {
    private State state;
    private AppFrame window;
    public AuthController(State state){
        this.state = state;
    }

    public AuthController() {

    }

    public void authorize(String username, char[] password){
        state.Authorize(username, password);
    }

    @Override
    public void updateFrame(JPanel view) {
        window.setView(view);
    }

    public void setWindow(AppFrame window){
        this.window = window;
    }

    @Override
    public void onAuth(Level level) {
        if(level == Level.ADMIN){
            ManagerMenu menu = new ManagerMenu();
            menu.setFrameController(new ManagerController(window));
            window.setJMenuBar(menu);
            window.setView(new MainView());
            window.setVisible(false);
            window.setSize(1000, 700);
            window.setLocationRelativeTo(null);
            window.revalidate();
            window.setVisible(true);
        }else if (level == Level.CUSTOMER){
            CustomerMenu menu = new CustomerMenu();
            menu.setFrameController(new ManagerController(window));
            window.setJMenuBar(menu);
            window.setView(new MainView());
            window.setVisible(false);
            window.setSize(1000, 700);
            window.setLocationRelativeTo(null);
            window.revalidate();
            window.setVisible(true);
        }
    }
}
