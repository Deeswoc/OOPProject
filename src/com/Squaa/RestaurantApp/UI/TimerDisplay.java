package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeChangedListener;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeFormatter;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimerListener;

import javax.swing.*;

public class TimerDisplay extends JLabel implements TimeChangedListener, TimerListener {

    public TimerDisplay(){
        super();
    }

    @Override
    public void onChange(int sec) {
        setText(TimeFormatter.getHHMMSS(sec));
        revalidate();
    }

    @Override
    public void alarm() {

    }
}
