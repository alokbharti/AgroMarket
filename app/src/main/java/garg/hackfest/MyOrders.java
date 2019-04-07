package garg.hackfest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyOrders extends AppCompatActivity {

    private RecyclerView mRecyclerVIew;
    private TextView OrdersTextview;
    private OrderAdapter mAdapter;
    private List<OrdersList> ordersLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        setTitle("My Orders");

        mRecyclerVIew = (RecyclerView)findViewById(R.id.OrdersRecyclerView);
        OrdersTextview = (TextView)findViewById(R.id.OrdersTextview);

        ordersLists = new ArrayList<>();
        mAdapter = new OrderAdapter(this,ordersLists);


        final String phoneNumber = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Buyer");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    ordersLists.clear();
                    Buyer buyer = dataSnapshot1.getValue(Buyer.class);
                    //Log.d("Inside MyOrders",dataSnapshot.toString());
                    if (buyer.getmBuyerPhoneNumber()!=null && buyer.getmBuyerPhoneNumber().equals(phoneNumber)){
                        OrdersList ordersList = new OrdersList(buyer.getmBuyerOrderName(),buyer.getmBuyerItemName(),buyer.getmBuyerWeight()
                                                                ,"₹"+buyer.getmBuyerCost(),buyer.getmBuyerDate(),buyer.getmBuyerAddress());
                        ordersLists.add(ordersList);
                    }


                }
                mAdapter.notifyDataSetChanged();

                if(ordersLists.size()==0){
                    OrdersTextview.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mRecyclerVIew.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerVIew.setAdapter(mAdapter);

    }
}
