package bus.itgds.khadametdz.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.FeedbackDialogBinding;


public class FeedbackDialog extends DialogFragment {

    private FeedbackDialogBinding binding;
    public static FeedbackDialog newInstance() {
        FeedbackDialog frag = new FeedbackDialog();
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.feedback_dialog, container, false);

        return binding.getRoot();
    }
}