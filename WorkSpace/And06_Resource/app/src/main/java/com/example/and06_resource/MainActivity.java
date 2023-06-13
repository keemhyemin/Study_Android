package com.example.and06_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Values/String 값 : ", R.string.khm_version + ""); // id (메모리 번지수)
        Log.d("Values/String 값 : ", getString(R.string.khm_version)); // 실제 값 출력

    }
}