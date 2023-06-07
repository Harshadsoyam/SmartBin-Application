package com.example.digitalsmartbin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class binlevels extends AppCompatActivity {

    TextView a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binlevels);

        a = findViewById(R.id.text2);
        b = findViewById(R.id.text3);
        c = findViewById(R.id.text4);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("sensors");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String val1 = Objects.requireNonNull(snapshot.child("Bin fill").getValue()).toString();
                a.setText(val1);
                String val2 = Objects.requireNonNull(snapshot.child("Remaining").getValue()).toString();
                b.setText(val2);
                String val3 = Objects.requireNonNull(snapshot.child("gasValue in ppm").getValue()).toString();
                c.setText(val3);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}