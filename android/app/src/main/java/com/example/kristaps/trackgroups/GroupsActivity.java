package com.example.kristaps.trackgroups;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class GroupsActivity extends ActionBarActivity {
    private ArrayAdapter arrayAdapter;
    private ListView GroupList;
    private String[] Users = {"Android Beginners", "Android Experts"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        setTitle("Groups");

        GroupList = (ListView) findViewById(R.id.mylist);
        // Context ctxt = getApplicationContext();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Users);


        GroupList.setAdapter(arrayAdapter);
        GroupList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent i = new Intent(getApplicationContext(), UserActivity.class);
                        i.putExtra("Usergroup", "group1");
                        startActivity(i);
                        break;
                    case 1:
                        Intent i2 = new Intent(getApplicationContext(), UserActivity.class);
                        i2.putExtra("Usergroup", "group2");
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3 = new Intent(getApplicationContext(), UserActivity.class);
                        i3.putExtra("Usergroup", "group3");
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4 = new Intent(getApplicationContext(), UserActivity.class);
                        i4.putExtra("Usergroup", "group4");
                        startActivity(i4);
                        break;
                    case 4:
                        Intent i5 = new Intent(getApplicationContext(), UserActivity.class);
                        i5.putExtra("Usergroup", "group5");
                        startActivity(i5);
                        break;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_groups, menu);
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
}
