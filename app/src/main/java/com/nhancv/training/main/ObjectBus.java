package com.nhancv.training.main;

/**
 * Created by nhancao on 5/30/17.
 */

public class ObjectBus {
    private int panel;
    private String msg;

    public ObjectBus(int panel, String msg) {
        this.panel = panel;
        this.msg = msg;
    }

    public int getPanel() {
        return panel;
    }

    public String getMsg() {
        return msg;
    }
}
