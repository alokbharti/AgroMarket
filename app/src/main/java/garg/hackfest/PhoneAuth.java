package garg.hackfest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PhoneAuth extends AppCompatActivity {

    private EditText mEditText;
    private String mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_auth);

        mEditText = (EditText)findViewById(R.id.editTextMobile);

        findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile = "+91"+mEditText.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){
                    mEditText.setError("Enter a valid mobile");
                    mEditText.requestFocus();
                    return;
                }
                //Log.e("PhoneAuth", mobile);
                DatabaseReference UserData = FirebaseDatabase.getInstance().getReference("UserDetails");
                UserData.orderByChild("userNumber").equalTo(mobile).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.getValue()!=null){
                                //User is already registered
                                //triggering VerifyPhone Activity
                                Intent intent = new Intent(PhoneAuth.this, VerifyPhone.class);
                                intent.putExtra("mobile", mobile);
                                startActivity(intent);
                            }
                            else{
                                //It's new User
                                //Triggering UserDetails
                                Intent intent = new Intent(PhoneAuth.this, UserDetails.class);
                                intent.putExtra("mobile", mobile);
                                startActivity(intent);
                            }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseApp.initializeApp(this);

        if (FirebaseAuth.getInstance().getCurrentUser()!=null){
            Intent intent = new Intent(PhoneAuth.this,MainActivity.class);
            intent.putExtra("mobile",mobile);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
