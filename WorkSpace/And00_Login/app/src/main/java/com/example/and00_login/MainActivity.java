package com.example.and00_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.and00_login.databinding.ActivityMainBinding;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommonConn.KhmCallBack callBack = new CommonConn.KhmCallBack() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("결과", "onResult: " + data);
            }
        }; // <= @메모리번지수를 참조하는 인터페이스를 초기화 함. (내부에는 메소드가 반드시 있음)
        Log.d("콜백", "콜백(인터페이스의 메모리): " + callBack);

        binding.btnLogin.setOnClickListener(v -> { // 사용자가 EditText에 입력을 마치고 로그인 버튼을 누름 => 전송
            CommonConn conn = new CommonConn(this, "member/login");
            conn.addParamMap("id", binding.edtId.getText().toString());
            conn.addParamMap("pw", binding.edtPw.getText().toString());
            conn.onExcute(callBack); // onExcute 메소드가 실행되면 일단 Spring으로 전송처리는 정상적으로 작동한다. (결과를 가져오려면 어떻게 해야할까?)
        });

        TestVO vo = new TestVO(); // 메모리 번지수에 TestVO를 올림 @20407
        vo.str = "111"; // @20407 내부의 str변수를 "111"로 값을 할당함.
        testMethod(vo); // <= @20407
        Log.d("aaa", "onCreate: " + vo.str); // <= @20407는 "222"

        callBack.onResult(true, "값을 넘김"); // 외부에서 이 코드를 쓸 수 있게 해줌
    }
    public class TestVO {
        String str;
    }

    public void testMethod(TestVO vo) {
        vo.str="222"; // <= @20407 내부의 str 변수를 "222"로 값 재할당
    }


    // 올바른 방법 아니라서 한번 확인하고 지울것
//    public static void test(String data) {
//        Log.d("결과 : ", "onCreate: ↑ "  + data);
//    }


}