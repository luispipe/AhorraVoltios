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

public class EnergyServiceActivity extends AppCompatActivity {

    ImageButton home;
    EditText kw,price,month;
    Button registerEnergy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy_service);
        home= findViewById(R.id.ibHomeLogin);
        kw= findViewById(R.id.etKW);
        price= findViewById(R.id.etEnergyPrice);
        month= findViewById(R.id.etMonthEnergy);
        registerEnergy= findViewById(R.id.btEnergyRegister);


        Intent homeView= new Intent(this, HomeActivity.class);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeView);
            }
        });

        registerEnergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Verificamos que no esten vacios los campos
                if(!kw.getText().toString().isEmpty() &&
                   !price.getText().toString().isEmpty() &&
                   !month.getText().toString().isEmpty() ){
                    //Almacenar en txt
                    File file= new File(getFilesDir(),"energy.txt");
                    try {
                        FileWriter writer= new FileWriter(file,true);
                        BufferedWriter bufferedWriter= new BufferedWriter(writer);
                        String factura= kw.getText().toString()+","+
                                        price.getText().toString()+","+
                                        month.getText().toString();
                        bufferedWriter.write(factura);
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    kw.setText("");
                    price.setText("");
                    month.setText("");

                }  else {
                    Toast.makeText(EnergyServiceActivity.this,"Todos los campos deben estar diligenciado",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}