package com.example.kristaps.trackgroups;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kristaps.trackgroups.core.MyApplication;


public class RegisterActivity extends ActionBarActivity {

    private MyApplication myApplication = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        try {
            myApplication = (MyApplication) getApplicationContext();
        } catch (ClassCastException e) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void sendRegisterRequest(View view) {
        try {
            // first take entered values from form
            String email = getEmailValue();
            String username = getUsernameValue();
            String password = getPasswordValue();
            String passwordConfirmation = getPasswordConfirmationValue();
            if (password.equals(passwordConfirmation))
                processRegisterRequest(email, username, password);
            else
                Toast.makeText(this, "Error. Passwords do not match ", Toast.LENGTH_LONG);
        }catch(Exception e){
            Log.e("sendRegisterRequest", "Error occurred", e);
        }
    }

    private String getEmailValue() {
        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        return emailEditText.getText().toString();
    }

    private String getPasswordConfirmationValue() {
        EditText confirmPasswordEditText = (EditText) findViewById(R.id.confirmPasswordEditText);
        return confirmPasswordEditText.getText().toString();
    }

    private String getPasswordValue() {
        EditText registerPasswordEditText = (EditText) findViewById(R.id.registerPasswordEditText);
        return registerPasswordEditText.getText().toString();
    }

    private String getUsernameValue() {
        EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        return usernameEditText.getText().toString();
    }

    public void processRegisterRequest(String email, String username, String password) {
        Log.i("proccessRegisterRequest", "start executing");
        // here need to be implemented logic for sending API request
        boolean isRequestProcessedSuccessfully = myApplication.getApiService().registerUser(email, username, password);
        if (isRequestProcessedSuccessfully)
            showLoginLayout();
        else
            Toast.makeText(this, R.string.registartionFailed, Toast.LENGTH_LONG);
    }
    public void showLoginLayout() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void registerUser(View view) {
        // SEND REGISTER REQUEST
        sendRegisterRequest(view);
        // SHOW LOGIN LAYOUT
        showLoginLayout();
    }




}
