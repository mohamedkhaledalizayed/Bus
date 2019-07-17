package bus.itgds.khadametdz.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.FragmentBus2Binding;
import bus.itgds.khadametdz.view.adapter.ReservedTicketAdapter;
import bus.itgds.khadametdz.view.adapter.TicketAdapter;

public class FragmentBus2 extends Fragment {

    private FragmentBus2Binding binding;
    private ReservedTicketAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bus_2, container, false);

        mAdapter = new ReservedTicketAdapter(getActivity(),new ArrayList<String>());
        binding.lastTripsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.lastTripsRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.lastTripsRecycler.setAdapter(mAdapter);
        return binding.getRoot();
    }



}