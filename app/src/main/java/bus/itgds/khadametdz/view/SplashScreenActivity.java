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
