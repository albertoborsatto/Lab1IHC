package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText msg = findViewById(R.id.msg);
        Button enviar = findViewById(R.id.envia);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String mensagem = msg.getText().toString();
               Intent intent = new Intent(MainActivity.this, MainActivity2.class);
               intent.putExtra("impressao", mensagem);
               startActivity(intent);
            }
        });

        msg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                msg.setText("");
                return false;
            }
        });
    }
}