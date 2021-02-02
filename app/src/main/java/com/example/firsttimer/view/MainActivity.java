package com.example.firsttimer.view;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.firsttimer.R;
import com.example.firsttimer.model.Model;

import java.util.Observable;
import java.util.Observer;


public class MainActivity extends AppCompatActivity{

        private Model model = new Model();



   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        observeModel(model);

        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(model.getData());

        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName2);
        editText.setText(model.getData());

    }

    private void observeModel(Model model){
       model.addObserver(new Observer(){

           @Override
           public void update(Observable o, Object arg) {
               if (o instanceof Model){
                   String data = ((Model) o).getData();
                   TextView textView = (TextView) findViewById(R.id.textView3);
                   textView.setText(data);
               }
           }
       });
    }


    public void setText(View view){

        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName2);

        model.setData(editText.getEditableText().toString());
    }

}