package com.Squaa.RestaurantApp.DataLogic.TimeLogic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch {
    private boolean running = false;
    private int interval = 0;
    private Timer timer;
    private final int delay = 1000;
    private final int period = 1000;
    private ArrayList<TimerListener> timerListeners = new ArrayList<>();
    private ArrayList<TimeChangedListener> timeChangedListeners = new ArrayList<>();

    public Stopwatch(){
        timer = new Timer();
    }

    public void addTime(int seconds){
        interval+=seconds;
    }

    public int startTimer(){
        if(interval>=0) {
            running = true;
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    running = true;
                    int sec = count();
                    notifyTimeChanged();
                    if (sec == 0)
                        alarm();
                }
            }, delay, period);
        }
        return 1;
    }

    public int startTimer(int time){
        if(interval>=0) {
            running = true;
            interval = time;
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    running = true;
                    int sec = count();
                    notifyTimeChanged();
                    if(sec == 0)
                        alarm();
                }
            }, delay, period);
            return 1;
        }
        return 0;
    }

    public int getTimeRemaining(){
        return interval;
    }

    private int count(){
            if (interval == 1) {
                timer.cancel();
                running = false;

            }
            return --interval;
    }

    private void notifyTimeChanged(){
        for (TimeChangedListener sl:timeChangedListeners) {
            sl.onChange(interval);
        }
    }

    private void alarm() {
        {
            timer.cancel();
            for (TimerListener cdl: timerListeners)
            {
                cdl.alarm();
            }
        }
    }

    public void addTimerLister(TimerListener timerListener){
        timerListeners.add(timerListener);
    }

    public void addTimeChangedListener(TimeChangedListener timeChangedListener){
        timeChangedListeners.add(timeChangedListener);
    }
}