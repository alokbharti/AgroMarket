package garg.hackfest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

class BuyAdapter extends RecyclerView.Adapter<BuyAdapter.ViewHolder> {

    private Context context;
    private List<Buy> list;

    public BuyAdapter(Context context, List<Buy> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.buy_product_list,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Buy item = list.get(position);
        holder.item.setText(item.getItemName());
        holder.price.setText("₹"+item.getPrice());
        holder.location.setText(item.getLocation());
        holder.quatity.setText(item.getQuatity() + " " + item.getUnit());
        holder.date.setText(item.getDate());;
        holder.key.setText(item.getKey());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView item;
        public TextView price;
        public TextView location;
        public TextView quatity;
        public TextView date;
        public TextView key;
        public CardView buyCard;

        public ViewHolder(final View itemView) {
            super(itemView);
            item = (TextView)itemView.findViewById(R.id.item);
            price = (TextView)itemView.findViewById(R.id.price);
            location=(TextView)itemView.findViewById(R.id.location);
            quatity = (TextView)itemView.findViewById(R.id.quatity);
            date = (TextView)itemView.findViewById(R.id.date);
            key = (TextView) itemView.findViewById(R.id.key);
            buyCard = (CardView) itemView.findViewById(R.id.buy_card);

            buyCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),CheckOut.class);
                    intent.putExtra("name",item.getText().toString());
                    intent.putExtra("weight",quatity.getText().toString());
                    intent.putExtra("price",price.getText().toString());
                    intent.putExtra("key",key.getText().toString());
                    v.getContext().startActivity(intent);
                }
            });


        }
    }
}
