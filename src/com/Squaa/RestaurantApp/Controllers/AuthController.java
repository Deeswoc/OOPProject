package com.Squaa.RestaurantApp.Controllers;

import com.Squaa.RestaurantApp.DataLogic.State;

public class AuthController {
    private State state;

    public AuthController(State state){
        this.state = state;
    }

    public void authorize(String username, char[] password){
        state.Authorize(username, password);
    }
}
