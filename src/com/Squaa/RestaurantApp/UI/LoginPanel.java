package com.Squaa.RestaurantApp.UI;

import com.Squaa.RestaurantApp.Controllers.AuthController;
import com.Squaa.RestaurantApp.DataLogic.AuthListener;
import com.Squaa.RestaurantApp.DataLogic.Level;
import com.Squaa.RestaurantApp.DataLogic.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends  JPanel{
    private JTextField username;
    private JPasswordField password;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton login;
    private AuthController authController;
    LoginPanel(){
        username = new JTextField("", 10);
        password = new JPasswordField("", 10);
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] enteredPassword = password.getPassword();
                String enteredUsername = username.getText();
                authController.authorize(enteredUsername, enteredPassword);
            }
        });
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;
        gc.gridx = 0;
        gc.weightx = 1;
        add(usernameLabel, gc);
        gc.gridy = 0;
        gc.gridx = 1;
        gc.weightx = 1;
        add(username, gc);
        gc.gridy = 1;
        gc.gridx = 0;
        add(passwordLabel, gc);
        gc.gridy = 1;
        gc.gridx = 1;
        add(password, gc);
        gc.gridy = 2;
        gc.gridx = 0;
        gc.gridwidth = 2;
        add(login, gc);

    }

    public void addAuthController(AuthController authController){
        this.authController = authController;
    }
}
