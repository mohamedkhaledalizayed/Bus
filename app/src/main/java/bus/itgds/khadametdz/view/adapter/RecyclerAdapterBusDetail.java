package bus.itgds.khadametdz.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.ArrayList;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.model.ModelBusDetail;
import bus.itgds.khadametdz.view.interfaces.ITicketHandler;
import bus.itgds.khadametdz.view.interfaces.PurchaseTicketListenerr;

public class RecyclerAdapterBusDetail extends RecyclerView.Adapter<RecyclerAdapterBusDetail.MyViewHolder> {
    private ArrayList<ModelBusDetail> arrayBusDetails;
    private PurchaseTicketListenerr purchaseTicketListener;
    private ITicketHandler handler;
    public RecyclerAdapterBusDetail(Context context,ArrayList<ModelBusDetail> arrayBusDetails, PurchaseTicketListenerr purchaseTicketListener) {
        this.arrayBusDetails = arrayBusDetails;
        this.purchaseTicketListener=purchaseTicketListener;
        handler = (ITicketHandler)context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_bus, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        ModelBusDetail modelBusDetail = arrayBusDetails.get(i);
        holder.busTextSource.setText(modelBusDetail.getBusSourceName());
        holder.busTextDestination.setText(modelBusDetail.getBusDestinationName());
        holder.busTextFrom.setText(modelBusDetail.getBusTimeFrom());
        holder.busTextTo.setText(modelBusDetail.getBusTimeTo());
        holder.busTextPrice.setText(modelBusDetail.getBusPrice());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.onClick("");
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayBusDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView busTextSource, busTextDestination, busTextFrom, busTextTo, busTextPrice;
        View view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            busTextSource = itemView.findViewById(R.id.id_bus_detail_source);
            busTextDestination = itemView.findViewById(R.id.id_bus_detail_destination);
            busTextFrom = itemView.findViewById(R.id.id_bus_detail_from);
            busTextTo = itemView.findViewById(R.id.id_bus_detail_to);
            busTextPrice = itemView.findViewById(R.id.id_bus_detail_price);
        }

    }
}