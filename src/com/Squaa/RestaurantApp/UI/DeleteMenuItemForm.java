package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.Controllers.DatabaseController;
import com.Squaa.RestaurantApp.DataLogic.Dish;
import com.Squaa.RestaurantApp.DataLogic.TimeLogic.TimeFormatter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.Squaa.RestaurantApp.UI.MenuItemForm.TEXT_FIELD_WIDTH;

public class DeleteMenuItemForm extends JPanel {
    private JLabel idLabel;
    private JTextField id;
    private JLabel nameLabel;
    private JLabel name;
    private JLabel costLabel;
    private JLabel cost;
    private JLabel prepTimeLabel;
    private JLabel prepTime;
    private JButton delete;
    private DatabaseController databaseController;
    private GridBagConstraints gc;
    private Dish dishToDelete;

    DeleteMenuItemForm(){
        setLayout(new GridBagLayout());
        databaseController = new DatabaseController();
        nameLabel = new JLabel("Name Label:");
        name = new JLabel();
        costLabel = new JLabel("Cost:");
        cost = new JLabel();
        prepTimeLabel = new JLabel("Prep Time");
        prepTime = new JLabel();
        delete = new JButton("Delete");
        delete.setEnabled(false);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseController.deleteDish(dishToDelete.getid());
            }
        });
        idLabel = new JLabel("ID");
        id = new JTextField(TEXT_FIELD_WIDTH);
        id.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                dishToDelete = databaseController.getDish(Integer.parseInt(id.getText()));
                if(dishToDelete==null)
                    delete.setEnabled(false);
                else{
                    delete.setEnabled(true);
                    cost.setText(dishToDelete.getCost() + "");
                    prepTime.setText(TimeFormatter.getHHMMSS(dishToDelete.getPrepTime()));
                    name.setText(dishToDelete.getName());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        add(idLabel, gc);
        gc.gridx = 1;
        add(id, gc);
        gc.gridy = 1;
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
        add(delete, gc);
        gc.gridwidth = 1;
    }
}
