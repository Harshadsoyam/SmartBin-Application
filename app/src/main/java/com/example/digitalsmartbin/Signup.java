
package com.example.digitalsmartbin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
//import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signup extends AppCompatActivity {

    //creating object for firebase
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://smart-bin-15e98-default-rtdb.asia-southeast1.firebasedatabase.app");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText regUsername = findViewById(R.id.usernameInput);
        final EditText regEmail = findViewById(R.id.email);
        final EditText regPassword = findViewById(R.id.PasswordInput1);
        final EditText regConfirmPassword = findViewById(R.id.PasswordInput2);
        final Button registration = findViewById(R.id.registerBtn);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get data
                final String UsernameTxt = regUsername.getText().toString();
                final String EmailTxt = regEmail.getText().toString();
                final String PasswordTxt = regPassword.getText().toString();
                final String ConfirmPasswordTxt = regConfirmPassword.getText().toString();

                //check if any blank
                if (UsernameTxt.isEmpty() || EmailTxt.isEmpty() || PasswordTxt.isEmpty() || ConfirmPasswordTxt.isEmpty()){
                    Toast.makeText(Signup.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else if(!PasswordTxt.equals(ConfirmPasswordTxt)){
                    Toast.makeText(Signup.this, "Password does not matching", Toast.LENGTH_SHORT).show();
                }
                else {

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if (snapshot.hasChild(UsernameTxt)) {
                                Toast.makeText(Signup.this, "Username already exist", Toast.LENGTH_SHORT).show();
                            } else {
                                //sending data to firebase
                                databaseReference.child("users").child(UsernameTxt).child("email").setValue(EmailTxt);
                                databaseReference.child("users").child(UsernameTxt).child("password").setValue(PasswordTxt);

                                Toast.makeText(Signup.this, "Successfully register.", Toast.LENGTH_SHORT).show();
                                Intent int1= new Intent(Signup.this,Signin.class);
                                startActivity(int1);
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
}