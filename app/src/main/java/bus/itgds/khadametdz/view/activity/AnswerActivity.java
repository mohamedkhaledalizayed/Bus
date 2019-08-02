package bus.itgds.khadametdz.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.ActivityAnswerBinding;

public class AnswerActivity extends AppCompatActivity {

    private int answer = 0;
    private ActivityAnswerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_answer);

        answer = getIntent().getIntExtra("answer",0);


        binding.answer.setText("Answer Screen "+answer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.faq));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
