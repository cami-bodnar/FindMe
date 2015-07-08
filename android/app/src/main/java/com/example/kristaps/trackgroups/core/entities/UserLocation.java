package com.example.kristaps.trackgroups.core.entities;

/**
 * Created by Caami on 7/8/2015.
 */
public class UserLocation {

    private int userLocationID;
    private int userID;
    private double longitude;
    private double latitude;
    private boolean created;


    public UserLocation()
    {
    }

    public UserLocation(int id,int userId, double longitude,double latitude,boolean created)
    {

        this.userLocationID = id;
        this.userID = userId;
        this.longitude =  longitude;
        this.latitude = latitude;
        this.created = created;
    }

    public int getUserLocationID() {
        return userLocationID;
    }

    public void setUserLocationID(int userLocationID) {
        this.userLocationID = userLocationID;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }
}
