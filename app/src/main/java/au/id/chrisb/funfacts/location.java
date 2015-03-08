package au.id.chrisb.funfacts;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

/**
 * Created by chris on 7/03/2015.

public class location extends Service implements LocationListener {

        private final Context mContext = null;

    public String provider;
    public Location location;
    public Double lat;
    public Double lon;
    public static final String LOC = "LocationDebug";
    private LocationManager locationManager;


    int isAvail = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
    Toast.makeText(this, isAvail , Toast.LENGTH_LONG).show();

    Log.d(LOC, ConnectionResult.SUCCESS+"");
    Log.d(LOC, isAvail+"");

    LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
    boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);

    if (!enabled ) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
    }

    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    Criteria criteria = new Criteria();
    provider = locationManager.getBestProvider(criteria, false);
    location = locationManager.getLastKnownLocation(provider);

    if ( location != null ) {
        Log.d(LOC, "provider" + provider);
        onLocationChanged(location);
    } else {
        Log.d(LOC, "unknown location");
    }

    locationManager.requestLocationUpdates(provider,400,1,this);

    @Override
    public void onLocationChanged(Location location) {
        Log.d(LOC, location.getLatitude()+"");
        lat = location.getLatitude();
        lon = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

}
 */