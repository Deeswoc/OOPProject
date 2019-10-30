package com.Squaa.RestaurantApp.DataLogic.TimeLogic;

public class TimeFormatter {
    private int totalSeconds;

    public TimeFormatter(int seconds){
        this.totalSeconds = seconds;
    }

    public static void main(String[] args) {
        TimeFormatter tf = new TimeFormatter(10000);
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    public void setTotalSeconds(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    public static String getHHMMSS(int totalSeconds){
        int seconds = totalSeconds % 60;
        int minutes = ((totalSeconds - seconds) / 60)%60;
        int hours = totalSeconds / 3600;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
