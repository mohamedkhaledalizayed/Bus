package bus.itgds.khadametdz.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.ActivityBusSeatsBinding;
import bus.itgds.khadametdz.utils.AppUtils;
import bus.itgds.khadametdz.view.adapter.SeatsAdapter;

public class BusSeatsActivity extends AppCompatActivity {

    private ActivityBusSeatsBinding binding;
    private SeatsAdapter mAdapter;
    private ArrayList<Seat> seatArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_bus_seats);

        seatArrayList = new ArrayList<>();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.seats));

        mAdapter = new SeatsAdapter(this,seatArrayList);
        binding.seatsRecycler.setLayoutManager(new GridLayoutManager(this,5));
        binding.seatsRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.seatsRecycler.setAdapter(mAdapter);
        fakeData();
    }

    private void fakeData(){
        Seat seat =new Seat(1,false,false);
        seatArrayList.add(seat);
        seat =new Seat(2,false,true);
        seatArrayList.add(seat);
        seat =new Seat(3,false,true);
        seatArrayList.add(seat);
        seat =new Seat(4,false,false);
        seatArrayList.add(seat);
        seat =new Seat(5,false,false);
        seatArrayList.add(seat);
        seat =new Seat(6,false,false);
        seatArrayList.add(seat);
        seat =new Seat(7,false,true);
        seatArrayList.add(seat);
        seat =new Seat(8,false,false);
        seatArrayList.add(seat);
        seat =new Seat(9,false,false);
        seatArrayList.add(seat);
        seat =new Seat(10,false,false);
        seatArrayList.add(seat);
        seat =new Seat(11,false,false);
        seatArrayList.add(seat);
        seat =new Seat(12,false,false);
        seatArrayList.add(seat);
        seat =new Seat(13,false,true);
        seatArrayList.add(seat);
        seat =new Seat(14,false,false);
        seatArrayList.add(seat);
        seat =new Seat(15,false,false);
        seatArrayList.add(seat);
        seat =new Seat(16,false,false);
        seatArrayList.add(seat);
        seat =new Seat(17,false,false);
        seatArrayList.add(seat);
        seat =new Seat(18,false,false);
        seatArrayList.add(seat);
        seat =new Seat(19,false,false);
        seatArrayList.add(seat);
        seat =new Seat(20,false,false);
        seatArrayList.add(seat);
        seat =new Seat(21,false,true);
        seatArrayList.add(seat);
        seat =new Seat(22,false,false);
        seatArrayList.add(seat);
        seat =new Seat(23,false,false);
        seatArrayList.add(seat);
        seat =new Seat(24,false,true);
        seatArrayList.add(seat);
        seat =new Seat(25,false,false);
        seatArrayList.add(seat);
        seat =new Seat(26,false,true);
        seatArrayList.add(seat);
        seat =new Seat(27,false,true);
        seatArrayList.add(seat);
        seat =new Seat(28,false,true);
        seatArrayList.add(seat);
        seat =new Seat(29,false,false);
        seatArrayList.add(seat);
        seat =new Seat(30,false,true);
        seatArrayList.add(seat);
        seat =new Seat(31,false,true);
        seatArrayList.add(seat);
        seat =new Seat(32,false,false);
        seatArrayList.add(seat);
        seat =new Seat(33,false,true);
        seatArrayList.add(seat);
        seat =new Seat(34,false,false);
        seatArrayList.add(seat);
        seat =new Seat(35,false,true);
        seatArrayList.add(seat);
        seat =new Seat(36,false,false);
        seatArrayList.add(seat);
        seat =new Seat(37,false,false);
        seatArrayList.add(seat);
        seat =new Seat(38,false,true);
        seatArrayList.add(seat);
        seat =new Seat(39,false,true);
        seatArrayList.add(seat);
        seat =new Seat(40,false,true);
        seatArrayList.add(seat);
        seat =new Seat(41,false,true);
        seatArrayList.add(seat);
        seat =new Seat(42,false,true);
        seatArrayList.add(seat);
        seat =new Seat(43,false,true);
        seatArrayList.add(seat);
        seat =new Seat(44,false,false);
        seatArrayList.add(seat);
        seat =new Seat(45,false,false);
        seatArrayList.add(seat);
        seat =new Seat(46,false,true);
        seatArrayList.add(seat);
        seat =new Seat(47,false,true);
        seatArrayList.add(seat);
        seat =new Seat(48,false,true);
        seatArrayList.add(seat);
        seat =new Seat(49,false,false);
        seatArrayList.add(seat);
        seat =new Seat(50,false,true);
        seatArrayList.add(seat);
        seat =new Seat(51,false,false);
        seatArrayList.add(seat);
        seat =new Seat(52,false,true);
        seatArrayList.add(seat);
        seat =new Seat(53,false,true);
        seatArrayList.add(seat);
        seat =new Seat(54,false,false);
        seatArrayList.add(seat);
        seat =new Seat(55,false,true);
        seatArrayList.add(seat);

        mAdapter.notifyDataSetChanged();
    }

    public void book(View view) {
        AppUtils.dialog(this,"Confirmation","Are you sure you want to reserve this Ticket");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ticket_detail_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }else if (item.getItemId() == R.id.details){
            startActivity(new Intent(this,ReservationActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

