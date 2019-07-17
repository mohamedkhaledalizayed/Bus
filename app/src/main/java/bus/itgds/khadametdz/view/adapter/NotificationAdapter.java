package bus.itgds.khadametdz.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.NotificationItemBinding;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private List<String> recentList;
    private Context context;
    private LayoutInflater layoutInflater;
    public NotificationAdapter(Context context, List<String> recentList) {
        this.recentList = recentList;
        this.context = context;
    }

    @Override
    public NotificationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        NotificationItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.notification_item, parent, false);


        return new NotificationAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final NotificationAdapter.MyViewHolder holder, final int position) {
        holder.binding.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        NotificationItemBinding binding;

        public MyViewHolder(NotificationItemBinding view) {
            super(view.getRoot());
            this.binding = view;
        }
    }

}