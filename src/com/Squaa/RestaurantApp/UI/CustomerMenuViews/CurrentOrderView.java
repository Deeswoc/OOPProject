package com.Squaa.RestaurantApp.UI.CustomerMenuViews;

import com.Squaa.RestaurantApp.Controllers.AbstractOrderController;
import com.Squaa.RestaurantApp.DataLogic.IO.Recept;
import com.Squaa.RestaurantApp.DataLogic.Order;
import com.Squaa.RestaurantApp.UI.OrderTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentOrderView extends JPanel {
    AbstractOrderController controller;
    CustomerOrderTable table;
    JButton makeOrder;
    JLabel remainingTime;
    JLabel totalCost;
    GridBagConstraints gc;
    CurrentOrderView(AbstractOrderController controller){

        this.controller = controller;
        gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        Order order = new Order();
        OrderTableModel orderModel  = new OrderTableModel(order);
        controller.addOrderTableModel(orderModel);
        table = new CustomerOrderTable(orderModel);
        remainingTime = new JLabel("00:00:00");
        totalCost = new JLabel("$00.00");
        makeOrder = new JButton("Place Order");
        gc.gridy = 0;
        add(new JScrollPane(table), gc);
        gc.gridy = 1;
        add(remainingTime, gc);
        gc.gridy = 2;
        add(totalCost, gc);
        gc.gridy = 3;
        add(makeOrder, gc);
        makeOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startOrder(order);

            }
        });
    }
}
