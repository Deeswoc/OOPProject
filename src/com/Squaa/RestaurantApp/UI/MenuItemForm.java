package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.Controllers.DatabaseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemForm extends JPanel {
    private JLabel nameLabel;
    protected JTextField name;
    private JLabel costLabel;
    protected JTextField cost;
    private JLabel prepTimeLabel;
    protected JTextField prepTime;
    protected JButton submit;
    protected ActionListener buttonAction;
    protected DatabaseController databaseController;
    protected GridBagConstraints gc;

    protected static final int TEXT_FIELD_WIDTH = 20;

    public MenuItemForm() {

        databaseController = new DatabaseController();
        nameLabel = new JLabel("Name Label:");
        name = new JTextField(TEXT_FIELD_WIDTH);
        costLabel = new JLabel("Cost:");
        cost = new JTextField(TEXT_FIELD_WIDTH);
        prepTimeLabel = new JLabel("Prep Time");
        prepTime = new JTextField(TEXT_FIELD_WIDTH);
        submit = new JButton("Submit");
        submit.addActionListener(buttonAction);
        buttonAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                databaseController.addDish(name.getText(), Integer.parseInt(prepTime.getText()), Integer.parseInt(cost.getText()));
                System.out.println("Add Dish Ran");
            }
        };
        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();
        layoutForm(0);
    }

    protected void layoutForm(int startingRow){
        gc.gridy = startingRow;
        gc.gridx = 0;
        add(nameLabel, gc);
        gc.gridx = 1;
        add(name, gc);
        gc.gridy++;
        gc.gridx = 0;
        add(costLabel, gc);
        gc.gridx = 1;
        add(cost, gc);
        gc.gridy++;
        gc.gridx = 0;
        add(prepTimeLabel, gc);
        gc.gridx = 1;
        add(prepTime, gc);
        gc.gridx = 0;
        gc.gridy++;
        gc.gridwidth = 2;
        add(submit, gc);
        gc.gridwidth = 1;
    }
}
