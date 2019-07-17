package bus.itgds.khadametdz.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.ActivitySignInBinding;
import bus.itgds.khadametdz.utils.Utilities;
import bus.itgds.khadametdz.view.MainActivity;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in);
        Utilities.setHtmlText(R.string.skip,binding.skip);
        Utilities.setHtmlText(R.string.forget_password,binding.forgetPassword);
    }

    public void signIn(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void singUp(View view) {
        startActivity(new Intent(this,SignUpActivity.class));
    }

    public void skip(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void forgetPassword(View view) {
        startActivity(new Intent(this, ForgetPasswordActivity.class));
    }
}
