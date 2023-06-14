package com.example.and07_activityintent;

import java.io.Serializable;

public class KhmDTO implements Serializable {
    private String str;
    private int num;

    public KhmDTO(String str, int num) {
        this.str = str;
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
