package com.Squaa.RestaurantApp.DataLogic.TimeLogic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch {
    private static boolean running = false;
    private static int interval = 0;
    private static Timer timer = new Timer();
    private static int delay = 1000;
    private static int period = 1000;
    private static ArrayList<TimerListener> timerListeners = new ArrayList<>();
    private static ArrayList<TimeChangedListener> timeChangedListeners = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input seconds => : ");
        String secs = sc.nextLine();
        timer = new Timer();
        interval = Integer.parseInt(secs);
        System.out.println(secs);
    }

    public static void addTime(int seconds){
        interval+=seconds;
    }

    public static int startTimer(int time){
        if(interval==0) {
            interval = time;
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    running = true;
                    int sec = count();
                    notifiyTimeChanged();
                    if(sec == 0)
                        alarm();
                }
            }, delay, period);
            return 1;
        }
        return 0;
    }

    private static int count(){
            if (interval == 1) {
                timer.cancel();
                running = false;

            }
            return --interval;
    }

    private static void notifiyTimeChanged(){
        for (TimeChangedListener sl:timeChangedListeners) {
            sl.onChange(interval);
        }
    }

    private static void alarm() {
        {
            timer.cancel();
            for (TimerListener cdl: timerListeners)
            {
                cdl.alarm();
            }
        }
    }

    public static void addTimerLister(TimerListener timerListener){
        timerListeners.add(timerListener);
    }

    public static void addTimeChangedListener(TimeChangedListener timeChangedListener){
        timeChangedListeners.add(timeChangedListener);
    }
}