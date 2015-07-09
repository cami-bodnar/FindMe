package com.example.kristaps.trackgroups.core.entities;

/**
 * Created by Caami on 7/8/2015.
 */
public class User {

    private int userID;
    private String username;
    private String email;
    private String password;
    private UserLocation lastLocation;

    public User()
    {}
    public User(int userID, String username, String email, String password, UserLocation lastLocation)
    {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.lastLocation = lastLocation;
    }


    public int getUserID()
    {
        return userID;
    }



    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLocation getLastLocation()
    {
        return lastLocation;
    }

    public void setLastLocation(UserLocation lastLocation)
    {
        this.lastLocation = lastLocation;
    }
}
