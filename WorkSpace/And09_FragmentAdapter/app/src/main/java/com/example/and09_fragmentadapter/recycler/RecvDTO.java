package com.example.and09_fragmentadapter.recycler;

public class RecvDTO {
    private int imgRes, age;
    private String gender, name, addr;

    public RecvDTO(int imgRes, int age, String gender, String name, String addr) {
        this.imgRes = imgRes;
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.addr = addr;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
