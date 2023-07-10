package com.example.exam00_java;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class CalcDAO {
    // 클래스의 멤버는 크게 2가지가 있다.
    // 인스턴스멤버, 스태틱 멤버
    int num1, num2; // 인스턴스
    private int num3; // 인스턴스
    public int num4; // 인스턴스
    static int num5; // 스태틱
    private static int num6; // 스태틱
    public static int num7; // 스태틱

    public int getSum(int num1, int num2) {
        return num1 + num2;
    }

    public static int getSum() {
        return 0;
    }

    public class ChildClass {
        int fieldChild;
    }
    public static class StaticChildClass {
        int fieldChild;
    }

    // 지역변수 ( 메소드 내부에서 선언되어 사용되는 변수)
    public int method() {
        // 외부에서 절대로 접근이 불가능하다.(외부에서 쓰고싶으면 리턴)
        int num1 = 0; // 지역변수
        CalcDAO dao = new CalcDAO(); // 지역변수
        return num1;
    }


//    public void getSum(int x, int y, TextView tv1) {
//        Log.d("두 수의 합(텍스트 뷰)", "getSum: " + (x + y));
//        tv1.setText(x+y+"");
//
//    }
//    public void getSum(int x, int y, Button btn1) {
//        Log.d("두 수의 합(버튼)", "getSum: " + (x + y));
//        btn1.setText(x+y+"");
//
//    }
}
