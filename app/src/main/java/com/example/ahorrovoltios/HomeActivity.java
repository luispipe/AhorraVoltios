package com.example.ahorrovoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    Button stadistics,category,recommendation;
    ImageView ivStadistics,ivCategory,ivRecommendation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        stadistics= findViewById(R.id.btStadistics);
        category= findViewById(R.id.btCategory);
        recommendation= findViewById(R.id.btRecommendationHome);
        ivStadistics= findViewById(R.id.ivStadisticsHome);
        ivCategory= findViewById(R.id.ivCategory);
        ivRecommendation= findViewById(R.id.ivRecommendationHome);

        Intent stadisticsView= new Intent(this, StadisticsActivity.class);
        Intent recommendationView= new Intent(this, RecommendationActivity.class);

        stadistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(stadisticsView);
            }
        });
        ivStadistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(stadisticsView);
            }
        });

        recommendation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(recommendationView);
            }
        });
        ivRecommendation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(recommendationView);
            }
        });

    }
}