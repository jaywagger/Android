package com.example.exercise.childView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.exercise.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ChildFirstPage extends AppCompatActivity {
    //바텀바
    Toolbar toolbar;
    CollapsingToolbarLayout toolbarLayout;
    FloatingActionButton fab;
    ListView listView;
    ArrayList<String> datalist = new ArrayList<String>();
    BottomAppBar bottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_first_page);

        ListView listView = findViewById(R.id.listContent);

        //1. 리스트에 출력할 데이터
        //각각 하나의 아이템
        ProfileItem profileItem;
        //여러 아이템을 모을 리스트
        ArrayList<ProfileItem> profilelist = new ArrayList<ProfileItem>();
        //각각 하나의 아이템에 데이터 넣기
        profileItem= new ProfileItem(R.drawable.a8,"아버지","우리 3조");
        profilelist.add(profileItem);
        profileItem= new ProfileItem(R.drawable.a2,"어머니","화이팅");
        profilelist.add(profileItem);
        profileItem= new ProfileItem(R.drawable.a5,"짱아","짝짝짝!!!");
        profilelist.add(profileItem);
        profileItem= new ProfileItem(R.drawable.a9,"흰둥이","짝짝짝!!!");
        profilelist.add(profileItem);
        profileItem= new ProfileItem(R.drawable.a3,"유리","짝짝짝!!!");
        profilelist.add(profileItem);
        profileItem= new ProfileItem(R.drawable.a4,"훈이","짝짝짝!!!");
        profilelist.add(profileItem);
        profileItem= new ProfileItem(R.drawable.a6,"철수","짝짝짝!!!");
        profilelist.add(profileItem);
        profileItem= new ProfileItem(R.drawable.a7,"맹구","짝짝짝!!!");
        profilelist.add(profileItem);
        profileItem= new ProfileItem(R.drawable.a3,"유리","짝짝짝!!!");
        profilelist.add(profileItem);
        profileItem= new ProfileItem(R.drawable.a4,"훈이","짝짝짝!!!");
        profilelist.add(profileItem);
        profileItem= new ProfileItem(R.drawable.a6,"철수","짝짝짝!!!");
        profilelist.add(profileItem);
        profileItem= new ProfileItem(R.drawable.a7,"맹구","짝짝짝!!!");
        profilelist.add(profileItem);


        //2. 사용자정의 어댑터 객체생성
        ProfileAdapter adapter =
                new ProfileAdapter(this, R.layout.activity_child_first_page_row,profilelist);
        //3. ListView에 어댑터 연결
        listView.setAdapter(adapter);



    }
}
