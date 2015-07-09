package com.example.kristaps.trackgroups.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.kristaps.trackgroups.core.MyApplication;
import com.example.kristaps.trackgroups.core.entities.Group;
import com.example.kristaps.trackgroups.core.entities.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

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

     public boolean registerUser(String email, String username, String password){
         JsonObject jsonObject = new JsonObject();
         jsonObject.addProperty("username", username);
         jsonObject.addProperty("email", email);
         jsonObject.addProperty("password", password);

         boolean isRequestProcessedSuccessfully = sendRegisterRequest(jsonObject);
         return isRequestProcessedSuccessfully;

    }

    private boolean sendRegisterRequest(JsonObject jsonObject) {
        //send request to the api and return result
       /* JsonObject resultJson = null;
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

        return resultJson;*/

        //send request to the api and return result
        JsonObject resultJson = null;
        try {
            resultJson = Ion.with(context)
                    .load("http://example.com/post")
                    .setJsonObjectBody(jsonObject)
                    .asJsonObject().get();
            Boolean result = resultJson.get("response").getAsBoolean();
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }

    }
     public User login(String username, String password) {

        JsonObject jsonObject = new JsonObject();
        //User resUser = null;
         User resUser = new User();
         resUser.setUserID(1);
         resUser.setEmail("email");
         resUser.setUsername("username");
         resUser.setPassword("pass");
            /*jsonObject.addProperty("username", username);
            jsonObject.addProperty("password", password);
             JsonObject resultJson = null;
             try {
                 resultJson = Ion.with(context)
                         .load("http://example.com/post")
                         .setJsonObjectBody(jsonObject)
                         .asJsonObject().get();
                 if (resultJson == null) return  null;
                 String result = resultJson.get("response").getAsString();*/
                 return resUser;
             /*} catch (InterruptedException e) {
                 e.printStackTrace();
                 return resUser;
             } catch (ExecutionException e) {
                 e.printStackTrace();
                 return resUser;
             }
*/

       /* User currentUser = new User();
        currentUser.setUserID(1);
        currentUser.setUsername("Test");
        currentUser.setEmail("email");
*/
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

     public boolean addNewGroup(String groupName, String groupDescription, int ownerID) {

        /*Group group = new Group();
        group.setGroupID(1);
        group.setName(groupName);
        group.setDescription(groupDescription);
        group.setOwnerId(ownerID);*/

         JsonObject jsonObject = new JsonObject();

         jsonObject.addProperty("Group name", groupName);
         jsonObject.addProperty("Group description", groupDescription);
         jsonObject.addProperty("Owner id", ownerID);


         JsonObject resultJson = null;
         try {
             resultJson = Ion.with(context)
                     .load("http://example.com/post")
                     .setJsonObjectBody(jsonObject)
                     .asJsonObject().get();
             boolean result = resultJson.get("response").getAsBoolean();
             return result;
         } catch (InterruptedException e) {
             e.printStackTrace();
             return false;
         } catch (ExecutionException e) {
             e.printStackTrace();
             return false;
         }

     }

    public boolean removeUserFromGroup(int groupID, int userID){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("GroupID", groupID);
        jsonObject.addProperty("UserID", userID);

        JsonObject resultJson = null;
        try {
            resultJson = Ion.with(context)
                    .load("http://example.com/post")
                    .setJsonObjectBody(jsonObject)
                    .asJsonObject().get();
            boolean result = resultJson.get("response").getAsBoolean();
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String removeGroup(int groupID){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("GroupID", groupID);
        return jsonObject.toString();

    }

    public ArrayList<User> listAllUsersFromGroup(int groupID){

/*        User user1 = new User();
        User user2 = new User();

        user1.setUserID(1);
        user1.setUsername("First username");
        user1.setEmail("First user email");

        user1.setUserID(2);
        user1.setUsername("Second username");
        user1.setEmail("Second user email");

        ArrayList<User> result = new ArrayList<>();
        result.add(user1);
        result.add(user2);*/

        //return result;

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("GroupID", groupID);

        //send request to the api and return result
        JsonObject resultJson = null;
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

        if (resultJson == null) return null;

        ArrayList<User> usersList = new ArrayList<>();
        for (JsonElement users : resultJson.getAsJsonArray("users")) {
            JsonObject userObject = users.getAsJsonObject();
            User user = new User();
            user.setUsername(userObject.get("name").getAsString());
            usersList.add(user);
        }

        return usersList;
    }

    public String reportUserLocation(int userID, double longitude, double latitude){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("UserID", userID);
        jsonObject.addProperty("Longitude", longitude);
        jsonObject.addProperty("Latitude", latitude);

        return jsonObject.toString();
    }




}


