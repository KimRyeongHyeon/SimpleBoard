package com.myandroid.simpleboard;

public class SimpleBoard {
    String name;
    String content;
    String ts;

    public SimpleBoard(String name, String content, String ts) {
        this.name = name;
        this.content = content;
        this.ts = ts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}
