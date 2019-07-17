package bus.itgds.khadametdz.view.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.EncodedPolyline;

import java.util.ArrayList;
import java.util.List;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.view.fragment.FragmentBus3;

public class ActivityMaps extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {
    private String cityStationName;

//    private Context context;
//    private Activity activity;
//    private static final int globalPermissionRequestCode = 101;
//    private boolean mLocationPermissionGranted = false;
//    private GoogleMap googleMap;
//    private FusedLocationProviderClient fusedLocationProviderClient;
//    private static final float DEFAULT_ZOOM = 20f;
//    private Double cityStationLatitude;
//    private Double cityStationLongitude;
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_maps);
//        context = this;
//        activity = ActivityMaps.this;
//        cityStationLatitude=getIntent().getDoubleExtra(FragmentBus3.MAIN_BUS_STATE_LATITUDE,1.0);
//        cityStationLongitude=getIntent().getDoubleExtra(FragmentBus3.MAIN_BUS_STATE_LONGITUDE,1.0);
//
//        getLocationPermission();
//        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        supportMapFragment.getMapAsync(this);
//        findViewById(R.id.id_bus_my_location_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getDeviceCurrentLocation();
//            }
//        });
//    }
//
//
//    private void getLocationPermission() {
//        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
//        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                mLocationPermissionGranted = true;
//            } else {
//                ActivityCompat.requestPermissions(activity, permissions, globalPermissionRequestCode);
//            }
//        } else {
//            ActivityCompat.requestPermissions(activity, permissions, globalPermissionRequestCode);
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        mLocationPermissionGranted = false;
//        switch (requestCode) {
//            case globalPermissionRequestCode:
//                if (grantResults.length > 0) {
//                    for (int i = 0; i < grantResults.length; i++) {
//                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
//                            mLocationPermissionGranted = false;
//                            return;
//                        }
//                    }
//                    mLocationPermissionGranted = true;
//                }
//                break;
//        }
//    }
//
//
//    @Override
//    public void onMapReady(GoogleMap map) {
//        googleMap = map;
//        if (mLocationPermissionGranted) {
//            getDeviceCurrentLocation();
//            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
//                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                return;
//            }
//            googleMap.setMyLocationEnabled(true);
//            googleMap.getUiSettings().setMyLocationButtonEnabled(false);
//            googleMap.getUiSettings().setZoomControlsEnabled(true);
//        }
//    }
//
//
//    private void getDeviceCurrentLocation() {
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
//        try {
//            if (mLocationPermissionGranted) {
//                Task location = fusedLocationProviderClient.getLastLocation();
//                location.addOnCompleteListener(new OnCompleteListener() {
//                    @Override
//                    public void onComplete(@NonNull Task task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(context, "Found Location", Toast.LENGTH_LONG).show();
//                            Location currentLocation = (Location) task.getResult();
//                            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), DEFAULT_ZOOM, "Current Location");
//                        } else {
//                            Toast.makeText(context, "Not Found", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//            }
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void moveCamera(LatLng latLng, float zoom, String title) {
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
//        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(title);
//        googleMap.addMarker(markerOptions).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_you_map_logo));
//        googleMap.addMarker(new MarkerOptions().position(new LatLng(cityStationLatitude, cityStationLongitude)).title("city")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_city_map_logo));
//        Polyline line = googleMap.addPolyline(new PolylineOptions()
//                .add(latLng, new LatLng(cityStationLatitude, cityStationLongitude))
//                .width(5)
//                .color(Color.RED));
//    }
//}

    private GoogleMap mMap;
    private String TAG = "so47492459";
    private double cityStationLatitude;
    private double cityStationLongitude;
    private Activity activity;
    private Context context;
    private static final int globalPermissionRequestCode = 101;
    private boolean mLocationPermissionGranted = false;
    private ImageButton mainCloseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        activity = ActivityMaps.this;
        context = this;
//        cityStationLatitude = getIntent().getDoubleExtra(FragmentBus3.MAIN_BUS_STATE_LATITUDE, 1.0);
//        cityStationLongitude = getIntent().getDoubleExtra(FragmentBus3.MAIN_BUS_STATE_LONGITUDE, 1.0);
//        cityStationName = getIntent().getStringExtra(FragmentBus3.MAIN_BUS_STATE_NAME);
        mainCloseButton = findViewById(R.id.id_main_close_button);
        mainCloseButton.setOnClickListener(this);
        getLocationPermission();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    private void getLocationPermission() {
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionGranted = true;
            } else {
                ActivityCompat.requestPermissions(activity, permissions, globalPermissionRequestCode);
            }
        } else {
            ActivityCompat.requestPermissions(activity, permissions, globalPermissionRequestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case globalPermissionRequestCode:
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            mLocationPermissionGranted = false;
                            return;
                        }
                    }
                    mLocationPermissionGranted = true;
                }
                break;
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (mLocationPermissionGranted) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap = googleMap;
            getDeviceCurrentLocation();
        }
    }


    private void getDeviceCurrentLocation() {
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        try {
            if (mLocationPermissionGranted) {
                Task location = fusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Location currentLocation = (Location) task.getResult();
                            if (currentLocation != null) {
                                double currentLocationLatitude = currentLocation.getLatitude();
                                double currentLocationLongitude = currentLocation.getLongitude();

                                LatLng currentPlace = new LatLng(currentLocationLatitude, currentLocationLongitude);
//                                mMap.addMarker(new MarkerOptions().position(currentPlace).title("Current Location")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_city_map_current));

                                LatLng busStationLatLong = new LatLng(cityStationLatitude, cityStationLongitude);
//                                mMap.addMarker(new MarkerOptions().position(busStationLatLong).title(cityStationName)).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_city_map_logo));


                                //Define list to get all latlng for the route
                                List<LatLng> path = new ArrayList();

                                //Execute Directions API request
                                GeoApiContext context = new GeoApiContext.Builder()
                                        .apiKey("AIzaSyD76bEtE71M7PRUI8efr-3S69m3rfS867c")
                                        .build();

                                String sourceLatLongString = String.valueOf(currentLocationLatitude) + "," + String.valueOf(currentLocationLongitude);
                                String destinationLatLongString = String.valueOf(cityStationLatitude) + "," + String.valueOf(cityStationLongitude);
                                DirectionsApiRequest req = DirectionsApi.getDirections(context, sourceLatLongString, destinationLatLongString);
                                try {
                                    DirectionsResult res = req.await();

                                    //Loop through legs and steps to get encoded polylines of each step
                                    if (res.routes != null && res.routes.length > 0) {
                                        DirectionsRoute route = res.routes[0];

                                        if (route.legs != null) {
                                            for (int i = 0; i < route.legs.length; i++) {
                                                DirectionsLeg leg = route.legs[i];
                                                if (leg.steps != null) {
                                                    for (int j = 0; j < leg.steps.length; j++) {
                                                        DirectionsStep step = leg.steps[j];
                                                        if (step.steps != null && step.steps.length > 0) {
                                                            for (int k = 0; k < step.steps.length; k++) {
                                                                DirectionsStep step1 = step.steps[k];
                                                                EncodedPolyline points1 = step1.polyline;
                                                                if (points1 != null) {
                                                                    //Decode polyline and add points to list of route coordinates
                                                                    List<com.google.maps.model.LatLng> coords1 = points1.decodePath();
                                                                    for (com.google.maps.model.LatLng coord1 : coords1) {
                                                                        path.add(new LatLng(coord1.lat, coord1.lng));
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            EncodedPolyline points = step.polyline;
                                                            if (points != null) {
                                                                //Decode polyline and add points to list of route coordinates
                                                                List<com.google.maps.model.LatLng> coords = points.decodePath();
                                                                for (com.google.maps.model.LatLng coord : coords) {
                                                                    path.add(new LatLng(coord.lat, coord.lng));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception ex) {
                                    Log.e("qwerty", "praveen" + ex.toString());
                                    Log.e(TAG, ex.getLocalizedMessage());
                                }

                                //Draw the polyline
                                if (path.size() > 0) {
                                    PolylineOptions opts = new PolylineOptions().addAll(path).color(R.color.colorPrimary).width(5);
                                    mMap.addPolyline(opts);
                                }

                                mMap.getUiSettings().setZoomControlsEnabled(true);

                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentPlace, 6));
                            } else {
                                Log.e("qwerty", "papa not fount");
                            }
                        } else {
                            Toast.makeText(context, "Not Found", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_main_close_button:
                finish();
                break;
        }
    }
}