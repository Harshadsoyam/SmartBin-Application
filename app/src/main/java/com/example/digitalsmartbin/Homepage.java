package com.example.digitalsmartbin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {

    ImageButton bin;
    ImageButton noty;
    ImageButton map;
    ImageButton fb;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        bin = findViewById(R.id.binlevel);

        bin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Toast.makeText(Homepage.this,"Bin Level is shown!",Toast.LENGTH_SHORT).show();
                Intent int1= new Intent(Homepage.this,binlevels.class);
                startActivity(int1);
            }
        });

        noty = findViewById(R.id.notificationp);

        noty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Homepage.this, "Notification page!", Toast.LENGTH_SHORT).show();
                Intent int2 = new Intent(Homepage.this, Notification.class);
                startActivity(int2);
            }
        });


        map = findViewById(R.id.mapp);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Homepage.this, "Location is shown!", Toast.LENGTH_SHORT).show();
                Intent int3 = new Intent(Homepage.this, MapsActivity.class);
                startActivity(int3);
            }
        });



        fb = findViewById(R.id.feedbackp);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Homepage.this, "Feedback Pgae!", Toast.LENGTH_SHORT).show();
                Intent int4 = new Intent(Homepage.this, Feedback.class);
                startActivity(int4);
            }
        });

        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Homepage.this, "You are logout!", Toast.LENGTH_SHORT).show();
                Intent int5 = new Intent(Homepage.this, MainActivity.class);
                startActivity(int5);
            }
        });
    }
}