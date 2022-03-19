package com.example.cryptography;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Encode extends AppCompatActivity {

    EditText EnteredText;
    TextView displayCipher;
    ClipboardManager cplboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encode);
        EnteredText = findViewById(R.id.encrypttext);
        displayCipher = findViewById(R.id.textView4);
        cplboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void encryption(View view) {
        String encryptmsg = EnteredText.getText().toString();
        String plainText = encryptmsg.toUpperCase();
        int key=7;
        String Alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cipherText="";
        for(int i=0;i<plainText.length();i++){
            char character = plainText.charAt(i);
            int charIndex = Alphabet.indexOf(character);
            int encryptedIndex = Math.floorMod((charIndex+key),Alphabet.length());
            cipherText += Alphabet.charAt(encryptedIndex);

        }
        displayCipher.setText(cipherText);
    }

    public void cp1(View view) {
        String data = displayCipher.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp = ClipData.newPlainText("text", data);
            cplboard.setPrimaryClip(temp);
            Toast.makeText(this, "msg copied", Toast.LENGTH_SHORT ).show();
        }
    }
}