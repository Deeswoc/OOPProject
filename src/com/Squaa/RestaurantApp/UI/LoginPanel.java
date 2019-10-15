package com.Squaa.RestaurantApp.UI;

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
    private AuthListener authListener;
    LoginPanel(){
        username = new JTextField("", 10);
        password = new JPasswordField("", 10);
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] enteredPassword = password.getPassword();
                String enteredUsername = username.getText();
                Level level = User.authorize(enteredUsername, enteredPassword);
                if(level!= Level.UNATHORIZED){
                    authListener.onAuth(level);
                    System.out.println("User is Authorized");
                }
            }
        });
        setLayout(new GridBagLayout());
        add(usernameLabel);
        add(username);
        add(passwordLabel);
        add(password);
        add(login);
    }

    public void addAuthListener(AuthListener authListener){
        this.authListener = authListener;
    }
}
