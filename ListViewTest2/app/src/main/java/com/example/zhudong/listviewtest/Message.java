package com.example.zhudong.listviewtest;

/**
 * Created by zhudong on 2017/6/10.
 */

public class Message {
    public static final int TYPE_RECEIVED = 1;
    public static final int TYPE_SENT = 0;

    private String content;
    private int type;

    public Message(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return this.type;
    }

    public String getContent() {
        return this.content;
    }
}
