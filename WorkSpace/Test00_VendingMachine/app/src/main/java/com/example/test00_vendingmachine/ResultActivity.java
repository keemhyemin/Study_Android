package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tv_change, tv_drinklist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_change = findViewById(R.id.tv_change);
        tv_drinklist = findViewById(R.id.tv_drinklist);

        Intent intent = getIntent();

        int change = intent.getIntExtra("change", -1);
        tv_change.setText("잔액 : " + change + "원");
        int colaCnt = intent.getIntExtra("buycola", -1);
        int ciderCnt = intent.getIntExtra("buycider", -1);
        int fantaCnt = intent.getIntExtra("buyfanta", -1);
        int sodaCnt = intent.getIntExtra("buysoda", -1);
        tv_drinklist.setText("콜라: " + colaCnt + "개\n" +
                             "사이다: " + ciderCnt + "개\n" +
                             "환타: " + fantaCnt + "개\n" +
                             "데미소다: " + sodaCnt + "개");
    }
}