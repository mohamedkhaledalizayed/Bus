package bus.itgds.khadametdz.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import java.util.ArrayList;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.ActivityNotificationBinding;
import bus.itgds.khadametdz.databinding.ActivitySearchBinding;
import bus.itgds.khadametdz.view.adapter.NotificationAdapter;
import bus.itgds.khadametdz.view.adapter.TicketAdapter;

public class NotificationActivity extends AppCompatActivity {

    private ActivityNotificationBinding binding;
    private NotificationAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notification);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.notifications));

        mAdapter = new NotificationAdapter(this,new ArrayList<String>());
        binding.notificationRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.notificationRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.notificationRecycler.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}