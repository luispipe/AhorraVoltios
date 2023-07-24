package com.example.ahorrovoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WaterServiceActivity extends AppCompatActivity {
    ImageButton home;
    EditText volume,price,month;
    Button registerWater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_service);
        home= findViewById(R.id.ibHomeLogin);
        volume= findViewById(R.id.etVolume);
        price= findViewById(R.id.etWaterPrice);
        month= findViewById(R.id.etMonthWater);
        registerWater= findViewById(R.id.btWaterRegister);


        Intent homeView= new Intent(this, HomeActivity.class);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeView);
            }
        });

        registerWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Verificamos que no esten vacios los campos
                if(!volume.getText().toString().isEmpty() &&
                        !price.getText().toString().isEmpty() &&
                        !month.getText().toString().isEmpty() ){
                    //Almacenar en txt
                    File file= new File(getFilesDir(),"water.txt");
                    try {
                        FileWriter writer= new FileWriter(file,true);
                        BufferedWriter bufferedWriter= new BufferedWriter(writer);
                        String factura= volume.getText().toString()+","+
                                price.getText().toString()+","+
                                month.getText().toString();
                        bufferedWriter.write(factura);
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    volume.setText("");
                    price.setText("");
                    month.setText("");

                }  else {
                    Toast.makeText(WaterServiceActivity.this,"Todos los campos deben estar diligenciado",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}