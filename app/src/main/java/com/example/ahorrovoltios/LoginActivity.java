package com.example.ahorrovoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahorrovoltios.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextView register;

    EditText userLogin, passwordLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userLogin= findViewById(R.id.etUserLogin);
        passwordLogin=findViewById(R.id.etPasswordLogin);

        login= findViewById(R.id.btLogin);
        register= findViewById(R.id.tvRegister);
        Intent home= new Intent(this,HomeActivity.class);
        Intent registerView= new Intent(this,RegisterActivity.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!userLogin.getText().toString().isEmpty() &&
                !passwordLogin.getText().toString().isEmpty()){
                    Log.i("EditText",userLogin.getText().toString()+"-"+
                            passwordLogin.getText().toString());
                    if(checkUser(userLogin.getText().toString(),
                            passwordLogin.getText().toString())){
                        startActivity(home);
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "Los datos son incorrectos",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),
                            "Los campos deben estar completos",Toast.LENGTH_LONG).show();

                }




            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registerView);
            }
        });


    }

    public boolean checkUser(String user, String pass){
        //user --> email, username, phone
        File file = new File(getFilesDir(),"userData.txt");
        try {
            BufferedReader reader= new BufferedReader(new FileReader(file));
            String line;
            while ((line=reader.readLine())!=null){
                String[] userData= line.split(",");
                String email= userData[1];
                String username= userData[2];
                String phone= userData[3];
                String password= userData[4];

                Log.i("Parametros entrada", user+"-"+pass);
                Log.i("File", email+"-"+username+"-"+phone+
                        "-"+password);

                if((email.equals(user)||username.equals(user)||
                    phone.equals(user))&& password.equals(pass)){
                    Log.i("Check", "True");
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}