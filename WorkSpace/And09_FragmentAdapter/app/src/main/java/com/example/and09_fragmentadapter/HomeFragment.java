package com.example.and09_fragmentadapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


// Fragment에서 제일 중요한 메소드 : onCreateView 메소드
// Fragment를 만들고나서는 불필요한 코드가 많이 있음. 중요한 메소드 빼고 전부 지운다.
public class HomeFragment extends Fragment {
    EditText edt_text;
    Button btn_text;
    TextView tv_result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        edt_text = v.findViewById(R.id.edt_text);
        btn_text = v.findViewById(R.id.btn_text);
        tv_result = v.findViewById(R.id.tv_result);

        btn_text.setOnClickListener(v1 -> {
            tv_result.setText(edt_text.getText().toString());
        });

        return v;
    }

}