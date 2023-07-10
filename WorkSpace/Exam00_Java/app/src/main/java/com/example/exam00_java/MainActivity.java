package com.example.exam00_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button btn1, btn_start, btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);

        CalcDAO dao = new CalcDAO();

        dao.num1 = 1;
        dao.num2 = 2;
        // dao.num3 = 3; private으로 외부에서 접근을 막음
        dao.num4 = 4;
        CalcDAO.num5 = 5; // static이라 메모리에 먼저 올라감(인스턴스화 x)
        // CalcDAO.num6 = 6; private으로 외부에서 접근을 막음
        CalcDAO.num7 = 7;

        CalcDAO.getSum();

        // dao.getSum(1,2, tv1);
        // dao.getSum(1,2, btn1);
        tv1.setText(dao.getSum(1, 2)+"");
        btn1.setText(dao.getSum(1, 2)+"");

        CalcDAO.ChildClass cc = dao.new ChildClass();
        cc.fieldChild = 1;

        CalcDAO.StaticChildClass scc = new CalcDAO.StaticChildClass();
        scc.fieldChild = 1;

        KhmCallback callback = new KhmCallback() {
            @Override
            public void onResponse(String data) {
                Log.d("성공", "onResponse: ");
            }

            @Override
            public void onFailure(String data) {
                Log.d("실패", "onFailure: ");
            }
        };

        callback.onResponse("성공");
        callback.onFailure("실패");

    }

    // 메소드는 구현이 자유롭다
    // 실행은 사용하는 곳에서 호출을 해줘야지만 된다.

   public interface KhmCallback {
        public void onResponse(String data); // 추상클래스는 항상 메소드의 형태만 있다.
        public void onFailure(String data);
    }

}