package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    final String TAG = "메인";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent();
        String strValue = intent.getStringExtra("mainstr");
        Log.d(TAG, "onCreate: " + strValue);

        int intValue = intent.getIntExtra("mainnum", -1);
        Log.d(TAG, "onCreate: " + intValue);

//        KhmDTO dto = (KhmDTO) intent.getSerializableExtra("khmlist");
//        Log.d(TAG, "<DTO>" + " 문자 : " + dto.getStr() + " 숫자: " + dto.getNum());

        ArrayList<KhmDTO> dtoList = (ArrayList<KhmDTO>) intent.getSerializableExtra("khmdtolist");
        Log.d(TAG, "<ArrayList>" + " 문자 : " + dtoList.get(0).getStr() + " 숫자 : " + dtoList.get(0).getNum());

    }
}