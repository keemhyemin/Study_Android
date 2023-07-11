package com.example.project02_lastproject.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonConn {
    private final String TAG = "CommonConn" ;
    private HashMap<String, Object> paramMap;
    private Context context;
    private String mapping;
    private ProgressDialog dialog;
    private KhmCallBack callBack;

    public CommonConn(Context context, String mapping) {
        this.context = context;
        this.mapping = mapping;
        this.paramMap = new HashMap<>();
    }
    public void addParamMap(String key, Object value) {
        if(key == null) {
            Log.e(TAG, "파라메터 key값이 null이 들어와서 추가 안했음." );
        } else if (value == null) {
            Log.e(TAG, "파라메터 value값이 null이 들어와서 추가 안했음. <- 경우에 따라 커스텀" );
        }else {
            paramMap.put(key, value);
        }
    }

    private void onPreExcute() { // 실행 전
        if(context != null && dialog == null) {
            dialog = new ProgressDialog(context);
            dialog.setProgress(ProgressDialog.STYLE_SPINNER);
            dialog.setTitle("Common");
            dialog.setMessage("로딩 중입니다...");
            dialog.setCancelable(false);
            dialog.show();
        }
    }

    public void onExcute(KhmCallBack callBack) {
        onPreExcute();
        // 2. 옵저버 2
        this.callBack = callBack;
        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
        api.clientPostMethod(mapping, paramMap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "onExcute . onResponse: " + response.body());
                onPostExcute(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "onExcute . onFailure: " + t.getMessage());
                Toast.makeText(context, "서버 연결 실패, 개발자한테 문의하세요.", Toast.LENGTH_SHORT).show();
                onPostExcute(false, null);
            }
        });
    }
    
    private void onPostExcute(boolean isResult, String data) {
        if(dialog != null) {
            dialog.dismiss();
        }
        // 3. 옵저버 3
        callBack.onResult(isResult, data);
    }
    public interface KhmCallBack{
        public void onResult(boolean isResult, String data);
    }
}
