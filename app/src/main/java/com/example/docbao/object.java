package com.example.docbao;

public class object {
    public int id;
    public String title;
    public String link;
    public String hinhanh;

    public object(String title, String link, String hinhanh) {
        this.title = title;
        this.link = link;
        this.hinhanh = hinhanh;

    }

    public object(int id, String title, String link, String hinhanh) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.hinhanh = hinhanh;

    }
}
