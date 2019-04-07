package garg.hackfest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class CheckOut extends AppCompatActivity {

    private EditText BuyerAddress;
    private RadioButton cod;
    private RadioButton net;
    private TextView productName;
    private Button buyerSubmitButton;
    private TextView orderNumber;
    private TextView Price;
    private TextView total;
    private String buyerName;
    private String buyerPhoneNumber;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        setTitle("Bill");
        final String name = getIntent().getStringExtra("name");
        final String weight = getIntent().getStringExtra("weight");
        String BuyerPrice = getIntent().getStringExtra("price");
        final String price = BuyerPrice.substring(1,BuyerPrice.length());
        final String key = getIntent().getStringExtra("key");


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");

        date = dateFormat.format(calendar.getTime());

        productName = (TextView)findViewById(R.id.buyerProductName);
        productName.setText(name+" - "+weight);

        orderNumber = (TextView)findViewById(R.id.order);
        orderNumber.setText("Order Id: "+key);

        Price = (TextView)findViewById(R.id.buyerPrice);
        Price.setText("Item Price: INR"+price);

        total = (TextView)findViewById(R.id.totalPrice);
        final String cost=String.valueOf(Integer.parseInt(price)+50);
        total.setText("Total Cost: INR"+cost);


        buyerPhoneNumber = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
        final DatabaseReference UserData = FirebaseDatabase.getInstance().getReference("UserDetails");
        UserData.orderByChild("userNumber").equalTo(buyerPhoneNumber).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    UserData data = dataSnapshot1.getValue(UserData.class);

                    Log.d("UserData", data.toString());
                    buyerName = data.getUserName();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        buyerSubmitButton = (Button)findViewById(R.id.buyerButton);
        buyerSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuyerAddress = (EditText)findViewById(R.id.buyerAddress);

                String Address = BuyerAddress.getText().toString();
                if (Address.isEmpty()){
                    BuyerAddress.setError("Fill this address");
                    BuyerAddress.requestFocus();
                    return;
                }
                cod=(RadioButton)findViewById(R.id.cod);
                net = (RadioButton)findViewById(R.id.netBanking);

                if(cod.isChecked()) {
                    Buyer buyer = new Buyer(buyerName, buyerPhoneNumber, name, weight, cost, key, "COD",Address,date);
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Buyer");
                    databaseReference.push().setValue(buyer);
                }
                else if(net.isChecked()){
                    Buyer buyer = new Buyer(buyerName, buyerPhoneNumber, name, weight, cost, key, "ONLINE",Address,date);
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Buyer");
                    databaseReference.push().setValue(buyer);
                }

                DatabaseReference d = FirebaseDatabase.getInstance().getReference().child("Seller");
                d.child(key).child("status").setValue("SOLD");

                Toast.makeText(CheckOut.this,"Thank you for your Orders!!!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CheckOut.this,MainActivity.class));

            }


        });


    }
}
