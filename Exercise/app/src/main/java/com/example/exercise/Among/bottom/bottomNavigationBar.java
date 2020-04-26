
package com.example.exercise.Among.bottom;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.exercise.R;
import com.example.exercise.childView.ProfileAdapter;
import com.example.exercise.childView.ProfileItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class bottomNavigationBar extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_bar);

        /*ListView listView = findViewById(R.id.listContent);
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
        listView.setAdapter(adapter);*/

        //아래메뉴
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(homeFragment.newInstance("", ""));


    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            openFragment(homeFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_wellfare:
                            openFragment(wellfareFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_chat:
                            openFragment(chatFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_community:
                            openFragment(communityFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_question:
                            openFragment(questionFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };
}




