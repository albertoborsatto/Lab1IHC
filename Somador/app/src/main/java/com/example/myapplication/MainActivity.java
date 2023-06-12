package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sum = findViewById(R.id.btnSum);
        EditText val1 = findViewById(R.id.Valor1);
        EditText val2 = findViewById(R.id.Valor2);

        val1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                val1.setText("");
                return false;
            }
        });

        val2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                val2.setText("");
                return false;
            }
        });

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView result = findViewById(R.id.resultado);
                String val1String = val1.getText().toString();
                String val2String = val2.getText().toString();
                int val1Final = Integer.parseInt(val1String);
                int val2Final = Integer.parseInt(val2String);
                String resultFinal = Integer.toString(val1Final + val2Final);
                result.setText("Soma = " + resultFinal);
            }
        });
    }
}