package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.Controllers.DatabaseController;
import com.Squaa.RestaurantApp.Controllers.FrameController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerMenu extends JMenuBar {



    private JMenu menu;
    private JMenuItem addItem;
    private JMenuItem editItem;
    private JMenuItem deleteItem;
    private JMenuItem searchItems;
    private JMenuItem viewItems;
    private FrameController frameController;
    public ManagerMenu(){
        addItem = new JMenuItem("New Item");
        editItem = new JMenuItem("Edit Item");
        deleteItem = new JMenuItem("Delete Item");
        searchItems = new JMenuItem("Search");
        viewItems = new JMenuItem("View Menu");
        menu = new JMenu("Menu");

        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameController.updateFrame(new MenuItemForm());
            }
        });

        editItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frameController.updateFrame(new EditMenuItemForm());
           }
       });

        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameController.updateFrame(new DeleteMenuItemForm());
            }
        });

        viewItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuTableModel m = new MenuTableModel(new DatabaseController().getDishes());
                frameController.updateFrame(new MenuDisplay(m));
            }
        });
                add(menu);
        menu.add(addItem);
        menu.add(editItem);
        menu.add(deleteItem);
        menu.add(searchItems);
        menu.add(viewItems);
    }

    public void setFrameController(FrameController frameController){
        this.frameController = frameController;
    }
}
