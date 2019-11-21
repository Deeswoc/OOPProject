package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.DataLogic.Dish;
import com.Squaa.RestaurantApp.DataLogic.MenuItem;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeFormatter;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CustomerMenuTableModel extends AbstractTableModel {
    private ArrayList<Dish> dataset;
    private String[] columnNames = {"Dish", "Cost", "Prep Time"};

    public CustomerMenuTableModel(ArrayList<Dish> menu){

        this.dataset = menu;
    }



    @Override
    public int getRowCount() {
        return dataset.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MenuItem currentItem = dataset.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return currentItem.getName();
            case 1:
                return TableFormatter.currency(currentItem.getCost());
            case 2:
                return TimeFormatter.getHHMMSS(currentItem.getPrepTime());
        }
        return null;
    }

    public void setDataset(ArrayList<Dish> dataset){
        this.dataset = dataset;
    }

    public Dish search(int id)
    {
        for(int i = 0; i < dataset.size(); i++) {
            if(dataset.get(i).getid()==id) {
                return dataset.get(i);
            }
        }
        return null;
    }

    public MenuItem getDishAt(int index){
        return dataset.get(index);
    }
}
