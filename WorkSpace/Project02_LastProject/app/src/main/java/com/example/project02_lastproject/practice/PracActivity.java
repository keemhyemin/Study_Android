package com.example.project02_lastproject.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.RetrofitClient;
import com.example.project02_lastproject.common.RetrofitInterface;
import com.example.project02_lastproject.databinding.ActivityPracBinding;

import java.util.HashMap;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PracActivity extends AppCompatActivity {
    ActivityPracBinding binding;
    // CallbackKhm callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPracBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        callback = new CallbackKhm() {
//            @Override
//            public void onResult(String data) {
//                binding.tvResult.setText("응답 : " + data);
//            }
//        };

        binding.btnSelect.setOnClickListener(v -> {
            // RetrofitClient : 접속 방법, 컨버터 등 통신에 대한 전반적인 방법이 있는 객체
            // RetrofitInterface : 접속 후 데이터 전송 방식, 파라메터 타입 등등의 기능에 가까운 객체
            commonExcute(binding.edtUrl.getText().toString(), new HashMap<>(), new CallbackKhm() {
                @Override
                public void onResult(String data) {
                    binding.tvResult.setText("SELECT 결과 후 처리: " + data);
                }
            });
//            api.clientPostMethod(binding.edtUrl.getText().toString(), new HashMap<>()).enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
//                    callback.onResult(response.body());
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//                    callback.onResult(t.getMessage());
//                }
//            });
        });

        binding.btnInsert.setOnClickListener(v -> {
            HashMap<String, Object> params = new HashMap<>();
            params.put("col1", "random값" + new Random().nextInt(100));
            params.put("col2", "random값" + new Random().nextInt(100));

            commonExcute("retrofit/insert", params, data -> {
                binding.tvResult.setText("INSERT 결과 1은 성공 : " + data);
            });
//            api.clientPostMethod("retrofit/insert", params).enqueue(new Callback<String>() {
//                @Override
//                public void onResponse(Call<String> call, Response<String> response) {
//                    callback.onResult(response.body());
//                }
//
//                @Override
//                public void onFailure(Call<String> call, Throwable t) {
//                    callback.onResult(t.getMessage());
//                }
//            });
        });

        binding.btnUpdate.setOnClickListener(v -> {

        });
    }

    public void commonExcute(String url, HashMap<String, Object> map, CallbackKhm callback) { // 2
        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
        api.clientPostMethod(url, map).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.onResult(t.getMessage());
            }
        });
    }


    public interface CallbackKhm { // 1
        public void onResult(String data);
    }
}