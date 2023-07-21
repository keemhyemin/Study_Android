package com.example.lastcloneappproject.event;

public class NewsDTO {
    private String date, title, more;

    public NewsDTO(String date, String title, String more) {
        this.date = date;
        this.title = title;
        this.more = more;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }
}
