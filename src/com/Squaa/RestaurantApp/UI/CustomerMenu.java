package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.Controllers.FrameController;

import javax.swing.*;

public class CustomerMenu extends JMenuBar {
    private JMenuItem searchForItem;
    private JMenuItem viewMenu;
    private FrameController frameController;
    private JMenu options;
    public CustomerMenu(){
        searchForItem = new JMenuItem("Search");
        viewMenu = new JMenuItem("View Menu");
        options = new JMenu("Options");

        options.add(searchForItem);
        options.add(viewMenu);
        add(options);

    }

    public void setFrameController(FrameController frameController) {
        this.frameController = frameController;
    }
}
