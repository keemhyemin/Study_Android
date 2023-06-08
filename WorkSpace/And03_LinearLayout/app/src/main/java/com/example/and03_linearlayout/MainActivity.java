package com.example.and03_linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear4);
        LinearLayout line1 = findViewById(R.id.line1);
        Log.i("김혜민", "로그 Info");
        Log.w("김혜민", "경고", null);
        if(line1 != null) {
            // System.out.println(); Android에서는 syso 사용 x
            // log. <- 사용. 단축키 : logd
            Log.d("김혜민", "Linear가 null이 아님");
        } else {
            // Log.d("김혜민", "onCreate: Linear가 null임");
            Log.e("김혜민", "onCreate: Linear가 null임 오류로 로그찍기", null);
        }
    }
}