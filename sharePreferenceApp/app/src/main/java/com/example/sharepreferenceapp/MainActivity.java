package com.example.sharepreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editText1);
        password = findViewById(R.id.editText2);
        number = findViewById(R.id.editText3);
    }

    public void login(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Mydetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Username_key",username.getText().toString());
        editor.putString("Pass_key",password.getText().toString());
        editor.putString("Number_key",number.getText().toString());
        editor.commit();

        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Saved Data!!", Toast.LENGTH_SHORT).show();
    }
}