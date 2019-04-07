package garg.hackfest;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BuyProduct extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Buy> mBuyList;
    private BuyAdapter mBuyAdapter;
    private DatabaseReference productReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);

        mRecyclerView = (RecyclerView) findViewById(R.id.recylerView);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mBuyList = new ArrayList<Buy>();
        mBuyAdapter = new BuyAdapter(this, mBuyList);
        mRecyclerView.setAdapter(mBuyAdapter);


        getProductList();
        mBuyAdapter.notifyDataSetChanged();

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)(findViewById(R.id.swipe_refresh_layout));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mBuyList.clear();
                getProductList();
                mBuyAdapter.notifyDataSetChanged();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },4000);
            }
        });

    }

    private void getProductList(){
        productReference = FirebaseDatabase.getInstance().getReference().child("Seller");
        productReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Seller s = dataSnapshot1.getValue(Seller.class);
                    Log.e("buyer", s.toString());
                    String key = dataSnapshot1.getKey();

                    if (s.getStatus().equals("UNSOLD")) {
                        mBuyList.add(new Buy(s.getmSellerCommodity(), s.getDate(), s.getmSellerDistrict() + ", " + s.getmSellerState(), s.getPrice(), s.getmSellerWeight(), s.getSIUnit(), key));
                    }
                    Log.e("buyer", String.valueOf(mBuyList.size()));
                }

                mBuyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
