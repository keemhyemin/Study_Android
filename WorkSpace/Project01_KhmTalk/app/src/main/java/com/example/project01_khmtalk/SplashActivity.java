package com.example.project01_khmtalk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.project01_khmtalk.databinding.ActivitySplashBinding;
import com.example.project01_khmtalk.databinding.KhmActBinding;

public class SplashActivity extends AppCompatActivity {
// ViewBinding 처리해보기

    ActivitySplashBinding binding; // 레이아웃이 바인딩 되는 것, 액티비티랑은 상관 ㄴㄴ
    // KhmActBinding binding; <= 디자인 파일이 Binding 객체가 생기는 것 혼동 x

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // 디자인 파일 최상단에 있는 레이아웃을 의미한다.

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // ProgressDialog : 로딩중에 사용자가 어떤 동작을 하고있는지를 인지를 못한 경우에는 프로그램 오류나, 버그를 의심하고 기다림을 멈춘다. => 조작
        // 조작 x => 앱 종료 (로딩중이라는 것을 나타내기 위한 위젯을 사용해보기)
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Khm Talk");
        dialog.setMessage("로딩 중 대기 바랍니다...");
        dialog.setCancelable(false);
        dialog.show();

        // Splash Screen : 데이터 로딩이나 앱 실행 시, 유저에게 로고를 노출함으로써 각인효과를 주고, 기다리는 시간을 조금 더 짧게 느끼게 한다.

        // Thread : Handler
        // 안드로이드의 앱은 메인 프로세스가 진행되면서 모든 처리가 일어남

        new Handler().postDelayed(() -> {
            dialog.dismiss(); // 안보이게 처리
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 100 * 5);
    }
}