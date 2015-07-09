package com.example.kristaps.trackgroups;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.kristaps.trackgroups.core.MyApplication;
import com.example.kristaps.trackgroups.core.entities.User;
import com.example.kristaps.trackgroups.core.entities.UserLocation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Iterator;

public class MapsActivity extends FragmentActivity
{
    private MyApplication myApplication = null;
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        //  onMapReady(mMap);
        myApplication = (MyApplication) getApplicationContext();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setUpMapIfNeeded();
    }




    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */




    private void setUpMap()
    {
        float hue = 0;
        int i = 0;
        // init dummy list
        ArrayList<User> list = new ArrayList<User>();
        UserLocation userloc1 = new UserLocation(1,1,42,19,true);
        UserLocation userloc2 = new UserLocation(2,2,46,23,true);
        UserLocation userloc3 = new UserLocation(3,3,50,14,true);
        UserLocation userloc4 = new UserLocation(4,4,46,25,true);
        UserLocation userloc5 = new UserLocation(5,5,42,22,true);
        User user1 = new User(1,"name1","mail1","pass",userloc1 );
        User user2 = new User(1,"name2","mail1","pass",userloc2 );
        User user3 = new User(1,"name3","mail1","pass",userloc3 );
        User user4 = new User(1,"name4","mail1","pass",userloc4);
        User user5 = new User(1, "name5", "mail1", "pass", userloc5);

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        Iterator<User> it = list.iterator();
        while(it.hasNext())
        {
            User user  = it.next();
            //add markers
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(user.getLastLocation().getLatitude(),user.getLastLocation().getLongitude()))
                    .title(user.getUsername())
                    .icon(BitmapDescriptorFactory.defaultMarker(hue)));
            if (hue <= 340) hue += 20;
            else
            {
                i++;
                hue = i;
            }
        }
    }


    public void onMapReady(GoogleMap map)
    {


    }

}
