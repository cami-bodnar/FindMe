package com.example.kristaps.trackgroups;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.SharedPreferences;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // REMEMBER ME
        SharedPreferences pref = getSharedPreferences("loginPrefs",MODE_PRIVATE);
        String username = pref.getString("username", null);
        String password = pref.getString("password", null);
        if (username != null && password != null) {
            startGroupsActivity();
        }
    }

    private void startGroupsActivity() {
        Intent i= new Intent( this,GroupsActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        if (id == R.id.action_map)
        {
            startMapsActivity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /**************** Start activity section ************************/
    private void startMapsActivity()
    {
        Intent intent = new Intent(this, MapsActivity.class);
    }

    public void showRegisterLayout(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


    public void showLoginLayout(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void showLoginLayout(){
        Intent newScreen = new Intent(getBaseContext(), LoginActivity.class);
        this.startActivity(newScreen);
    }

}
