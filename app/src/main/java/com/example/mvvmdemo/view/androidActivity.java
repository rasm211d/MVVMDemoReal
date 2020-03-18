package com.example.mvvmdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.model.Model;

import java.util.Observable;
import java.util.Observer;

public class androidActivity extends AppCompatActivity{
    private Model model = new Model();
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        observeModel(model);

        final Button button = findViewById(R.id.enterButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputText = findViewById(R.id.inputText);
                model.setData(inputText.getText().toString());
            }
            });
    }


    private void observeModel(Model model) {
        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof Model) {
                    TextView outputView = findViewById(R.id.outputView);
                    outputView.setText(((Model) o).getData());
                }
            }
        });
    }



}
