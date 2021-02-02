package com.example.firsttimer.view;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.firsttimer.R;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setText(View view){
        TextView textView = (TextView) findViewById(R.id.textView3);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName2);
        textView.setText(editText.getEditableText());
    }

}