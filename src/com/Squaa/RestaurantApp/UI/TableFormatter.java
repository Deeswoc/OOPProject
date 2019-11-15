package com.Squaa.RestaurantApp.UI;

public class TableFormatter {
    public TableFormatter(){

    }

    public static String currency(int money){
        return String.format("$%20d", money);
    }
}
