package com.example.digitalsmartbin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Notification extends AppCompatActivity {

    TextView a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        a = findViewById(R.id.t1);
        b = findViewById(R.id.t2);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("sensors");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                int val1 = Integer.parseInt(Objects.requireNonNull(snapshot.child("Bin fill").getValue()).toString());
                if (val1 > 75 && val1 <= 95 ){
                    a.setText("25% is remaining ");
                }else if(val1 >95){
                    a.setText("Dustbin is full ! please check another ");
                }else{
                    a.setText("Dustbin is Empty! ");
                }

                int val2 = Integer.parseInt(Objects.requireNonNull(snapshot.child("Remaining").getValue()).toString());
                if (val2 > 1000 ){
                    b.setText("Harmful gases is evolve!! /n Please don't go close to Dustbin ");
                }else{
                    b.setText("No harmful gases, you can go");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}