package garg.hackfest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private List<ProductList> productLists;

    public ProductAdapter(Context context, List<ProductList> productLists) {
        this.context = context;
        this.productLists = productLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_my_products,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ProductList productList = productLists.get(position);

        holder.mProductName.setText(productList.getProductName());
        holder.mProductPrice.setText(productList.getProductPrice());
        holder.mProductStatus.setText(productList.getProductStatus());
        holder.mProductDate.setText(productList.getProductDate());
        holder.mProductWeight.setText(productList.getProductWeight());
    }

    @Override
    public int getItemCount() {
        return productLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mProductName;
        public TextView mProductPrice;
        public TextView mProductDate;
        public TextView mProductStatus;
        public TextView mProductWeight;


        public ViewHolder(View itemView) {
            super(itemView);

            mProductName = (TextView) itemView.findViewById(R.id.item);
            mProductPrice = (TextView)itemView.findViewById(R.id.price);
            mProductDate = (TextView)itemView.findViewById(R.id.date);
            mProductStatus = (TextView)itemView.findViewById(R.id.sold);
            mProductWeight=(TextView)itemView.findViewById(R.id.quatity);
        }
    }
}
