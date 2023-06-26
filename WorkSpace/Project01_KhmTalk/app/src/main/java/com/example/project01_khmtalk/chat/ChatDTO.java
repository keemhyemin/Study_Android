package com.example.project01_khmtalk.chat;

public class ChatDTO {

    private int imgRes;
    private String chatName, chatMsg;

    public ChatDTO(int imgRes, String chatName, String chatMsg) {
        this.imgRes = imgRes;
        this.chatName = chatName;
        this.chatMsg = chatMsg;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getChatMsg() {
        return chatMsg;
    }

    public void setChatMsg(String chatMsg) {
        this.chatMsg = chatMsg;
    }
}
