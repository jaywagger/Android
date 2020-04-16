package multi.android.material_design_pro.tab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import multi.android.material_design_pro.R;
import multi.android.material_design_pro.exam.ListTestFragment;
import multi.android.material_design_pro.exam.ViewFragment1;
import multi.android.material_design_pro.exam.ViewFragment3;

public class TabTest extends AppCompatActivity {

    ViewFragment1 viewFragment1;
    ListTestFragment viewFragment2;
    ViewFragment3 viewFragment3;
    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;

    ViewPager fragment_viewPager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);

        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ListTestFragment();
        viewFragment3 = new ViewFragment3();
        tabLayout = findViewById(R.id.mytab);
        bottomNavigationView = findViewById(R.id.bottomNavi);

        //탭추가
        tabLayout.addTab(tabLayout.newTab().setText("설정"));

        //처음 실행할 때 보여줄 프레그먼드 지정
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentContainer,viewFragment1).commit();

        //탭 클릭시 발생하는 이벤트
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //탭 선택시 호추로디는 메서드
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position  = tab.getPosition(); //탭의 순서를 받아옴
                Log.d("tab",position+"");
                Fragment fragment = null;
                if(position==0){
                    fragment = viewFragment1;
                }else if(position==1){
                    fragment = viewFragment2;
                }else if(position==2){
                    fragment = viewFragment3;
                }else {
                    fragment = viewFragment1;
                }
                //탭을 선택할 떄 지정된 프레그먼트 객체가 show 되도록 연결
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer,fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //BottomNavigationView 이벤트 연결
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.bottom_item2){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainer,viewFragment2).commit();
                }
                return false;
            }
        });

    }
}
