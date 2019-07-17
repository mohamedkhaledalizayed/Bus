package bus.itgds.khadametdz.view.fragment;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.FragmentBus4Binding;
import bus.itgds.khadametdz.utils.AppUtils;
import bus.itgds.khadametdz.view.activity.AnswerActivity;


public class FragmentBus4 extends Fragment implements View.OnClickListener {


    private FragmentBus4Binding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_bus_4, container, false);


        binding.facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebook();
            }
        });
        binding.twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.sendMail(getActivity(),"Support@it-gds.com","Title");
            }
        });


        binding.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("1234567890");
            }
        });

        binding.whatsup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whatsApp();
            }
        });

        binding.feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedback();
            }
        });

        binding.tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnswerActivity.class);
                intent.putExtra("answer",1);
                startActivity(intent);
            }
        });

        binding.tx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnswerActivity.class);
                intent.putExtra("answer",2);
                startActivity(intent);
            }
        });

        binding.tx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnswerActivity.class);
                intent.putExtra("answer",3);
                startActivity(intent);
            }
        });

        binding.tx4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnswerActivity.class);
                intent.putExtra("answer",4);
                startActivity(intent);
            }
        });

        binding.tx5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnswerActivity.class);
                intent.putExtra("answer",5);
                startActivity(intent);
            }
        });

        binding.tx6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnswerActivity.class);
                intent.putExtra("answer",6);
                startActivity(intent);
            }
        });

        binding.tx7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnswerActivity.class);
                intent.putExtra("answer",7);
                startActivity(intent);
            }
        });

        binding.tx8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnswerActivity.class);
                intent.putExtra("answer",8);
                startActivity(intent);
            }
        });

        binding.tx9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnswerActivity.class);
                intent.putExtra("answer",9);
                startActivity(intent);
            }
        });

        binding.tx10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AnswerActivity.class);
                intent.putExtra("answer",10);
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {

    }

    public void feedback() {
        FragmentManager fm = getChildFragmentManager();
//                getActivity().getSupportFragmentManager();
        FeedbackDialog editNameDialogFragment =new FeedbackDialog();
        editNameDialogFragment.show(fm, "");
        editNameDialogFragment.setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
    }

    public void openFacebook() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/mohamed.k.zayed.12"));
            startActivity(intent);
        } catch(Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/mohamed.k.zayed.12")));
        }
    }



    public void call(String number){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void whatsApp() {
        String number="201141619993";

        try {
            Intent sendIntent = new Intent("android.intent.action.MAIN");
            sendIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
            sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(number)+"@s.whatsapp.net");
            startActivity(sendIntent);

        } catch(Exception e) {
            Log.e("Error", "ERROR_OPEN_MESSANGER"+e.toString());
        }
    }

}