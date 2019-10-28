package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.TimeLogic.Stopwatch;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeChangedListener;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimerListener;

public class TimerController {
    Stopwatch timer;

    public TimerController(){
        timer = new Stopwatch();
    }

    public void  addTimeChangeListeners(TimeChangedListener timeChangedListener){
        timer.addTimeChangedListener(timeChangedListener);
    }

    public void addAlarmListener(TimerListener timerListener){
        timer.addTimerLister(timerListener);
    }

    public void startTimer(int initialSeconds){
        timer.startTimer(initialSeconds);
    }
}
