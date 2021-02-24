package com.example.firsttimer.view;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import com.example.firsttimer.R;
import com.example.firsttimer.model.Model;

import java.util.Observable;


public class MainActivity extends AppCompatActivity{


    private AndroidLowerCaseViewModel lowerCaseViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        observeViewModel();

        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName2);
        editText.setText(lowerCaseViewModel.getPresentableData().getValue());
    }

    private void observeViewModel(){
        lowerCaseViewModel = new AndroidLowerCaseViewModel();

        final Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextView outputView = (TextView) findViewById(R.id.textView3);
                outputView.setText(s);
            }
        };

        lowerCaseViewModel.getPresentableData().observe(this, stringObserver);
    }


    public void setText(View view){

        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName2);

        String input = editText.getText().toString();

        lowerCaseViewModel.setData(input);
    }

}