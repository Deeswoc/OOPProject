package com.Squaa.RestaurantApp.DataLogic;

import java.util.ArrayList;

public class State {
    private ArrayList<AuthListener> authListeners;
    private Level level;

    private static State applicationState;
    private State(){
        authListeners = new ArrayList<>();
        level = Level.UNATHORIZED;
    }

    public static State getApplicationState(){
        if(applicationState == null){
            applicationState = new State();
        }
        return applicationState;
    }

    public void addAuthListener(AuthListener authListener){
        authListeners.add(authListener);
    }

    public void Authorize(String username, char[] password){
        this.level = User.authorize(username, password);
        for (AuthListener authlistener:authListeners) {
            authlistener.onAuth(level);
        }
    }
}
