package com.Squaa.RestaurantApp.Controllers;

import javax.swing.*;

public class CustomerController implements FrameController {
    private JFrame window;

    CustomerController(JFrame window){
        this.window = window;
    }

    public void updateFrame(JPanel view) {
        window.removeAll();
        window.add(view);
    }}
