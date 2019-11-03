package com.Squaa.RestaurantApp.UI;

import javax.swing.*;
import java.awt.*;

public class MenuItemForm extends JPanel {
    private JLabel nameLabel;
    private JTextField name;
    private JLabel costLabel;
    private JTextField cost;
    private JLabel prepTimeLabel;
    private JTextField prepTime;
    private JButton submit;
    private GridBagConstraints gc;

    private static final int TEXT_FIELD_WIDTH = 20;

    public MenuItemForm(){
        nameLabel = new JLabel("Name Label:");
        name = new JTextField(TEXT_FIELD_WIDTH);
        costLabel = new JLabel("Cost:");
        cost = new JTextField(TEXT_FIELD_WIDTH);
        prepTimeLabel = new JLabel("Prep Time");
        prepTime = new JTextField(TEXT_FIELD_WIDTH);
        submit = new JButton("Submit");


        setLayout(new GridBagLayout());
        gc = new GridBagConstraints();
        gc.gridy = 0;
        gc.gridx = 0;
        add(nameLabel, gc);
        gc.gridy = 0;
        gc.gridx = 1;
        add(name, gc);
        gc. gridy = 1;
        gc.gridx = 0;
        add(costLabel, gc);
        gc. gridy = 1;
        gc.gridx = 1;
        add(cost, gc);
        gc. gridy = 2;
        gc.gridx = 0;
        add(prepTimeLabel, gc);
        gc. gridy = 2;
        gc.gridx = 1;
        add(prepTime, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        gc.gridwidth = 2;
        add(submit, gc);


    }
}
