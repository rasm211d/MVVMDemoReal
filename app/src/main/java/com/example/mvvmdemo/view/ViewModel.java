package com.example.mvvmdemo.view;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmdemo.model.Model;

import java.util.Observable;
import java.util.Observer;

public class ViewModel {
    private MutableLiveData<String> presentableData = new MutableLiveData<>();
    private Model model = new Model();

    public ViewModel() {
        observeModel(model);
        presentableData.setValue(model.getData());
    }

    private void observeModel(Model model) {
        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                presentableData.setValue(((Model) o).getData());
            }
        });
    }


    public MutableLiveData<String> getPresentableData() {
        return presentableData;
    }

    public void setData(String data) {
        model.setData(data);
    }
}
