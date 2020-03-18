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


public class AndroidActivity extends AppCompatActivity{
    public AndroidViewModel androidViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        observeViewModel();
        //observeModel(model);

        final Button button = findViewById(R.id.enterButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputText = findViewById(R.id.inputText);
                androidViewModel.setData(inputText.getText().toString());
            }
        });
    }


    /*private void observeModel(Model model) {
        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof Model) {
                    TextView outputView = findViewById(R.id.outputView);
                    outputView.setText(((Model) o).getData());
                }
            }
        });
    }*/

    private void observeViewModel() {
        androidViewModel = new ViewModelProvider(this).get(AndroidViewModel.class);
        androidx.lifecycle.Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextView outputView = findViewById(R.id.outputView);
                outputView.setText(s);
            }
        };

        androidViewModel.getPresentableData().observe(this, stringObserver);
    }






}
