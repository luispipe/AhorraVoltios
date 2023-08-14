package com.example.ahorrovoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    Button stadistics,category,recommendation,listUser;
    ImageView ivStadistics,ivCategory,ivRecommendation,ivListUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        stadistics= findViewById(R.id.btStadistics);
        category= findViewById(R.id.btCategory);
        recommendation= findViewById(R.id.btRecommendationHome);
        listUser=findViewById(R.id.btListUsers);
        ivStadistics= findViewById(R.id.ivStadisticsHome);
        ivCategory= findViewById(R.id.ivCategory);
        ivRecommendation= findViewById(R.id.ivRecommendationHome);
        ivListUser=findViewById(R.id.ivListUsers);
        Intent stadisticsView= new Intent(this, StadisticsActivity.class);
        Intent recommendationView= new Intent(this, RecommendationActivity.class);
        Intent categoryView= new Intent(this, ServiceActivity.class);
        Intent listUserView= new Intent(this, UsersListActivity.class);
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

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(categoryView);
            }
        });
        ivCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(categoryView);
            }
        });

        listUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(listUserView);
            }
        });
        ivListUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(listUserView);
            }
        });
    }
}