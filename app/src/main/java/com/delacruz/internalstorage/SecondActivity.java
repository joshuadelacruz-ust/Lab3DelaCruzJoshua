package com.delacruz.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    CheckBox c, c2, c3, c4, c5, c6, c7, c8;

    FileInputStream reader = null;
    String content = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        try {
            reader = openFileInput("data1.txt");

            int token;

            while((token = reader.read()) != -1){
                content = content + (char)token;
            }

        } catch (FileNotFoundException e) {
            Log.d("Error", "File Not Found...");
        } catch (IOException e){
            Log.d("Error", "Input/Output Error");
        }

        String[] subjects = content.split("/");

        c = findViewById(R.id.checkBox);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        c4 = findViewById(R.id.checkBox4);
        c5 = findViewById(R.id.checkBox5);
        c6 = findViewById(R.id.checkBox6);
        c7 = findViewById(R.id.checkBox7);
        c8 = findViewById(R.id.checkBox8);

        c.setText(subjects[0]);
        c2.setText(subjects[1]);
        c3.setText(subjects[2]);
        c4.setText(subjects[3]);
        c5.setText(subjects[4]);
        c6.setText(subjects[5]);
        c7.setText(subjects[6]);
        c8.setText(subjects[7]);

    }

    public void showData(View v){
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }
}
