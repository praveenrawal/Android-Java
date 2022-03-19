package com.example.sharepreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView user_view, pass_view, number_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_view = findViewById(R.id.text1);
        pass_view = findViewById(R.id.text2);
        number_view = findViewById(R.id.text3);
    }

    public void show(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Mydetails", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("Username_key", "");
        String pass = sharedPreferences.getString("Pass_key","");
        String number = sharedPreferences.getString("Number_key", "");

        user_view.setText(name);
        pass_view.setText(pass);
        number_view.setText(number);

        Toast.makeText(this, "Loaded successfully", Toast.LENGTH_SHORT).show();
    }
}