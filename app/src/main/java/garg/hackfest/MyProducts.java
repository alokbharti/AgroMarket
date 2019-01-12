package garg.hackfest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyProducts extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;
    private List<ProductList> productListList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_products);

        productListList = new ArrayList<>();
        mAdapter = new ProductAdapter(this,productListList);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Seller");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                productListList.clear();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    Seller sellerList = dataSnapshot1.getValue(Seller.class);
                    ProductList productList = new ProductList(sellerList.getmSellerCommodity(),"₹"+sellerList.getPrice(),sellerList.getDate()
                            ,sellerList.getStatus(),
                            sellerList.getmSellerWeight()+" "+ sellerList.getSIUnit());
                    productListList.add(productList);
                }
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mRecyclerView = (RecyclerView)findViewById(R.id.product_RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

    }
}
