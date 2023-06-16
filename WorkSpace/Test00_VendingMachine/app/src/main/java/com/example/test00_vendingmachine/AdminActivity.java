package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {

    TextView tv_cola, tv_cider, tv_fanta, tv_soda;
    int colaCnt, ciderCnt, fantaCnt, sodaCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        tv_cola = findViewById(R.id.tv_cola);
        tv_cider = findViewById(R.id.tv_cider);
        tv_fanta = findViewById(R.id.tv_fanta);
        tv_soda = findViewById(R.id.tv_soda);

        Intent intent = getIntent();
        tv_cola.setText("현재 수량: " + intent.getIntExtra("colacnt", -1) +"개");
        tv_cider.setText("현재 수량: " + intent.getIntExtra("cidercnt", -1) +"개");
        tv_fanta.setText("현재 수량: " + intent.getIntExtra("fantacnt", -1) +"개");
        tv_soda.setText("현재 수량: " + intent.getIntExtra("sodacnt", -1) +"개");


    }
}