package com.example.ahorrovoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.ahorrovoltios.models.Energy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StadisticsActivity extends AppCompatActivity {

    ImageButton home;

    TableLayout table;

    TextView tvMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistics);
        home= findViewById(R.id.ibHomeLogin);
        table= findViewById(R.id.tableStadistics);
        tvMonth= findViewById(R.id.tvMonthStadistics);

        Intent homeView= new Intent(this, HomeActivity.class);

        //Cargar datos de los txt (Files)
        File energyFile= new File(getFilesDir(), "energy.txt");

        List<Energy> energyList= readFile(energyFile);
        addEnergyData(energyList);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeView);
            }
        });
    }

    public  static List<Energy> readFile(File file){
        List<Energy> energyList= new ArrayList<>();
        try (BufferedReader br= new BufferedReader(new FileReader(file))){
            String line;
            while ((line= br.readLine()) != null){
                String[] data= line.split(",");
                float kw= Float.parseFloat(data[0]);
                float price= Float.parseFloat(data[1]);
                String month= data[2];
                Energy energyObj= new Energy(kw,price,month);
                energyList.add(energyObj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return energyList;
    }

    public void addEnergyData(List<Energy> energyList){

        for (Energy i:energyList) {
            TableRow row= new TableRow(this);
            TextView cell1= new TextView(this);
            cell1.setText(i.getMonth());
            cell1.setWidth(80);
            cell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
         //   cell1.setPadding(10,10,10,10);
            cell1.setBackgroundResource(R.color.white);

            TextView cell2= new TextView(this);
            cell2.setText("Electricidad");
            cell2.setWidth(90);
            cell2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            //   cell2.setPadding(10,10,10,10);
            cell2.setBackgroundResource(R.color.white);

            TextView cell3= new TextView(this);
            cell3.setText(i.getKw()+"");
            cell3.setWidth(90);
            cell3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            //   cell3.setPadding(10,10,10,10);
            cell3.setBackgroundResource(R.color.white);

            TextView cell4= new TextView(this);
            cell4.setText(String.valueOf(i.getPrice()));
          //  cell4.setPadding(10,10,10,10);
            cell4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell4.setWidth(60);
            cell4.setBackgroundResource(R.color.white);

            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);

            table.addView(row);
        }

    }


}