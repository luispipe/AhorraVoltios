package com.example.ahorrovoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.ahorrovoltios.models.Energy;
import com.example.ahorrovoltios.models.Water;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecommendationActivity extends AppCompatActivity {

    ImageButton home;
    TableLayout tableRecommendation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);
        home= findViewById(R.id.ibHomeLogin);
        Intent homeView= new Intent(this, HomeActivity.class);
        tableRecommendation= findViewById(R.id.TableRecommendation);

        File waterFile= new File(getFilesDir(),"water.txt");
        File energyFile= new File(getFilesDir(),"energy.txt");

        List<Water> waterList= new ArrayList<>();
        waterList= getWater(waterFile);

        List<Energy> energyList= new ArrayList<>();
        energyList=getEnergy(energyFile);

        inflateTable(energyList,waterList);



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeView);
            }
        });

    }

    public List<Energy> getEnergy(File energy){
        List<Energy> energyList= new ArrayList<>();

        try(BufferedReader br= new BufferedReader(new FileReader(energy))){
            String data;
            while ((data=br.readLine())!=null){
                String [] energyArray= data.split(",");
                float kw= Float.parseFloat(energyArray[0]);
                float price= Float.parseFloat(energyArray[1]);
                String month= energyArray[2];

                Energy obj= new Energy(kw,price,month);
                energyList.add(obj);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return energyList;
    }

    public List<Water> getWater(File water){
        List<Water> waterList= new ArrayList<>();

        try(BufferedReader br= new BufferedReader(new FileReader(water))){
            String data;
            while ((data=br.readLine())!=null){
                String [] waterArray= data.split(",");
                float volume= Float.parseFloat(waterArray[0]);
                float price= Float.parseFloat(waterArray[1]);
                String month= waterArray[2];

                Water obj= new Water(volume,price,month);
                waterList.add(obj);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return waterList;
    }

    public void inflateTable(List<Energy> energy, List<Water>water){
        //Promedio de consumo mensual
        //Promedio de consumo anual
        //Consejos de ahorro
        //Avisos de incremento en el precio en unidades de energía y agua

        float averageEnergy= averageEnergy(energy);
        float averageWater= averageWater(water);
        String monthEnergy= highestEnergyExpenditure(energy);
        String monthWater= highestWaterExpenditure(water);

        //Recomendación 1, el usuario tiene un consumo superior al promedio
        String recomendation1= "Aviso Energía";
        String description1= "El usuario tiene un consumo superior al promedio" +
                "que esta actualmente en "+averageEnergy+" KW";

        //Recomendación 2, el usuario tiene un consumo superior al promedio
        String recomendation2= "Aviso Água";
        String description2= "El usuario tiene un consumo superior al promedio" +
                "que esta actualmente en "+averageWater+" L";

        //Recomendación 3, és de mayor consumo
        String recomendation3= "Información Energía";
        String description3= "el més en el que se registro un mayor consumo de energía" +
                "fue en el més de "+monthEnergy;

        //Recomendación 4, és de mayor consumo
        String recomendation4= "Información Água";
        String description4= "el més en el que se registro un mayor consumo de água" +
                "fue en el més de "+monthWater;

        //Recomencadión general
        String recomendation5= "Opcional";
        String description5= "Para ahorra energía recuerde desconectar los " +
                "dispositivos una vez los utilice";

        //Recomencadión general
        String recomendation6= "Opcional";
        String description6= "Para ahorra água recuerde cerrar los grifos y reportar" +
                "de forma oportuna cualquier filtración de água";

        inflateRow(recomendation1,description1);
        inflateRow(recomendation2,description2);
        inflateRow(recomendation3,description3);
        inflateRow(recomendation4,description4);
        inflateRow(recomendation5,description5);
        inflateRow(recomendation6,description6);
    }

    public float averageWater(List<Water> water){
        float sum=0;
        for (Water i: water){
            sum+=i.getVolume();
        }
        return sum/water.size();
    }
    public float averageEnergy(List<Energy> energy){
        float sum=0;
        for (Energy i: energy){
            sum+=i.getKw();
        }
        return sum/energy.size();
    }
    public float averageErneryPrice(List<Energy> energy){
        float sum=0;
        for (Energy i: energy){
            sum+=i.getPrice();
        }
        return sum/energy.size();
    }

    public float averageWaterPrice(List<Water> water){
        float sum=0;
        for (Water i: water){
            sum+=i.getPrice();
        }
        return sum/water.size();
    }



    public String highestEnergyExpenditure(List<Energy> energy){
        String flat="";
        float value= 0;
        for (Energy i: energy){
            if(i.getKw()>value){
                value=i.getKw();
                flat=i.getMonth();
            }
        }
        return flat;
    }

    public String highestWaterExpenditure(List<Water> water){
        String flat="";
        float value= 0;
        for (Water i: water){
            if(i.getVolume()>value){
                value=i.getVolume();
                flat=i.getMonth();
            }
        }
        return flat;
    }

    public void inflateRow(String recommendation, String description){
        TableRow row= new TableRow(this);
        TextView cell= new TextView(this);
        cell.setText(recommendation);
        cell.setBackgroundResource(R.color.white);
        cell.setPadding(5,5,5,5);
        cell.setWidth(120);

        TextView cell2= new TextView(this);
        cell2.setText(description);
        cell2.setBackgroundResource(R.color.white);
        cell2.setPadding(5,5,5,5);
        cell2.setWidth(180);

        row.addView(cell);
        row.addView(cell2);

        tableRecommendation.addView(row);

    }
}