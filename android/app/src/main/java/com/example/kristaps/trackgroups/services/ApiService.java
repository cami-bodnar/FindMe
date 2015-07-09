package com.example.kristaps.trackgroups.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.kristaps.trackgroups.core.entities.Group;
import com.example.kristaps.trackgroups.core.entities.User;

import java.util.ArrayList;

/**
 * Created by Caami on 7/8/2015.
 */
public class ApiService {



    private String apiLocation = "http:\\myApiLocation";

    public ApiService(){
    }

    public boolean registerUser(String email, String username, String password){
        boolean isRequestProcessedSuccessfully = sendRegisterRequest();
        return isRequestProcessedSuccessfully;
    }

    private boolean sendRegisterRequest() {
        //send request to the api and return result
        return true;
    }

    public User login(String username, String password){

        User currentUser = new User();
        currentUser.setUserID(1);
        currentUser.setUsername("Test");
        currentUser.setEmail("email");


        return currentUser;
    }

    public ArrayList<Group> listAllUserGroups(int userID){
        Group group1 = new Group();
        Group group2 = new Group();

        group1.setGroupID(1);
        group1.setName("First Group");


        group1.setGroupID(2);
        group1.setName("Second Group");

        ArrayList<Group> result = new ArrayList<>();
        result.add(group1);
        result.add(group2);

        return result;

    }

    public Group addNewGroup(String groupName, String groupDescription, int ownerID){

        Group group = new Group();
        group.setGroupID(1);
        group.setName(groupName);
        group.setDescription(groupDescription);
        group.setOwnerId(ownerID);

        return group;

    }

    public boolean removeUserFromGroup(int groupID, int userID){

        return true;
    }

    public boolean removeGroup(int groupID){

        return true;
    }

    public ArrayList<User> listAllUsersFromGroup(int groupID){

        User user1 = new User();
        User user2 = new User();

        user1.setUserID(1);
        user1.setUsername("First username");
        user1.setEmail("First user email");

        user1.setUserID(2);
        user1.setUsername("Second username");
        user1.setEmail("Second user email");


        ArrayList<User> result = new ArrayList<>();
        result.add(user1);
        result.add(user2);

        return result;


    }

    public boolean reportUserLocation(int userID, double longitude, double latitude){

        return true;
    }



}


