package com.example.ahorrovoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.ahorrovoltios.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersListActivity extends AppCompatActivity {

    TableLayout tableUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        tableUsers=findViewById(R.id.tableListU);

        //Cargar archivo de usuarios
        File userFile= new File(getFilesDir(),"userData.txt");

        //Lista usuario
        try {
            List<User> listUser= readFile(userFile);
            inflateTable(listUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> readFile(File users) throws IOException {
        List<User> list= new ArrayList<>();

        BufferedReader bufferedReader= new BufferedReader( new FileReader(users));
        String user;
        while ((user=bufferedReader.readLine())!=null){
            // Luis, luis@gmail.com, lrojas, 8787878
            String [] dataUser= user.split(",");
            // ["Luis","luis@gmail.com", "lrojas", "8787878"]
            String name= dataUser[0];
            String email= dataUser[1];
            String username= dataUser[2];
            String phone= dataUser[3];

            User createUser= new User(name,email,username,phone);
            list.add(createUser);
        }
        return list;

    }

    public void inflateTable(List<User>userList){
        for (User i:userList){
            TableRow row= new TableRow(this);

            TextView cell1= new TextView(this);
            cell1.setText(i.getName());
            cell1.setPadding(10,10,10,10);
            cell1.setBackgroundResource(R.color.white);
            cell1.setWidth(80);

            TextView cell2= new TextView(this);
            cell2.setText(i.getEmail());
            cell2.setPadding(10,10,10,10);
            cell2.setBackgroundResource(R.color.white);
            cell2.setWidth(90);

            TextView cell3= new TextView(this);
            cell3.setText(i.getUsername());
            cell3.setPadding(10,10,10,10);
            cell3.setBackgroundResource(R.color.white);
            cell3.setWidth(90);

            TextView cell4= new TextView(this);
            cell4.setText(i.getPhone());
            cell4.setPadding(10,10,10,10);
            cell4.setBackgroundResource(R.color.white);
            cell4.setWidth(60);

            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);

            tableUsers.addView(row);
        }
    }
}