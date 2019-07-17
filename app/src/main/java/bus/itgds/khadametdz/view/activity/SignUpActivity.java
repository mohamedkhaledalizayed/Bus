package bus.itgds.khadametdz.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.view.MainActivity;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void signUp(View view) {
        startActivity(new Intent(this, VerificationActivity.class));
        finish();
    }

    public void singIn(View view) {
        finish();
    }

    public void sms(View view) {
    }

    public void email(View view) {
    }
}
