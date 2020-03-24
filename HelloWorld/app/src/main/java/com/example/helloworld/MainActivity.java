package com.example.helloworld;

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

    //버튼 클릭시 실행할 메서드 정의
    //메서드의 매개변소에 실행할 버튼을 정의
    //버튼의 상위인 View타입으로 정의
    public void myclickMethod(View v){
        Toast.makeText(this,"확인버튼이 눌러졌씁니다.", Toast.LENGTH_LONG).show();
    }



}

