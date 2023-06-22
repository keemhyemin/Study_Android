package com.example.and09_fragmentadapter.practice;

public class MelvDTO {

    private int imgRes, num;
    private String song, singer;

    public MelvDTO(int imgRes, int num, String song, String singer) {
        this.imgRes = imgRes;
        this.num = num;
        this.song = song;
        this.singer = singer;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
