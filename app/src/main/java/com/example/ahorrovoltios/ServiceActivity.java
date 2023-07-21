package com.example.ahorrovoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ServiceActivity extends AppCompatActivity {

    Button water;
    Button energy;

    ImageButton home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        water= findViewById(R.id.btAgua);
        energy= findViewById(R.id.btEnergy);
        home= findViewById(R.id.ibHomeLogin);
        Intent homeView= new Intent(this, HomeActivity.class);
        Intent energyView= new Intent(this, EnergyServiceActivity.class);
        Intent waterView= new Intent(this, WaterServiceActivity.class);

        energy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(energyView);
            }
        });

        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(waterView);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeView);
            }
        });


    }
}