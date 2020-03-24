package com.example.mvvmdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmdemo.R;

import java.util.Observable;


public class AndroidActivity extends AppCompatActivity{
    public AndroidPresenter androidPresenter = new AndroidPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        observeViewModel();

        final Button button = findViewById(R.id.enterButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputText = findViewById(R.id.inputText);
                androidPresenter.setData(inputText.getText().toString());
            }
        });
    }

    private void observeViewModel() {
        androidPresenter.addObserver(new java.util.Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof AndroidPresenter) {
                    TextView outputView = findViewById(R.id.outputView);
                    outputView.setText(((AndroidPresenter) o).getPresentableData());
                }
            }
        });
    }






}
