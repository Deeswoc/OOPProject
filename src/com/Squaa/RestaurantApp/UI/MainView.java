package com.Squaa.RestaurantApp.UI;

import javax.swing.*;
import java.awt.*;

public class MainView extends JPanel {
    JList menu;


    public MainView(){
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 1;
        add(new JButton("hello"));
    }
}
