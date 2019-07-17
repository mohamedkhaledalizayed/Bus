package bus.itgds.khadametdz.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.TripItemBinding;
import bus.itgds.khadametdz.view.interfaces.ITicketHandler;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.MyViewHolder> {

    private List<String> recentList;
    private Context context;
    private LayoutInflater layoutInflater;
    private ITicketHandler handler;
    public TicketAdapter(Context context, List<String> recentList) {
        this.recentList = recentList;
        this.context = context;
        handler = (ITicketHandler) context;
    }

    @Override
    public TicketAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        TripItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.trip_item, parent, false);

        if (viewType == 111){
            binding.layout.setVisibility(View.VISIBLE);
        }

        return new TicketAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final TicketAdapter.MyViewHolder holder, final int position) {
        holder.binding.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.onClick("");
            }
        });

        if (position % 2 == 0){
            holder.binding.seats.setTextColor(Color.BLACK);
        } else if (position == 1 || position ==5 || position ==7 || position ==11){
            holder.binding.seats.setText("Fully Booked");
            holder.binding.seats.setTextColor(Color.RED);
        } else if (position % 5 == 0){
            holder.binding.seats.setText("Remain 2 Seat");
            holder.binding.seats.setTextColor(context.getResources().getColor(R.color.orange));
        }
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 1 || position ==5 || position ==7 || position ==11){
            return 111;
        }

        return super.getItemViewType(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TripItemBinding binding;

        public MyViewHolder(TripItemBinding view) {
            super(view.getRoot());
            this.binding = view;
        }
    }

}