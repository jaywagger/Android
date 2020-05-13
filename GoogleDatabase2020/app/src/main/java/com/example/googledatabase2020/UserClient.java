package com.example.googledatabase2020;

import android.app.Application;

import com.example.googledatabase2020.models.User;


public class UserClient extends Application {

    private User user = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}