package com.example.mvvmdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.model.Model;

import java.util.Observable;
import java.util.Observer;

public class androidActivity extends AppCompatActivity{
    private Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        observeModel(model);

        final EditText inputText = findViewById(R.id.inputText);
        final TextView outputView = findViewById(R.id.outputView);

        inputText.setText(model.getData());
        outputView.setText(model.getData());
    }


    private void observeModel(Model model) {
        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                TextView outputView = findViewById(R.id.outputView);
                outputView.setText(((Model) o).getData());
            }
        });
    }


    public void enterInput(View view) {
        EditText inputText = findViewById(R.id.inputText);
        model.setData(inputText.getText().toString());

    }

}
