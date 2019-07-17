package bus.itgds.khadametdz.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.SeatItemBinding;
import bus.itgds.khadametdz.view.activity.Seat;

public class SeatsAdapter extends RecyclerView.Adapter<SeatsAdapter.MyViewHolder> {

    private List<Seat> seatList;
    private Context context;
    private LayoutInflater layoutInflater;

    public SeatsAdapter(Context context, List<Seat> seatList) {
        this.seatList = seatList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
//        if (position == 2 || position == 7 || position == 12 || position == 17 || position == 22 || position == 27 || position == 32 || position == 37 || position == 42 || position == 49){
//            return 112;
//        }
        return super.getItemViewType(position);
    }

    @Override
    public SeatsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        SeatItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.seat_item, parent, false);
        if (viewType == 112){
            binding.seatNumber.setText("");
            binding.seatNumber.setBackgroundColor(Color.WHITE);
        }

        return new SeatsAdapter.MyViewHolder(binding);
    }

    int index=0;
    @Override
    public void onBindViewHolder(final SeatsAdapter.MyViewHolder holder, final int position) {

        if (position == 2 || position == 7 || position == 12 || position == 17 || position == 22 || position == 27 || position == 32 || position == 37 || position == 42 || position == 47){
            holder.binding.seatNumber.setText("");
            holder.binding.seatNumber.setBackgroundColor(Color.WHITE);
            index++;
        }else {
            holder.binding.seatNumber.setText(seatList.get(position-index).getSeatNumber()+"");
            if (seatList.get(position).isBooked()) {
                holder.binding.seatNumber.setBackgroundResource(R.drawable.seat_bg_booked);
                holder.binding.seatNumber.setTextColor(Color.WHITE);
            }

            holder.binding.seatNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (seatList.get(position).isBooked()) {
                        Toast.makeText(context, "This Ticket Booked", Toast.LENGTH_LONG).show();
                    } else if (seatList.get(position).isSelected()) {
                        seatList.get(position).setSelected(false);
                        holder.binding.seatNumber.setBackgroundResource(R.drawable.seat_bg);
                        holder.binding.seatNumber.setTextColor(Color.BLACK);
                    } else {
                        seatList.get(position).setSelected(true);
                        holder.binding.seatNumber.setBackgroundResource(R.drawable.seat_bg_selected);
                        holder.binding.seatNumber.setTextColor(Color.WHITE);
                    }
                }
            });
        }





    }

    @Override
    public int getItemCount() {
        return 55;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SeatItemBinding binding;

        public MyViewHolder(SeatItemBinding view) {
            super(view.getRoot());
            this.binding = view;
        }
    }

}
