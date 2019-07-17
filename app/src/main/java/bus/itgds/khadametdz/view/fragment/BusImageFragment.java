package bus.itgds.khadametdz.view.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.FragmentBusImageBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusImageFragment extends DialogFragment {


    private FragmentBusImageBinding binding;
    public BusImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bus_image, container, false);

        return binding.getRoot();
    }

}
