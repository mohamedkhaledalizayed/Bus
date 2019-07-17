package bus.itgds.khadametdz.view.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.utils.Utilities;
import bus.itgds.khadametdz.view.activity.SearchActivity;
import bus.itgds.khadametdz.view.interfaces.PurchaseTicketListenerr;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class FragmentBus1 extends Fragment implements View.OnClickListener,
        PurchaseTicketListenerr {
    private String[] cityNamesList = {"Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna", "Béjaïa", "Biskra", "Béchar",
            " Blida", " Bouira", "Tamanrasset", "Tébessa", " Tlemcen", "Tiaret", " Tizi Ouzou", "Alger",
            " Djelfa", " Jijel", "Sétif", "Saïda", "Skikda", " Sidi Bel Abbès", "Annaba", "Guelma",
            " Constantine", " Médéa", "Mostaganem", " M'Sila", " Mascara", "Ouargla", " Oran", "El Bayadh",
            " Illizi", "Bordj Bou Arreridj", " Boumerdès", "El Tarf", " Tindouf", " Tissemsilt", "El Oued",
            " Khenchela", "Souk Ahras", "Tipaza", "Mila", "Aïn Defla", "Naâma", "Aïn Témouchent", "Ghardaïa", "Relizane"};

    private Button searchButton;
    private Activity activity;
    private Context context;
    private TextView mainBusTextDate, reternDate, reternTime;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private SpinnerDialog spinnerDialog;
    private TextView from_to, to_from;
    private TextView id_text_time;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;

    @Override
    public void onResume() {
        super.onResume();
        location();
    }

    public void location() {

        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};

        Permissions.check(getActivity()/*context*/, permissions, null/*rationale*/, null/*options*/, new PermissionHandler() {
                    @Override
                    public void onGranted() {
                        // do your task.
                        sendCurrentLocation();
                    }

                    @Override
                    public void onDenied(Context context, ArrayList<String> deniedPermissions) {
//                        super.onDenied(context, deniedPermissions);
                        cardView.setVisibility(View.VISIBLE);
                    }
                }

        );
    }

    @SuppressLint("MissingPermission")
    private void sendCurrentLocation() {

        LocationManager manager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        if (manager != null) {
            if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//                Utilities.showBasicDialog(getActivity(), getString(R.string.enable_gps)
//                        , getString(R.string.enable_gps_message)
//                        , getString(R.string.settings), getString(R.string.cancel)
//                        , positiveEnableGPS
//                        , cancelDialog);

                cardView.setVisibility(View.VISIBLE);
            } else {
                fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {

                            cardView.setVisibility(View.GONE);
                            Log.e("lat", location.getLatitude() + " : " + location.getLongitude());



                        } else {
                            requestLocationUpdates();
                        }

                    }
                });
            }
        } else
            Utilities.showShortToast(getActivity(), "something_went_wrong");

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

                        cardView.setVisibility(View.GONE);
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

    private CardView cardView;
    private Button enable;
    private ImageView mapValuesImage;
    private String fromValue = "From";
    private String toValue = "To";
    private RadioButton ticketReturen, ticketOneWay;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bus_1, container, false);
        activity = getActivity();
        context = getContext();

        cardView = view.findViewById(R.id.gps_layout);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        mapValuesImage = view.findViewById(R.id.map_values_image);
        enable = view.findViewById(R.id.enable_btn);
        from_to = view.findViewById(R.id.id_spinner_source);
        to_from = view.findViewById(R.id.id_spinner_destination);
        mainBusTextDate = view.findViewById(R.id.id_text_date);
        reternDate = view.findViewById(R.id.id_text_date_return);
        reternTime = view.findViewById(R.id.id_text_time_return);
        ticketReturen = view.findViewById(R.id.ticket_returen);
        ticketOneWay = view.findViewById(R.id.ticket_one_way);

        id_text_time = view.findViewById(R.id.id_text_time);
        from_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                from();
            }
        });

        to_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                to();
            }
        });

        mapValuesImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromValue = from_to.getText().toString();
                toValue = to_from.getText().toString();

                if (fromValue.equalsIgnoreCase("From") || toValue.equalsIgnoreCase("To")){
                    Toast.makeText(getContext(),"Select Cities First", Toast.LENGTH_LONG).show();
                }else {
                    from_to.setText(toValue);
                    to_from.setText(fromValue);
                }
            }
        });
        enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        });

        final List<String> stateListArray = new ArrayList<>(Arrays.asList(cityNamesList));
        searchButton = view.findViewById(R.id.id_bus_button_search);
        final ArrayAdapter<String> spinnerArrayAdapterSource = new ArrayAdapter<>(context, R.layout.spinner_item, stateListArray);
        spinnerArrayAdapterSource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        final ArrayAdapter<String> spinnerArrayAdapterDestination = new ArrayAdapter<>(context, R.layout.spinner_item, stateListArray);
        spinnerArrayAdapterDestination.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        searchButton.setOnClickListener(this);
        mainBusTextDate.setOnClickListener(this);
        id_text_time.setOnClickListener(this);
        reternDate.setOnClickListener(this);
        reternTime.setOnClickListener(this);
        ticketReturen.setOnClickListener(this);
        ticketOneWay.setOnClickListener(this);
        mainBusTextDate.setText(new SimpleDateFormat("EEEE dd MMMM yyyy", Locale.getDefault()).format(new Date()));
        datePickerDialog = new DatePickerDialog(
                context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                try {
                    Date date = sdf.parse(year+""+month+""+dayOfMonth);
                    mainBusTextDate.setText(new SimpleDateFormat("EEEE dd MMMM yyyy", Locale.getDefault()).format(date));

                } catch (Exception ex) {
                    Log.e("Exception", ex.getMessage());
                    mainBusTextDate.setText(year+"/"+month+"/"+dayOfMonth);
                }

            }
        }, Integer.parseInt(new SimpleDateFormat("yyyy", Locale.getDefault()).format(new Date())),
                Integer.parseInt(new SimpleDateFormat("MM", Locale.getDefault()).format(new Date())) - 1,
                Integer.parseInt(new SimpleDateFormat("dd", Locale.getDefault()).format(new Date())));


        returenLayout = view.findViewById(R.id.card3);

        timePickerDialog = new TimePickerDialog(context,new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                id_text_time.setText(hourOfDay + " : "+ minute);
            }
        },10,2,true);
        return view;
    }

    private CardView returenLayout;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_bus_button_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.id_text_date:
                datePickerDialog.show();
                break;
            case R.id.id_text_time:
                timePickerDialog.show();
                break;
            case R.id.id_text_date_return:
                datePickerDialog.show();
                break;
            case R.id.id_text_time_return:
                timePickerDialog.show();
                break;
            case R.id.ticket_returen:
                returenLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.ticket_one_way:
                returenLayout.setVisibility(View.GONE);
                break;
        }
    }

    private ArrayList<String> items = new ArrayList<>();


    private void from() {
        for (int i = 1; i <= 47; i++) {
            items.add(cityNamesList[i]);
        }
        spinnerDialog = new SpinnerDialog(getActivity(), items, "From", R.style.DialogAnimations_SmileWindow, "Close");// With 	Animation
        spinnerDialog.setCancellable(true); // for cancellable
        spinnerDialog.setShowKeyboard(false);// for open keyboard by default


        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                from_to.setText(item);
            }
        });
        spinnerDialog.showSpinerDialog();
    }

    private void to() {
        for (int i = 1; i <= 47; i++) {
            items.add(cityNamesList[i]);
        }
        spinnerDialog = new SpinnerDialog(getActivity(), items, "From", R.style.DialogAnimations_SmileWindow, "Close");// With 	Animation
        spinnerDialog.setCancellable(true); // for cancellable
        spinnerDialog.setShowKeyboard(false);// for open keyboard by default

        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                to_from.setText(item);
            }
        });
        spinnerDialog.showSpinerDialog();
    }

    @Override
    public void onTicketButtonClickToBuy(String busTicketPrice) {

    }


}