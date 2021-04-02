package com.example.smsencryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Decoder extends AppCompatActivity {

    EditText etdec;
    TextView dectv;
    ClipboardManager cplboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoder);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        etdec=findViewById(R.id.etdec);
        dectv=findViewById(R.id.dectv);
        cplboard=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public void dec(View view){
        String temp=etdec.getText().toString();
        String rv=Decode.dec(temp);
        dectv.setText(rv);
    }

    public void cpl(View view){
        String data=dectv.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp=ClipData.newPlainText("text",data);
            cplboard.setPrimaryClip(temp);
            Toast.makeText(this,"Copied", Toast.LENGTH_SHORT).show();
        }
    }
}