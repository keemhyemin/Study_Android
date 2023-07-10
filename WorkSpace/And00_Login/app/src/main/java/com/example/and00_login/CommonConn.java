package com.example.and00_login;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonConn {
    // Retrofit을 매번 새로 인스턴스화 해서 사용하는 것은 매우 귀찮음.
    // 재사용이 가능한 구조를 하나 만들고 재사용하면 편함
    private final String TAG = "CommonConn" ;
    private HashMap<String, Object> paramMap; // 파라메터 전송용
    private Context context; // 화면 위에 토스트, ProgressDialog를 보여주기 위한 용도
    private String mapping; // list.cu, login, member 등의 맵핑을 받아오기 위한 것
    private ProgressDialog dialog; // 모양 다양하게 커스텀 가능 -> 나중에 바꾸면 됨
    private KhmCallBack callBack;

    public CommonConn(Context context, String mapping) {
        this.context = context;
        this.mapping = mapping;
        this.paramMap = new HashMap<>();
        Log.d("콜백", "콜백(인터페이스의 메모리): " + callBack);
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
    // enqueue ( 전송 실행 전 해야할 코드를 넣어줄 메소드 구현, (ProgressDialog 보이게 처리))
    private void onPreExcute() { // 실행 전
        if(context != null && dialog == null) {
            dialog = new ProgressDialog(context);
            dialog.setProgress(ProgressDialog.STYLE_SPINNER); // 빙글빙글 돌아가는거
            dialog.setTitle("Common");
            dialog.setMessage("로딩 중입니다...");
            dialog.setCancelable(false); // 로딩 중 사용자가 조작 못하게
            dialog.show();
        }
    }
    // enqueue가 실제로 되어야 하는 부분(파라메터 등을 통해서 실제로 Spring에 전송한다.)
    public void onExcute(KhmCallBack callBack) {
        onPreExcute();
        // 2. 옵저버 2
        Log.d("콜백", "콜백(인터페이스의 메모리): " + this.callBack);
        this.callBack = callBack;
        Log.d("콜백", "콜백(인터페이스의 메모리): " + this.callBack + "받아온 것 =>: " + callBack);
        RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
        // GET 방식인지 POST 방식인지를 받아와서 처리도 가능하다. ( 현재는 어려우니까 POST로 고정시켜놓기 )
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
    // 옵저버 패턴 : 감시하다가 어떤 작업이 끝나면 특정 메소드를 실행함. : View.OnClickListener
    // 1.
    public interface KhmCallBack{
        public void onResult(boolean isResult, String data);
    }
}
