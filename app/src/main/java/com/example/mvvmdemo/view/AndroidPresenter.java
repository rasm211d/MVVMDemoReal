package com.example.mvvmdemo.view;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmdemo.model.Model;
import androidx.lifecycle.ViewModel;

import java.util.Observable;
import java.util.Observer;

public class AndroidPresenter extends Observable {
    private String presentableData;
    private Model model = new Model();

    public AndroidPresenter() {
        observeModel(model);
        presentableData = model.getData();
    }

    private void observeModel(final Model model) {
        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                presentableData = ((Model) o).getData();
                setChanged();
                notifyObservers();

            }
        });
    }


    public String getPresentableData() {
        return presentableData;
    }

    public void setData(String data) {
        model.setData(data);
    }
}
