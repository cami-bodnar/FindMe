package com.example.kristaps.trackgroups.core;

import android.app.Application;

import com.example.kristaps.trackgroups.core.entities.User;
import com.example.kristaps.trackgroups.services.ApiService;
import com.example.kristaps.trackgroups.services.ApiServiceDummy;
import com.example.kristaps.trackgroups.services.SystemService;

import java.util.List;

/**
 * Created by Caami on 7/8/2015.
 */
public class MyApplication extends Application {

    private ApiService apiService = null;
    private ApiServiceDummy apiDummy = null;
    private SystemService systemService = null;
    private User currentUser;
    private List<User> displayUsersOnMap;



    public List<User> getDisplayUsersOnMap() {
        return displayUsersOnMap;
    }

    public void setDisplayUsersOnMap(List<User> displayUsersOnMap) {
        this.displayUsersOnMap = displayUsersOnMap;
    }



    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User value) {
         currentUser = value;
    }

    public MyApplication (){
        super();
        init();
    }

    private void init() {
        //apiService = new ApiService(this);
        apiDummy = new ApiServiceDummy(this);
        systemService = new SystemService();
        currentUser =  new User();
        currentUser.setUserID(1);
        currentUser.setUsername("Test");
        currentUser.setEmail("email");

    }

    public ApiService getApiService() {
        return apiService;
    }

    public SystemService getSystemService() {
        return systemService;
    }
}
