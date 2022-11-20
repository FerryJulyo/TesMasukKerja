package com.ferry.loginhappypuppy;

public class Users {
    int session;
    String username;
    String password;

    public Users(int session, String username, String password) {
        this.session = session;
        this.username = username;
        this.password = password;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
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


