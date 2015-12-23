package com.example.kristaps.trackgroups.services;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kristaps.trackgroups.core.MyApplication;
import com.example.kristaps.trackgroups.core.entities.Group;
import com.example.kristaps.trackgroups.core.entities.User;
import com.google.gson.JsonElement;
import org.json.JSONException;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by Caami on 7/8/2015.
 */
public class ApiService {

    private String apiLocation = "http:\\myApiLocation";
    String insertURL = "http://www.findme12.16mb.com/insertUser.php";
    HashMap<String,String> params;

    String showURL = "http://localhost/xampp/showUser.php";
    Boolean response;
    RequestQueue requestQueue;

    private Context context;
    public ApiService(){
    }

    public ApiService(MyApplication myApplication) {

       // requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

     public boolean registerUser(String email, String username, String password) {
         JsonObject jsonObject = new JsonObject();
         jsonObject.addProperty("username", username);
         jsonObject.addProperty("email", email);
         jsonObject.addProperty("password", password);


         HashMap<String,String> params = new HashMap<>();
         params.put("username", username);
         params.put("email", email);
         params.put("password", password);



         RequestHandler rh = new RequestHandler();
         String res = rh.sendPostRequest(insertURL, params);
         int rez = Integer.parseInt(res);
         if (rez == 1) response = true ;
         else response = false;




         //  new AddUser().execute();
         /*
         JSONObject json = sendRegisterRequest(jsonObject);
         try {
             int success = json.getInt("SUCCESS");
             if (success == 1) {
                 return true;
             } else {
                 return false;
             }
         } catch (JSONException e) {
             e.printStackTrace();
         }
         return true;*/
         return response;
     }



    class AddUser extends AsyncTask<String, String, String>
    {



        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

        }

        /**
         * Creating product
         * */
        protected String doInBackground(String... args) {

            RequestHandler rh = new RequestHandler();
            String res = rh.sendPostRequest(insertURL, params);
            int rez = Integer.parseInt(res);
            if (rez == 1) response = true ;
            else response = false;

            return res;

        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done

        }

    }


    private JSONObject sendRegisterRequest(final JsonObject  jsonObject)
    {

        String response = "";
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("json", jsonObject.toString()));
        InputStream is = null;
        JSONObject jObj = null;

        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(insertURL);
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            response = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(response);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON String
        return jObj;



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

            boolean result = resultJson.get("response").getAsBoolean();
            return result;

    }

    public String removeGroup(int groupID){

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("GroupID", groupID);
        return jsonObject.toString();

    }

    public ArrayList<User> listAllUsersFromGroup(int groupID){



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


