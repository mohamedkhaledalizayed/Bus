package bus.itgds.khadametdz.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.ActivityForgetPasswordBinding;
import bus.itgds.khadametdz.view.MainActivity;

public class ForgetPasswordActivity extends AppCompatActivity{

    private ActivityForgetPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_forget_password);

    }

    public void send(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void sms(View view) {
        binding.verifyBy.setHint((R.string.phone_number));
    }

    public void email(View view) {
        binding.verifyBy.setHint((R.string.email));
    }
}
