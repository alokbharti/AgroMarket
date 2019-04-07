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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Sell extends AppCompatActivity {

    private EditText mSellerAddress;
    private EditText mSellerCommodity;
    private EditText mSellerProductWeight;
    private EditText mSellerProductPrice;
    private Button mSubmit;
    private RadioButton mWeight;
    private RadioButton mUnits;
    private String UserPhoneNumber;
    String mSellerName;
    String mSellerDistrict;
    String mSellerState;
    String currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        setTitle("Sell Your Product");
        mSellerAddress = (EditText)findViewById(R.id.editTextAddress);
        mSellerCommodity = (EditText)findViewById(R.id.editTextCommodity);
        mSellerProductWeight = (EditText)findViewById(R.id.editTextWeight);
        mSubmit = (Button)findViewById(R.id.buttonSubmit);
        mWeight = (RadioButton)findViewById(R.id.productWeight);
        mUnits = (RadioButton)findViewById(R.id.productUnit);
        mSellerProductPrice = (EditText)findViewById(R.id.editTextPrice);
        UserPhoneNumber = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
        Log.d("MobileNUmber",UserPhoneNumber);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");

        currentTime = dateFormat.format(calendar.getTime());

        final DatabaseReference UserData = FirebaseDatabase.getInstance().getReference("UserDetails");
        UserData.orderByChild("userNumber").equalTo(UserPhoneNumber).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    UserData data = dataSnapshot1.getValue(UserData.class);

                    Log.d("UserData", data.toString());
                    mSellerName = data.getUserName();
                    mSellerDistrict = data.getUserDistrict();
                    mSellerState = data.getUserState();
                }
                Log.d("name,district,state",mSellerName+" "+mSellerDistrict+" "+mSellerState);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SellerAddress = mSellerAddress.getText().toString();
                String SellerCommodity = mSellerCommodity.getText().toString();
                String SellerProductWeight = mSellerProductWeight.getText().toString();
                String SellerProductPrice = mSellerProductPrice.getText().toString();
                boolean weight = mWeight.isChecked();
                boolean unit = mUnits.isChecked();

                if (SellerAddress.isEmpty() || SellerCommodity.isEmpty() || SellerProductWeight.isEmpty() ){
                    mSellerCommodity.setError("fill all the details");
                    mSellerCommodity.requestFocus();
                    return;
                }

                if (weight){
                    Seller seller = new Seller(mSellerName,SellerAddress,mSellerDistrict,mSellerState,SellerCommodity,SellerProductWeight
                            ,"KG",currentTime,"UNSOLD",SellerProductPrice,UserPhoneNumber);

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Seller");
                    databaseReference.push().setValue(seller);

                }
                else if(unit){
                    Seller seller = new Seller(mSellerName,SellerAddress,mSellerDistrict,mSellerState,SellerCommodity,SellerProductWeight
                            ,"Unit",currentTime,"unsold",SellerProductPrice,UserPhoneNumber);

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Seller");
                    databaseReference.push().setValue(seller);
                }
                Toast.makeText(Sell.this,"Data Submitted",Toast.LENGTH_SHORT).show();
                mSellerCommodity.setText("");
                mSellerAddress.setText("");
                mSellerCommodity.setText("");

                //Done: create a new Activity MyProduct and start a new intent to this activity
                startActivity(new Intent(Sell.this,MyProducts.class));
            }

        });
    }
}
