
package com.example.exercise.Among.bottom;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.exercise.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bottomNavigationBar extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_bar);

        //앱바
        ActionBar ab = getSupportActionBar() ;
        ab.setTitle("AMONG") ;
        ab.setDisplayUseLogoEnabled(true) ;
        ab.setDisplayShowHomeEnabled(true);

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
                            openFragment(scheduleFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };
}




