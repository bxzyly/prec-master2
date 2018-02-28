package com.goi.bean;

import com.goi.entity.User;

public class UserBean {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.user.setPassword(null);
    }
}
