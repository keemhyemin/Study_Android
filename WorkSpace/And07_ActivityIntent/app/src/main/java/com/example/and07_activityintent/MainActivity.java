package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    final String TAG = "수명주기";
    // 현재는 onCreate 내부에서만 코드처리를 해도 무방함.
    // 추후에 여러 화면이나 Spring 연동 시 새로고침 등의 처리가 필요할 때는 수명주기가 있다는 것을 생각하고, 적절한 수명주기를 이용하자.

    // 안드로이드도 Spring과 마찬가지로 Debugging을 잘하면 오류찾는게 빠르다. (디버깅 모드를 한번씩 연습해보는 습관을 들이면 좋음)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}