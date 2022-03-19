package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void encrypter(View view) {
        Intent encode = new Intent(this, Encode.class);
        startActivity(encode);
    }

    public void dycripter(View view) {
        Intent decode = new Intent(this, Decode.class);
        startActivity(decode);
    }
}