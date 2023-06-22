package com.example.and09_fragmentadapter.recycler;

import android.content.Context;
import android.widget.Toast;

public class NormalClass {
    // 토스트창을 띄우는 기능을 메소드로 만들고싶다.
    // 어떻게?

    public void testToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
