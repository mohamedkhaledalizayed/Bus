package bus.itgds.khadametdz.view.activity;

import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.view.fragment.SettingsFragment;

public class SettingsActivity extends PreferenceActivity {

    //https://gist.github.com/gldraphael/7ecd60525313275b56f9
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_settings);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Settings");

        // Display the fragment as the main content
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content,new SettingsFragment()).commit();

//        LinearLayout root = (LinearLayout)findViewById(android.R.id.list).getParent().getParent().getParent();
//        android.support.v7.widget.Toolbar bar = (android.support.v7.widget.Toolbar) LayoutInflater.from(this).inflate(R.layout.action_bar_setting, root, false);
//        root.addView(bar, 0);
//        bar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//        int horizontalMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                2, getResources().getDisplayMetrics());
//
//        int verticalMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                2, getResources().getDisplayMetrics());
//
//        int topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                (int) getResources().getDimension(R.dimen.activity_vertical_margin) + 30,
//                getResources().getDisplayMetrics());
//
//        getListView().setPadding(horizontalMargin, topMargin, horizontalMargin, verticalMargin);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
