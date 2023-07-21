package com.example.ahorrovoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.File;

public class StadisticsActivity extends AppCompatActivity {

    ImageButton home;

    TableLayout table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistics);
        home= findViewById(R.id.ibHomeLogin);
        table= findViewById(R.id.tableStadistics);

        Intent homeView= new Intent(this, HomeActivity.class);

        //Cargar datos de los txt (Files)
        File energyFile= new File(getFilesDir(), "energy.txt");




        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeView);
            }
        });
    }

    public void addEnergyData(String kw,String price, String month){
        TableRow row= new TableRow(this);
        TextView cell1= new TextView(this);
        cell1.setText(kw);
        cell1.setBackgroundResource(R.color.white);

        TextView cell2= new TextView(this);
        cell2.setText("Electricidad");
        cell2.setBackgroundResource(R.color.white);

        TextView cell3= new TextView(this);
        cell3.setText(price);
        cell3.setBackgroundResource(R.color.white);

        TextView cell4= new TextView(this);
        cell4.setText(month);
        cell4.setBackgroundResource(R.color.white);

        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);

        table.addView(row);

    }


}