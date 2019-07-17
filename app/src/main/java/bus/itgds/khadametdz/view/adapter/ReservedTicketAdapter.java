package bus.itgds.khadametdz.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.ReservedTicketItemBinding;
import bus.itgds.khadametdz.view.interfaces.ITicketHandler;

public class ReservedTicketAdapter extends RecyclerView.Adapter<ReservedTicketAdapter.MyViewHolder> {

    private List<String> recentList;
    private Context context;
    private LayoutInflater layoutInflater;
    private ITicketHandler handler;
    public ReservedTicketAdapter(Context context, List<String> recentList) {
        this.recentList = recentList;
        this.context = context;
        handler = (ITicketHandler) context;
    }

    @Override
    public ReservedTicketAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ReservedTicketItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.reserved_ticket_item, parent, false);


        return new ReservedTicketAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ReservedTicketAdapter.MyViewHolder holder, final int position) {
        holder.binding.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.onClick(position+"");
            }
        });

        if (position % 2 == 0){
            holder.binding.status.setText("In Progress");
        } else if (position % 3 == 0){
            holder.binding.status.setText("Completed");
        } else if (position % 5 == 0){
            holder.binding.status.setText("Canceled");
        } else {
            holder.binding.status.setText("Not Started");
        }
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ReservedTicketItemBinding binding;

        public MyViewHolder(ReservedTicketItemBinding view) {
            super(view.getRoot());
            this.binding = view;
        }
    }
}
