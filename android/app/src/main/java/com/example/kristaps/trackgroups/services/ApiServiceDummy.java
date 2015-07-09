package com.example.kristaps.trackgroups.services;

import android.content.Context;

import com.example.kristaps.trackgroups.core.MyApplication;
import com.example.kristaps.trackgroups.core.entities.Group;
import com.example.kristaps.trackgroups.core.entities.User;
import com.example.kristaps.trackgroups.core.entities.UserLocation;
import com.google.gson.JsonObject;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Caami on 7/9/2015.
 */
public class ApiServiceDummy {

    private String apiLocation = "http:\\myApiLocation";

    private Context context;
    public ApiServiceDummy(){
    }

    public ApiServiceDummy(MyApplication myApplication) {

    }

    public boolean registerUser(String email, String username, String password){

      return true;

    }


    public User login(String username, String password) {

        User currentUser = new User();
        currentUser.setUserID(1);
        currentUser.setUsername("Mladen");
        currentUser.setEmail("Mladen.Planic@gmail.com");

        return currentUser;
    }

    public ArrayList<Group> listAllUserGroups(int userID){

        Group group1 = new Group();
        Group group2 = new Group();

        group1.setGroupID(1);
        group1.setName("Android Beginners");

        group1.setGroupID(2);
        group1.setName("Android Experts");

        ArrayList<Group> result = new ArrayList<>();
        result.add(group1);
        result.add(group2);

        return result;

    }

    public ArrayList<User> listAllUsersFromGroup(int groupID){

        ArrayList<User> list = new ArrayList<User>();
        UserLocation userloc1 = new UserLocation(1,1,42,19,true);
        UserLocation userloc2 = new UserLocation(2,2,46,23,true);
        UserLocation userloc3 = new UserLocation(3,3,50,14,true);
        UserLocation userloc4 = new UserLocation(4,4,46,25,true);
        UserLocation userloc5 = new UserLocation(5,5,42,22,true);
        User user1 = new User(1,"Kristaps","vilxsss@gmail.com","pass1",userloc1 );
        User user2 = new User(1,"Andreea","stefan.andreea08@gmail.com","pass2",userloc2 );
        User user3 = new User(1,"Tuur","tuurfrans@hotmail.com","pass3",userloc3 );
        User user4 = new User(1,"Cami","cami.bodnar@gmail.com","pass4",userloc4);
        User user5 = new User(1, "Ekko", "the_ekko@ymail.com", "pass5", userloc5);

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        return list;

    }

}
