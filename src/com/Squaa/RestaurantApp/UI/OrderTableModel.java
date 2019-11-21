package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.DataLogic.Dish;
import com.Squaa.RestaurantApp.DataLogic.MenuItem;
import com.Squaa.RestaurantApp.DataLogic.Order;
import com.Squaa.RestaurantApp.DataLogic.OrderItem;
import com.Squaa.RestaurantApp.Controllers.AuthController;
import com.Squaa.RestaurantApp.Controllers.DatabaseController;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeChangedListener;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeFormatter;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimerListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class OrderTableModel extends AbstractTableModel implements TimeChangedListener {
	private Order dataset;
    private ArrayList<OrderItem> orderItems;
    private ArrayList<TimeChangedListener> timerDisplays;
    private int loopControl;
    private String[] columnNames = {"Dish", "Cost", "Prep Time", "Orders"};
    private int interval = 0;

    public OrderTableModel(Order order){
    	this.dataset = order;
        orderItems = order.getOrderItems();
        for(loopControl = 0; loopControl < orderItems.size(); loopControl++){
            orderItems.get(loopControl).setTimerListener(new TimerListener() {
                @Override
                public void alarm() {
                    System.out.println("ORDER READY!!");
                }
            }, new TimeChangedListener() {
                int row = loopControl;
                @Override
                public void onChange(int sec) {
                    fireTableCellUpdated(row, 2);
                    System.out.println("Remaining time " + sec);
                }
            });
        }
        for(OrderItem orderItem: orderItems){
            if(orderItem.getOrderTime()>interval)
                interval = orderItem.getOrderTime();
        }
    }


    @Override
    public int getRowCount() {
        return orderItems.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
        OrderItem orderItem = orderItems.get(rowIndex);
        switch (columnIndex){
            case 3:
                orderItem.setQuantity((Integer) aValue);
                fireTableRowsUpdated(rowIndex, rowIndex);
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OrderItem orderItem = orderItems.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return orderItem.getName();
            case 1:
                return orderItem.getCost();
            case 2:
                if(orderItem.getOrderTime()!=0)
                    return TimeFormatter.getHHMMSS(orderItem.getOrderTime());
                else
                    return "READY!!";
            case 3:
                return orderItem.getQuantity();

        }

        return null;
    }

    public static void  main(String[] args){
        DatabaseController dc = new DatabaseController();
        ArrayList<Dish> list = dc.getDishes();
        Order order = new Order();
        order.addOrderItem(list.get(0));
        order.addOrderItem(list.get(1));
        order.addOrderItem(list.get(4));
        OrderTableModel model = new OrderTableModel(order);
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        JPanel orderDisplay = new JPanel();
        System.out.println("Number of Orders: " + order.getOrderItems().size());

        orderDisplay.setLayout(new FlowLayout());
        JTable orders = new JTable(model);
        orderDisplay.add(new JScrollPane(orders));
        model.startOrder();
        frame.add(orderDisplay);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void onChange(int sec) {
        fireTableDataChanged();
    }

    public void startOrder(){
        dataset.startOrder();
    }
    
    public void setItemQuantity(int itemID, int quantity) {
    	for(int i = 0; i < orderItems.size(); i++) {
    		if(orderItems.get(i).getItemID()==itemID) {
    			orderItems.get(i).setQuantity(quantity);
    		}
    	}
    	
    }
    
    public void addOrderItem(MenuItem menuItem) 
    {
    	orderItems.add(new OrderItem(menuItem));
    }
    
    public void removeOrderItem(int orderItemID)
    {
    	{
    	    for(int i = 0; i < orderItems.size(); i++) {
    	    	if(orderItems.get(i).getItemID()==orderItemID) {
    	    		orderItems.remove(i);
    	    	}
    	    }
    	
    }
}
}
