package com.example.project02_lastproject.customer;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.project02_lastproject.R;
import com.example.project02_lastproject.common.CommonConn;

public class CustomerDialog extends Dialog {
    public CustomerDialog(@NonNull Context context, CustomerVO customerVO) {
        super(context);
        setContentView(R.layout.dialog_customer);
        EditText edt_name = findViewById(R.id.edt_name);
        EditText edt_email = findViewById(R.id.edt_email);
        EditText edt_phone = findViewById(R.id.edt_phone);
        Button btn_submit = findViewById(R.id.btn_submit);

        if(customerVO == null){
            btn_submit.setOnClickListener(v->{

                CommonConn conn = new CommonConn(context , "insert.cu");
                conn.addParamMap("name" , edt_name.getText().toString());
                conn.addParamMap("email" , edt_email.getText().toString());
                conn.addParamMap("phone" , edt_phone.getText().toString());
                conn.onExcute((isResult, data) -> {

                });
                //Insert처리를 해주면 됨.
                dismiss();//다이얼로그의 제일 중요한 속성 show()보이다 , dismiss()안보이다
            });
        }else{
            btn_submit.setText("수정하기");
            edt_name.setText(customerVO.getName());
            edt_phone.setText(customerVO.getPhone());
            edt_email.setText(customerVO.getEmail());
            btn_submit.setOnClickListener(v->{

                CommonConn conn = new CommonConn(context , "update.cu");
                conn.addParamMap("id" , customerVO.getId());
                conn.addParamMap("name" , edt_name.getText().toString());
                conn.addParamMap("email" , edt_email.getText().toString());
                conn.addParamMap("phone" , edt_phone.getText().toString());
                conn.onExcute((isResult, data) -> {

                });
                //Insert처리를 해주면 됨.
                dismiss();//다이얼로그의 제일 중요한 속성 show()보이다 , dismiss()안보이다
            });
        }


    }
}
