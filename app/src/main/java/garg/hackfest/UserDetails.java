package garg.hackfest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserDetails extends AppCompatActivity {

    private EditText userState;
    private EditText userName;
    private EditText userDistrict;
    private Button userButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        userButton = (Button)findViewById(R.id.UserSubmit);
        userName = (EditText)findViewById(R.id.UserName);
        userState=(EditText)findViewById(R.id.UserState);
        userDistrict = (EditText) findViewById(R.id.UserDistrict);

        final String UserNumber = getIntent().getStringExtra("mobile");
        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName = userName.getText().toString();
                String UserDistrict= userDistrict.getText().toString();
                String UserState= userState.getText().toString();

                if(UserName.isEmpty() || UserDistrict.isEmpty() || UserState.isEmpty()){
                    userName.setError("Enter all details");
                    userName.requestFocus();
                    return;
                }

                UserData userData = new UserData(UserNumber,UserName,UserState,UserDistrict);
                DatabaseReference userReference = FirebaseDatabase.getInstance().getReference().child("UserDetails");
                userReference.push().setValue(userData);

                //Calling VerifyPhone Activity for new registered users
                Intent intent = new Intent(UserDetails.this,VerifyPhone.class);
                intent.putExtra("mobile",UserNumber);
                startActivity(intent);

            }
        });


    }
}
