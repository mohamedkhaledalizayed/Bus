package bus.itgds.khadametdz.view;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crowdfire.cfalertdialog.CFAlertDialog;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import java.util.ArrayList;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.utils.Utilities;
import bus.itgds.khadametdz.view.activity.AboutActivity;
import bus.itgds.khadametdz.view.activity.FeedBackActivity;
import bus.itgds.khadametdz.view.activity.FreeRidesActivity;
import bus.itgds.khadametdz.view.activity.NotificationActivity;
import bus.itgds.khadametdz.view.activity.ProfileActivity;
import bus.itgds.khadametdz.view.activity.ReservationActivity;
import bus.itgds.khadametdz.view.activity.ReservationDetailsActivity;
import bus.itgds.khadametdz.view.activity.SettingsActivity;
import bus.itgds.khadametdz.view.activity.TermsActivity;
import bus.itgds.khadametdz.view.activity.TicketDetailsActivity;
import bus.itgds.khadametdz.view.activity.TicketsActivity;
import bus.itgds.khadametdz.view.activity.WalletActivity;
import bus.itgds.khadametdz.view.fragment.FragmentBus1;
import bus.itgds.khadametdz.view.fragment.FragmentBus2;
import bus.itgds.khadametdz.view.fragment.FragmentBus3;
import bus.itgds.khadametdz.view.fragment.FragmentBus4;
import bus.itgds.khadametdz.view.interfaces.ITicketHandler;

public class MainActivity extends AppCompatActivity implements ITicketHandler,
        NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private String pageNameString = "FragInfoPage";
    private BottomNavigationView navigation;
    private DrawerLayout drawer;


    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;
    private FrameLayout notification;
    private TextView title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.custom_toolbar);
        title = findViewById(R.id.toolbar_title);
        notification = findViewById(R.id.notification);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        title.setText(getResources().getString(R.string.ic_bottom_nav_bus_reservation));

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, new FragmentBus1());
        transaction.commit();

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NotificationActivity.class));
            }
        });
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
//        location();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void location() {

        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};

        Permissions.check(this/*context*/, permissions, null/*rationale*/, null/*options*/, new PermissionHandler() {
                    @Override
                    public void onGranted() {
                        // do your task.
                        Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_LONG).show();
                        sendCurrentLocation();
                    }

                    @Override
                    public void onDenied(Context context, ArrayList<String> deniedPermissions) {
//                        super.onDenied(context, deniedPermissions);
                        Toast.makeText(MainActivity.this, "Denied", Toast.LENGTH_LONG).show();
                    }
                }

        );
    }

    @SuppressLint("MissingPermission")
    private void sendCurrentLocation() {

        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (manager != null) {
            if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Utilities.showBasicDialog(this, getString(R.string.enable_gps)
                        , getString(R.string.enable_gps_message)
                        , getString(R.string.settings), getString(R.string.cancel)
                        , positiveEnableGPS
                        , cancelDialog);
            } else {
                fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {

                            Log.e("lat", location.getLatitude() + " : " + location.getLongitude());



                        } else {
                            requestLocationUpdates();
                        }

                    }
                });
            }
        } else
            Utilities.showShortToast(this, "something_went_wrong");

    }


    @SuppressLint("MissingPermission")
    private void requestLocationUpdates() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(20000);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {

                        Log.e("lat", location.getLatitude() + " : " + location.getLongitude());


                        if (fusedLocationProviderClient != null)
                            fusedLocationProviderClient.removeLocationUpdates(locationCallback);

                    }
                }
            }
        };

        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);
    }

    private DialogInterface.OnClickListener positiveEnableGPS = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    };

    private DialogInterface.OnClickListener cancelDialog = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    };


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.profile:
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                break;
//
            case R.id.my_wallet:
                startActivity(new Intent(MainActivity.this, WalletActivity.class));
                break;

            case R.id.notification:
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                break;

            case R.id.free_trips:
                startActivity(new Intent(MainActivity.this, FreeRidesActivity.class));
                break;

            case R.id.settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                break;

            case R.id.terms:
                startActivity(new Intent(MainActivity.this, TermsActivity.class));
                break;

            case R.id.about_app:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;

            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;

            case R.id.logout:
                logout();
                break;
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_nav_bus_reservation:
                    title.setText(getResources().getString(R.string.ic_bottom_nav_bus_reservation));
                    loadFragment(new FragmentBus1());
                    pageNameString = "FragReservationPage";
                    return true;
                case R.id.bottom_nav_bus_ticket:
                    loadFragment(new FragmentBus2());
                    title.setText(getResources().getString(R.string.ic_bottom_nav_bus_ticket));
                    pageNameString = "FragTicketPage";
                    return true;
                case R.id.bottom_nav_bus_info:
                    loadFragment(new FragmentBus3());
                    title.setText(getResources().getString(R.string.ic_bottom_nav_bus_info));
                    pageNameString = "FragInfoPage";
                    return true;
                case R.id.bottom_nav_bus_help:
                    loadFragment(new FragmentBus4());
                    title.setText(getResources().getString(R.string.ic_bottom_nav_bus_help));
                    pageNameString = "FragHelpPage";
                    return true;
            }
            return false;
        }
    };

    private void logout() {
        CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                .setTitle("Logout")
                .setMessage("Are You Want To Logout.")
                .addButton("Ok", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                }).addButton("Cancel", -1, -1, CFAlertDialog.CFAlertActionStyle.NEGATIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                ;

// Show the alert
        builder.show();
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ic_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
//        if (pageNameString.equals("FragReservationPage")) {
//            super.onBackPressed();
//        } else {
//            navigation.setSelectedItemId(R.id.bottom_nav_bus_reservation);
//            pageNameString = "FragReservationPage";
//        }
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.global_menu, menu);
        return true;
    }

    @Override
    public void onClick(String id) {
        Intent intent = new Intent(this, ReservationDetailsActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
