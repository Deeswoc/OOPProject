package com.Squaa.RestaurantApp;

import com.Squaa.RestaurantApp.Controllers.ManagerController;
import com.Squaa.RestaurantApp.DataLogic.Level;
import com.Squaa.RestaurantApp.DataLogic.State;
import com.Squaa.RestaurantApp.DataLogic.User;
import com.Squaa.RestaurantApp.UI.AppFrame;

import javax.swing.*;

public class App {


    public static void main(String[] args){
        State state = State.getApplicationState();
        JFrame window = new AppFrame();

        ManagerController controller = new ManagerController(window);
        state.addAuthListener(controller);
    }
}
