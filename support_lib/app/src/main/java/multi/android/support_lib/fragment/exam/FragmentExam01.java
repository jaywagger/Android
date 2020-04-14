package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import multi.android.support_lib.R;

public class FragmentExam01 extends AppCompatActivity {
    ViewFragment1 viewFragment1;
    ViewFragment2 viewFragment2;
    ViewFragment3 viewFragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);
        //특정 fragment (컨테이너 부분)에 아래 이미지를 띄운다.
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ViewFragment2();
        viewFragment3 = new ViewFragment3();

    }
    public void btn_click(View view){
        setFragment(view.getTag().toString());
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



}
