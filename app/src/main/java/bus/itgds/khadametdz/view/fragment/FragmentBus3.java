package bus.itgds.khadametdz.view.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.ArrayList;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.model.ModelBusStationDetail;

public class FragmentBus3 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bus_3, container, false);

        RecyclerView mainRecyclerView = view.findViewById(R.id.id_frag_bus_rv);
        RecyclerViewBus mAdapter = new RecyclerViewBus(getBusStationDetail());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mainRecyclerView.setLayoutManager(mLayoutManager);
        mainRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mainRecyclerView.setAdapter(mAdapter);
        return view;
    }


    private class RecyclerViewBus extends RecyclerView.Adapter<RecyclerViewBus.MyViewHolder> {
        private ArrayList<ModelBusStationDetail> stationNames;

        public RecyclerViewBus(ArrayList<ModelBusStationDetail> stationNames) {
            this.stationNames = stationNames;
        }

        @NonNull
        @Override
        public RecyclerViewBus.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_bus_station, viewGroup, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewBus.MyViewHolder myViewHolder, int i) {
            ModelBusStationDetail modelBusStationDetail = stationNames.get(i);
            myViewHolder.mainBusStationText.setText(modelBusStationDetail.getBusStationNumber() + " " + modelBusStationDetail.getBusStationNames());
        }

        @Override
        public int getItemCount() {
            return stationNames.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView mainBusStationText;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                mainBusStationText = itemView.findViewById(R.id.id_card_bus_station_text);
            }

            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), MapActivity.class));
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                        Uri.parse("http://maps.google.com/maps?saddr=?,?&daddr=30.048578,30.9567804"));
//                startActivity(intent);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<lat>,<long>?q=<"+30.048578+">,<"+30.9567804+"< (Bus Station) >"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(getActivity().getPackageManager())!=null){
                    startActivity(intent);
                }
            }
        }
    }

    private ArrayList<ModelBusStationDetail> getBusStationDetail() {
        ArrayList<ModelBusStationDetail> arrayListBus = new ArrayList<>();
        arrayListBus.add(new ModelBusStationDetail("1", "Adrar", 27.89972222, 0.28305556));
        arrayListBus.add(new ModelBusStationDetail("2", "Chlef", 36.17041363, 1.319960489));
        arrayListBus.add(new ModelBusStationDetail("3", "Laghouat", 33.79972222, 2.88305556));
        arrayListBus.add(new ModelBusStationDetail("4", "Oum El Bouaghi", 35.87750000, 7.11361111));
        arrayListBus.add(new ModelBusStationDetail("5", "Batna", 35.56995933, 6.170000365));
        arrayListBus.add(new ModelBusStationDetail("6", "Bejaia", 36.76037762, 5.070015827));
        arrayListBus.add(new ModelBusStationDetail("7", "Biskra", 33.37040367, 6.859984089));
        arrayListBus.add(new ModelBusStationDetail("8", "Bechar", 32.04926984, -1.251381268));
        arrayListBus.add(new ModelBusStationDetail("9", "Blida", 36.4203467, 2.829997517));
        arrayListBus.add(new ModelBusStationDetail("10", "Bouira", 36.38047833, 3.900009724));
        arrayListBus.add(new ModelBusStationDetail("11", "Tamanghasset", 23.69394004, 5.164738727));
        arrayListBus.add(new ModelBusStationDetail("12", "Tebessa", 35.41043418, 8.120010537));
        arrayListBus.add(new ModelBusStationDetail("13", "Tlemcen", 34.89041424, -1.32000757));
        arrayListBus.add(new ModelBusStationDetail("14", "Tiaret", 35.38043601, 1.319960489));
        arrayListBus.add(new ModelBusStationDetail("15", "Tizi Ouzou", 36.80000111, 4.033332556));
        arrayListBus.add(new ModelBusStationDetail("16", "Alger", 36.7630648, 3.05055253));
        arrayListBus.add(new ModelBusStationDetail("17", "Djelfa", 34.67998781, 3.250023558));
        arrayListBus.add(new ModelBusStationDetail("18", "Jijel", 36.82199703, 5.76600356));
        arrayListBus.add(new ModelBusStationDetail("19", "Setif", 36.18002545, 5.399969847));
        arrayListBus.add(new ModelBusStationDetail("20", "Saida", 34.84039146, 0.14003251));
        arrayListBus.add(new ModelBusStationDetail("21", "Skikda", 36.88042198, 6.899981647));
        arrayListBus.add(new ModelBusStationDetail("22", "Sidi Bel Abbes", 35.19034426, -0.639971559));
        arrayListBus.add(new ModelBusStationDetail("23", "Annaba", 36.92000612, 7.759980834));
        arrayListBus.add(new ModelBusStationDetail("24", "Guelma", 36.46600213, 7.427997486));
        arrayListBus.add(new ModelBusStationDetail("25", "Constantine", 36.35998863, 6.599948281));
        arrayListBus.add(new ModelBusStationDetail("26", "Medea", 36.27040753, 2.770001179));
        arrayListBus.add(new ModelBusStationDetail("27", "Mostaganem", 35.940376, 0.089983885));
        arrayListBus.add(new ModelBusStationDetail("28", "M 'sila", 35.7000031, 4.545000584));
        arrayListBus.add(new ModelBusStationDetail("29", "Mascara", 35.40040895, 0.14003251));
        arrayListBus.add(new ModelBusStationDetail("30", "Ouargla", 31.70234011, 6.054451862));
        arrayListBus.add(new ModelBusStationDetail("31", "Oran", 35.71000246, -0.61997278));
        arrayListBus.add(new ModelBusStationDetail("32", "El Bayadh", 33.6903583, 1.009953571));
        arrayListBus.add(new ModelBusStationDetail("33", "Illizi", 24.5529057, 9.482252969));
        arrayListBus.add(new ModelBusStationDetail("34", "Bordj Bou Arreridj", 36.05900401, 4.629996466));
        arrayListBus.add(new ModelBusStationDetail("35", "Boumerdès", 36.7666636, 3.472998108));
        arrayListBus.add(new ModelBusStationDetail("36", "El Tarf", 36.7672, 8.31377));
        arrayListBus.add(new ModelBusStationDetail("37", "Tindouf", 27.67418805, -8.147782025));
        arrayListBus.add(new ModelBusStationDetail("38", "Tissemsilt", 35.60722, 1.81081));
        arrayListBus.add(new ModelBusStationDetail("39", "El Oued", 33.35608, 6.86319));
        arrayListBus.add(new ModelBusStationDetail("40", "Khenchela", 35.416667, 7.133333));
        arrayListBus.add(new ModelBusStationDetail("41", "Souk Ahras", 36.29038047, 7.949995075));
        arrayListBus.add(new ModelBusStationDetail("42", "Tipaza", 36.617879, 2.391236));
        arrayListBus.add(new ModelBusStationDetail("43", "Mila ", 45.465422, 9.185924));
        arrayListBus.add(new ModelBusStationDetail("44", "Aïn Defla", 36.072919, 1.988153));
        arrayListBus.add(new ModelBusStationDetail("45", "Naâma", 32.76041506, -0.579949383));
        arrayListBus.add(new ModelBusStationDetail("46", "Aïn Témouchent", 35.30725, -1.142451));
        arrayListBus.add(new ModelBusStationDetail("47", "Ghardaïa", 30.56662132, 2.883327595));
        arrayListBus.add(new ModelBusStationDetail("48", "Relizane", 35.733333, 0.55));


        return arrayListBus;
    }

}