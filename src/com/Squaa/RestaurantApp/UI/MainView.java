package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.Controllers.TimerController;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.Stopwatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JPanel {
    JList menu;
    TimerController timerController;

    public MainView(){

        super();
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 1;
        JButton start = new JButton("Start timer");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerController.startTimer(300);
            }
        });
        TimerDisplay display = new TimerDisplay();
        timerController = new TimerController();
        add(start, gc);
        timerController.addTimeChangeListeners(display);
        gc.gridy = 2;
        add(display, gc);


    }
}
