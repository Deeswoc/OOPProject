package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.Controllers.FrameController;

import javax.swing.*;

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
