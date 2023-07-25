package com.example.ahorrovoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ahorrovoltios.models.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText username;
    EditText phone;
    EditText password;

    EditText passwordTwo;

    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.etNameRegister);
        email=findViewById(R.id.etEmailRegister);
        username=findViewById(R.id.etUsernameRegister);
        phone= findViewById(R.id.etPhoneRegister);
        password=findViewById(R.id.etPasswordRegister);
        passwordTwo=findViewById(R.id.etPasswordTwoRegister);
        register= findViewById(R.id.btRegister);

        Intent login= new Intent(this,LoginActivity.class);
        register.setOnClickListener(new View.OnClickListener() {
            //validar que los campos estan completos
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty() &&
                !email.getText().toString().isEmpty() &&
                !username.getText().toString().isEmpty() &&
                !phone.getText().toString().isEmpty() &&
                !password.getText().toString().isEmpty()
                ){
                if (password.getText().toString().equals(passwordTwo.getText().toString())){

                    if (checkUser(email.getText().toString(),
                            username.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Este usuario ya esta registrado",Toast.LENGTH_LONG);

                    }else{
                        User user= new User(name.getText().toString(),
                                email.getText().toString(),
                                username.getText().toString(),
                                phone.getText().toString(),
                                password.getText().toString());
                        saveUser(user);
                        startActivity(login);
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"Las contraseñas no coinciden",Toast.LENGTH_LONG);
                }
                }else{
                    Toast.makeText(getApplicationContext(),"Todos los campos deben estar diligenciados",Toast.LENGTH_LONG);
                }



            }
        });
    }

    public void saveUser(User user){

                File file= new File(getFilesDir(),"userData.txt");
                try {
                    FileWriter writer= new FileWriter(file,true);
                    BufferedWriter bufferedWriter= new BufferedWriter(writer);
                    bufferedWriter.write(user.getName()+","+user.getEmail()+","+
                            user.getUsername()+","+user.getPhone()+","+user.getPassword());
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
        }


    public boolean checkUser(String email, String username){
        File file= new File(getFilesDir(),"userData.txt");
        try {
            FileReader reader= new FileReader(file);
            BufferedReader bufferedReader= new BufferedReader(reader);
            String line;
            List<String> emailList= new ArrayList<>();
            List<String> usernameList= new ArrayList<>();

            while ((line=bufferedReader.readLine())!=null){
                String [] data= line.split(",");
                emailList.add(data[1]);
                usernameList.add(data[2]);
            }
            bufferedReader.close();

            return emailList.contains(email) ||
                    usernameList.contains(username);

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

}