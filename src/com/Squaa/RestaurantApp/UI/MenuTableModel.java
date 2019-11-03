package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.DataLogic.MenuItem;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MenuTableModel  extends AbstractTableModel {
    private ArrayList<MenuItem> dataset;
    private String[] columnNames = {"Dish", "Cost", "Prep Time"};

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
                return currentItem.getCost();
            case 2:
                return currentItem.getPrepTime();
        }
        return null;
    }

    public void setDataset(ArrayList<MenuItem> dataset){
        this.dataset = dataset;
    }
}
