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

public class Decode extends AppCompatActivity {
    EditText enteredText;
    TextView displayPlain;
    ClipboardManager cplboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decode);
        enteredText = findViewById(R.id.decrypttext);
        displayPlain = findViewById(R.id.decrypted_msg);
        cplboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void decryption(View view) {
        String decryptmsg = enteredText.getText().toString();
        String cipherText = decryptmsg.toUpperCase();
        int key=7;
        String Alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String plain_Text="";
        for(int i=0;i<decryptmsg.length();i++){
            char character = cipherText.charAt(i);
            int charIndex = Alphabet.indexOf(character);
            int decryptedIndex = Math.floorMod((charIndex-key),Alphabet.length());
            plain_Text += Alphabet.charAt(decryptedIndex);
        }
        displayPlain.setText(plain_Text);

    }

    public void cp2(View view) {
        String data = displayPlain.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp = ClipData.newPlainText("text", data);
            cplboard.setPrimaryClip(temp);
            Toast.makeText(this, "msg copied", Toast.LENGTH_SHORT ).show();
        }
    }
}