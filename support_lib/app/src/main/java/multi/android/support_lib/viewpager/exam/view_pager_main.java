package multi.android.support_lib.viewpager.exam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import multi.android.support_lib.R;
import multi.android.support_lib.viewpager.exam.others.ViewFragment1;
import multi.android.support_lib.viewpager.exam.others.ViewFragment2;
import multi.android.support_lib.viewpager.exam.others.ViewFragment3;

public class view_pager_main extends AppCompatActivity {
    ViewFragment1 viewFragment1;
    ViewFragment2 viewFragment2;
    ViewFragment3 viewFragment3;

    ViewPager mainPager ;
    ArrayList<Fragment> viewlist = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);

        mainPager = findViewById(R.id.Fragment_viewpager);
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ViewFragment2();
        viewFragment3 = new ViewFragment3();


        viewlist.add(viewFragment1);
        viewlist.add(viewFragment2);
        viewlist.add(viewFragment3);


        MainPagerAdapter adpater = new MainPagerAdapter(getSupportFragmentManager());
        mainPager.setAdapter(adpater);
    }
    public void btn_click(View view){
        //버튼 클릭시 이 메소드가 호출된다.
        //태그 1,2,3 로 각 버튼 구분
        setFragment(view.getTag().toString());
    }
    public void setFragment(String idx){
        Log.d("fragment",idx);
        FragmentManager adpater = getSupportFragmentManager();
        //fragment의 변화를 관리하는 객체
        FragmentTransaction transaction =adpater.beginTransaction();
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

    class MainPagerAdapter extends FragmentPagerAdapter {
        public MainPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return viewlist.size();
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return null;
        }
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            /*mainPager.addView(viewlist.get(position));*/
            return viewlist.get(position);
        }
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position
                , @NonNull Object object) {
            mainPager.removeView((View)object);
        }

    }
}
