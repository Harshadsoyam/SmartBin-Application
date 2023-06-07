package com.example.digitalsmartbin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg = findViewById(R.id.SignUP);
        login = findViewById(R.id.SignIN);


        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Toast.makeText( MainActivity.this,"Clicked on Sign in",Toast.LENGTH_SHORT).show();
                Intent int1= new Intent(MainActivity.this,Signin.class);
                startActivity(int1);
            }
        });


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"Clicked on Sign up",Toast.LENGTH_SHORT).show();
                Intent int2= new Intent(MainActivity.this,Signup.class);
                startActivity(int2);
            }
        });
    }
}