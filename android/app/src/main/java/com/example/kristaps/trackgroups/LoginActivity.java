package com.example.kristaps.trackgroups;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.kristaps.trackgroups.core.MyApplication;
import com.example.kristaps.trackgroups.core.entities.User;


public class LoginActivity extends ActionBarActivity {

    private MyApplication myApplication = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        try {
            myApplication = (MyApplication) getApplicationContext();
        }
        catch (ClassCastException e)
        {
            
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    public void loginUser(View view) {
        // get username and password from login layout
        String username = getUsername();
        String password = getPassword();
        User user = myApplication.getApiService().login(username, password);
       if( user !=null){
           myApplication.setCurrentUser(user);
       }

    }

    private String getUsername() {
        EditText emailOrUsernameEditText = (EditText) findViewById(R.id.emailOrUsernameEditText);
        return emailOrUsernameEditText.getText().toString();
    }

    private String getPassword() {
        EditText loginPasswordEditText = (EditText) findViewById(R.id.loginPasswordEditText);
        return loginPasswordEditText.getText().toString();
    }
}
