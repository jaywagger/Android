package multi.android.support_lib.viewpager.exam;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import multi.android.support_lib.R;
import multi.android.support_lib.fragment.exam.ViewFragment1;
import multi.android.support_lib.fragment.exam.ViewFragment2;
import multi.android.support_lib.fragment.exam.ViewFragment3;

public class FragmentViewPager extends AppCompatActivity {
    ViewFragment1 viewFragment1;
    /*ViewFragment2 viewFragment2;*/
    ListTestFragment viewFragment2;
    MapFragment viewFragment4;
    ViewFragment3 viewFragment3;

    ViewPager fragment_viewPager ;
    ArrayList<Fragment> FragmentArrayList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);

        fragment_viewPager = findViewById(R.id.Fragment_viewpager);
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ListTestFragment();
        viewFragment3 = new ViewFragment3();
        viewFragment4 = new MapFragment();
        FragmentArrayList.add(viewFragment1);
        FragmentArrayList.add(viewFragment2);
        FragmentArrayList.add(viewFragment3);
        FragmentArrayList.add(viewFragment4);

        FragAdapter adapter =
                new FragAdapter(getSupportFragmentManager(),
                        FragmentArrayList.size());
        Log.d("adapter","adapter");
        fragment_viewPager.setAdapter(adapter);

        fragment_viewPager.addOnPageChangeListener(new PagerListener());

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
    }

    //2.번쨰
    class PagerListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
        //페이지가 변경될 때
            Toast.makeText(FragmentViewPager.this,"페이지가 전환",
                    Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


}
