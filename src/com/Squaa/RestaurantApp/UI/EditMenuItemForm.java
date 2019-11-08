package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.DataLogic.Dish;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeFormatter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditMenuItemForm extends MenuItemForm {
    private JLabel idLabel;
    private JTextField id;
    private Dish dishToUpdate;

    EditMenuItemForm(){
        super();
        submit.setText("Save");
        buttonAction = e -> {
            databaseController.updateDish(Integer.parseInt(id.getText()), name.getText(), Integer.parseInt(prepTime.getText()), Integer.parseInt(cost.getText()));
            System.out.println("Edit Dish Ran");
        };
        submit.removeActionListener(submit.getActionListeners()[0]);
        submit.addActionListener(buttonAction);
        removeAll();
        idLabel = new JLabel("ID");
        id = new JTextField(10);
        id.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                dishToUpdate = databaseController.getDish(Integer.parseInt(id.getText()));
                if(dishToUpdate==null)
                    submit.setEnabled(false);
                else{
                    submit.setEnabled(true);

                    cost.setText(dishToUpdate.getCost() + "");
                    prepTime.setText(TimeFormatter.getHHMMSS(dishToUpdate.getPrepTime()));
                    name.setText(dishToUpdate.getName());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        gc.gridy = 0;
        gc.gridx = 0;
        add(idLabel, gc);
        gc.gridy = 0;
        gc.gridx = 1;
        add(id, gc);
        layoutForm(1);
    }

    private class ButtonAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            databaseController.updateDish(Integer.parseInt(id.getText()), name.getText(), Integer.parseInt(prepTime.getText()), Integer.parseInt(cost.getText()));
            System.out.println("Edit Dish Ran");
        }
        ButtonAction(){}
    }
}
