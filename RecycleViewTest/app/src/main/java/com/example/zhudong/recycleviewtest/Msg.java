package com.example.zhudong.recycleviewtest;

/**
 * Created by zhudong on 2017/6/10.
 */

public class Msg {

    public static final int TYPE_RECEIVED = 0;
    public static final int SENT = 1;
    private String text;
    private int type;

    public Msg(String text, int type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return this.text;
    }

    public int getType() {
        return this.type;
    }
}
