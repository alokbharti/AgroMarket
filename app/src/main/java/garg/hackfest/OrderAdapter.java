package garg.hackfest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private Context context;
    private List<OrdersList> ordersLists;

    public OrderAdapter(Context context, List<OrdersList> ordersLists) {
        this.context = context;
        this.ordersLists = ordersLists;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_my_orders,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        OrdersList list = ordersLists.get(position);
        holder.name.setText(list.getOrderName());
        holder.price.setText(list.getOrderPrice());
        holder.weight.setText(list.getOrderWeight());
        holder.address.setText(list.getOrderAddress());
        holder.date.setText(list.getOrderDate());
        holder.number.setText(list.getOrderID());
    }

    @Override
    public int getItemCount() {
        return ordersLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView price;
        public TextView weight;
        public TextView number;
        public TextView date;
        public TextView address;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.textView);
            price = (TextView)itemView.findViewById(R.id.textView6);
            weight = (TextView)itemView.findViewById(R.id.textView9);
            number = (TextView)itemView.findViewById(R.id.textView12);
            date  = (TextView)itemView.findViewById(R.id.textView8);
            address = (TextView)itemView.findViewById(R.id.textView7);
        }
    }
}
