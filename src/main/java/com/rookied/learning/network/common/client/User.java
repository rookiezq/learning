package com.rookied.learning.network.common.client;

import java.io.Serializable;

/**
 * @author zhangqiang
 * @date 2021/4/21
 */
public class User implements Serializable {
    private static final long serialVersionUID = -8660280019707851692L;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
