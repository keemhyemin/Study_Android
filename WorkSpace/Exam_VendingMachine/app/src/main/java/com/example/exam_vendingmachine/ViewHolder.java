package com.example.exam_vendingmachine;

import android.widget.Button;
import android.widget.TextView;

// 위젯들을 묶어서 관리하기 위한 위젯용 DTO
public class ViewHolder {
    private TextView tv_name, tv_cnt;
    private Button btn_order;

    // DrinkDTO <= 추후 필드로 놓을 수 있다.
    public ViewHolder(TextView tv_name, TextView tv_cnt, Button btn_order) {
        this.tv_name = tv_name;
        this.tv_cnt = tv_cnt;
        this.btn_order = btn_order;
    }

    public TextView getTv_name() {
        return tv_name;
    }

    public void setTv_name(TextView tv_name) {
        this.tv_name = tv_name;
    }

    public TextView getTv_cnt() {
        return tv_cnt;
    }

    public void setTv_cnt(TextView tv_cnt) {
        this.tv_cnt = tv_cnt;
    }

    public Button getBtn_order() {
        return btn_order;
    }

    public void setBtn_order(Button btn_order) {
        this.btn_order = btn_order;
    }


}
