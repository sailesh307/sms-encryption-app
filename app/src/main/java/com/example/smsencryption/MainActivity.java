package com.example.smsencryption;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button enc;
    Button dec;
    ImageButton process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        enc=findViewById(R.id.encd);
        dec=findViewById(R.id.decd);
        process=findViewById(R.id.process);

        /* Encryption */
        enc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent temp= new Intent(MainActivity.this,Encoder.class);
                startActivity(temp);
            }
        });

        /* Decryption */
        dec.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent temp= new Intent(MainActivity.this,Decoder.class);
                startActivity(temp);
            }
        });

        /* process of encryption and decryption */
        process.setOnClickListener(new View.OnClickListener(){
             public void onClick(View view) {
                 Intent temp = new Intent(MainActivity.this, Process.class);
                 startActivity(temp);
             }
        });
    }
}