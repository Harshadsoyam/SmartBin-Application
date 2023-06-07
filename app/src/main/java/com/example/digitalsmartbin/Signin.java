package com.example.digitalsmartbin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signin extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://smart-bin-15e98-default-rtdb.asia-southeast1.firebasedatabase.app");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        final EditText username = findViewById(R.id.username);

        final EditText password = findViewById(R.id.password);
        final Button loginBtn = findViewById(R.id.login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String UsernameTxt = username.getText().toString();
                final String PasswordTxt = password.getText().toString();

                if (UsernameTxt.isEmpty() || PasswordTxt.isEmpty()){
                    Toast.makeText(Signin.this, "Please fill your username or password", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if (snapshot.hasChild(UsernameTxt)){

                                final String getpassword = snapshot.child(UsernameTxt).child("password").getValue(String.class);

                                assert getpassword != null;
                                if (getpassword.equals(PasswordTxt)){
                                    //Toast.makeText(Signin.this, "Login successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Signin.this,Homepage.class));
                                    finish();
                                }
                                else {
                                    Toast.makeText(Signin.this, "Wrong password", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(Signin.this, "Wrong password", Toast.LENGTH_SHORT).show();
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