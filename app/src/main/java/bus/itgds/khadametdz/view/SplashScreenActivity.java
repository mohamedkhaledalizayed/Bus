package bus.itgds.khadametdz.view;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.view.activity.IntroSliderActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        ImageView imageView=findViewById(R.id.splash);

//        Glide.with(this)
//                .load(R.drawable.splash_animation)
//                .into(imageView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this,IntroSliderActivity.class));
                finish();
            }
        },5000);

    }
}

/*
*
•	SIGN IN should propose the Signup via Facebook or Gmail ( Same like in restaurant)
•	Sign up - need to add the symbols, also mandatory field in red star
•	When click on sign up, should go to the OTP number notification before to complete access
•	When Access to application is not requesting the GPS to be enabled.
•	Profile totally not done !!!!
•	There is no Menu for setting like other APP.
•	Complete the RFS for driver // amine
*/