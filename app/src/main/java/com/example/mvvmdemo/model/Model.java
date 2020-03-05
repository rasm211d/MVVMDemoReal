package com.example.mvvmdemo.model;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
