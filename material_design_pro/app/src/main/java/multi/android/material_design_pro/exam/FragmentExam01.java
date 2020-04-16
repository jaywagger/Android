package multi.android.material_design_pro.exam;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;


public class FragmentExam01 extends AppCompatActivity {
    ViewFragment1 viewFragment1;
    ListTestFragment viewFragment2;
    ViewFragment3 viewFragment3;
    ViewPager fragment_viewPager ;
    TabLayout tabLayout;
    String[] tab_txt = {"추천여행지","출제","나와여행지"};
    ArrayList<Fragment> FragmentArrayList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);

        fragment_viewPager = findViewById(R.id.Fragment_viewpager);
        tabLayout = findViewById(R.id.examtab);
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ListTestFragment();
        viewFragment3 = new ViewFragment3();

        FragmentArrayList.add(viewFragment1);
        FragmentArrayList.add(viewFragment2);
        FragmentArrayList.add(viewFragment3);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        FragAdapter adapter =
                new FragAdapter(getSupportFragmentManager(),
                        FragmentArrayList.size());
        fragment_viewPager.setAdapter(adapter);
        fragment_viewPager.addOnPageChangeListener(new PagerListener());

        // 탭과 같이 움직이게 1
        tabLayout.setupWithViewPager(fragment_viewPager);

    }
    public void btn_click(View view){
        fragment_viewPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
    }

    public void setFragment(String idx){
        Log.d("fragment",idx);
        FragmentManager fragmentManager = getSupportFragmentManager();
        //fragment의 변화를 관리하는 객체
        FragmentTransaction transaction =fragmentManager.beginTransaction();
        switch (idx){
            case "0":                   //어디에, 무슨 fragment를 넣을지
                transaction.replace(R.id.container,viewFragment1);
                break;
            case "1":                   //어디에, 무슨 fragment를 넣을지
                transaction.replace(R.id.container,viewFragment2);
                break;
            case "2":                   //어디에, 무슨 fragment를 넣을지
                transaction.replace(R.id.container,viewFragment3);
                break;
        }
        transaction.commit();

    }
    class FragAdapter extends FragmentPagerAdapter {

        public FragAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return FragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return FragmentArrayList.size();
        }

        @Nullable
        @Override
        // 탭과 같이 움직이게 2
        public CharSequence getPageTitle(int position) {
            return tab_txt[position];
        }
    }

    //2.번쨰
    class PagerListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경될 때
            Toast.makeText(FragmentExam01.this,"페이지가 전환",
                    Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


}
