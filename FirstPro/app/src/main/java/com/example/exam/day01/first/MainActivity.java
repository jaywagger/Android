package com.example.exam.day01.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

//Activity의 LifeCycle

public class MainActivity extends AppCompatActivity {
    //아래는 Activity가 생성될 떄 자동으로 호출. 첫 번쨰 호출
    //최초 한 번만 호출된다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //System.out.println("onCreate 호출~!");
        Log.d("test", "onCreate()호출됌");
        setContentView(R.layout.activity_main);
    }
    //onCreate 다음으로 호출
    //단 pause에서 시작될 때는 start가 호출됌
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test", "onStart()호출됌");
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("test", "onPostResume()호출됌");
    }
    //잠시 멈출 때 호출
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test", "onPause()호출됌");
    }
    //일시정지나 종료 상태로 바뀔 때 on Pause 다음으로 호출된다.
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test", "onStop()호출됌");
    }
    //앱이 종료될 떄 호출되는 메서드
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test", "onDestroy()호출됌");
    }


    public void confirm (View v){
        Toast.makeText(this, "확인 버튼이 눌러졌습니다.",
                Toast.LENGTH_LONG).show();
    }

    public void cancel (View v){
        Toast.makeText(this, "취소 버튼",
                Toast.LENGTH_SHORT).show();
    }

    public void delete (View v){
        Toast.makeText(this, "삭제 버튼",
                Toast.LENGTH_SHORT).show();
    }



}
