package com.Squaa.RestaurantApp.UI;

import javax.swing.*;

public class EditMenuItemForm extends MenuItemForm {
    private JLabel idLabel;
    private JTextField id;
    EditMenuItemForm(){
        super();
        removeAll();
        idLabel = new JLabel("ID");
        id = new JTextField(10);
        gc.gridy = 0;
        gc.gridx = 0;
        add(idLabel, gc);
        gc.gridy = 0;
        gc.gridx = 1;
        add(id, gc);
        layoutForm(1);
    }
}
