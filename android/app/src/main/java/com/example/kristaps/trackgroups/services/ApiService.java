package com.example.kristaps.trackgroups.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.kristaps.trackgroups.core.MyApplication;
import com.example.kristaps.trackgroups.core.entities.Group;
import com.example.kristaps.trackgroups.core.entities.User;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.apache.*;
import org.json.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Caami on 7/8/2015.
 */
public class ApiService {

    private String apiLocation = "http:\\myApiLocation";

    private Context context;
    public ApiService(){
    }

    public ApiService(MyApplication myApplication) {

    }

    // public boolean registerUser(String email, String username, String password)
    public String registerUser(User user){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", user.getUsername());
            jsonObject.put("email", user.getEmail());
            jsonObject.put("password", user.getPassword());
            //return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        String isRequestProcessedSuccessfully = sendRegisterRequest(jsonObject);
        return isRequestProcessedSuccessfully;
    }

    private String sendRegisterRequest(JSONObject jsonObject) {
        //send request to the api and return result
        JSONObject resultJson = new JSONObject();
        try {
             resultJson = Ion.with(context)
                    .load("http://example.com/post")
                    .setJsonObjectBody(jsonObject)
                    .asJsonObject().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return resultJson.toString();
    }
    // public User login(String username, String password)
    public String login(User user){

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", user.getUsername());
            jsonObject.put("password", user.getPassword());
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

       /* User currentUser = new User();
        currentUser.setUserID(1);
        currentUser.setUsername("Test");
        currentUser.setEmail("email");
*/
        return null;
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

    // public Group addNewGroup(String groupName, String groupDescription, int ownerID)
    public String addNewGroup(Group group){

        /*Group group = new Group();
        group.setGroupID(1);
        group.setName(groupName);
        group.setDescription(groupDescription);
        group.setOwnerId(ownerID);*/

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Group name", group.getName());
            jsonObject.put("Group description", group.getDescription());
            jsonObject.put("Owner id", group.getOwnerId());
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

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


