package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void okaybtn (View v){
        Toast.makeText(this, "확인버튼", Toast.LENGTH_SHORT ).show();

    }
    public void canbtn (View v){

    }
    public void backbtn (View v){

    }
}
