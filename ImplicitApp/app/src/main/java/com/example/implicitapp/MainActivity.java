package com.example.implicitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText message_body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message_body = findViewById(R.id.message);
    }

    public void jump(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String message = message_body.getText().toString();
        i.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(i);

    }
}