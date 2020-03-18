package com.example.mvvmdemo.model;

import java.util.Observable;

public class Model extends Observable {
    private String data = "123";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        setChangedAndNotifyObserversSimpl();
    }

    private void setChangedAndNotifyObserversSimpl() {
        setChanged();
        notifyObservers();

    }

}
