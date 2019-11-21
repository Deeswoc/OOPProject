package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.DataLogic.Dish;
import com.Squaa.RestaurantApp.DataLogic.MenuItem;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeFormatter;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MenuTableModel  extends AbstractTableModel {
    private ArrayList<Dish> dataset;
    private String[] columnNames = {"ID", "Dish", "Cost", "Prep Time"};

    public MenuTableModel(ArrayList<Dish> menu){

        this.dataset = menu;
    }



    @Override
    public int getRowCount() {
        return dataset.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
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
                return currentItem.getid();
            case 1:
                return currentItem.getName();
            case 2:
                return TableFormatter.currency(currentItem.getCost());
            case 3:
                return TimeFormatter.getHHMMSS(currentItem.getPrepTime());
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
        Dish dish = dataset.get(rowIndex);
        switch (columnIndex){
            case 1:{
                dish.setName((String) aValue);
            }
            case 2:{
                dish.setCost(Integer.parseInt((String) aValue));
            }
            case 3:{
                dish.setPrepTime(Integer.parseInt((String) aValue));
            }
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==0)
            return false;
        else
            return  true;
    }

    public void setDataset(ArrayList<Dish> dataset){
        this.dataset = dataset;
    }
    
    
    /*Edit here*/
    public Dish search(int id)
    {
    for(int i = 0; i < dataset.size(); i++) {
    	if(dataset.get(i).getid()==id) {
    		return dataset.get(i);
    	}
    }
    return null;
    }
}
