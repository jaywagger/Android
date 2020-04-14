package multi.android.support_lib.fragment.exam;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import multi.android.support_lib.R;
import multi.android.support_lib.fragment.FirstFragment;
import multi.android.support_lib.fragment.SecondFragment;

public class FragmentTestMain2 extends AppCompatActivity {
    FirstFragment firstFragment =new FirstFragment(); //자바 클래스
    SecondFragment secondFragment = new SecondFragment();   //자바 클래스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test_main2);
        Log.d("lifecycle","fragment>>>>>>>>>>>>onCreate");

    }
    public void first_click(View view){
        //아래 4개가 기본 포멧
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,firstFragment);
        //Fragmentsms activity의 lifecycle에 종속적이나 activity처럼 동작할 수 있도록
        //backstack에 등록할 수 있다
        transaction.addToBackStack("first");
        transaction.commit();

    }
    //1. add 메ㅓ드를 이용하면 Fragment객체를 생성한다
    //  => 똑같은 객체는 한 개만 생성할 수 있다.
    //  => 리니어레이아웃에 추가하면 레이아웃의 특성 상 영역 바같에 추가되어 안 보임
    //2. replace는 있으면 있는 객체를 연결, 없으면 새로 생성해서 연결
    public void second_click(View view){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //transaction.add(R.id.container,secondFragment);
        transaction.replace(R.id.container,secondFragment);
        transaction.addToBackStack("second");
        transaction.commit();

    }
    //사용자가 Fragment를 볼 수 있는 시점
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","fragment>>>>>>>>>>>>onStart");
    }
    //사용자와 상호작용이 가능한 상태
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","fragment>>>>>>>>>>>>onResume");
    }
    //Fragment를 다른 Activity가 가리지 시작할 때 호출
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","fragment>>>>>>>>>>>>onPause");
    }
    //화면에서 안 보일 때
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","fragment>>>>>>>>>>>>onStop");
    }
    //모두 지워지고 호출
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","fragment>>>>>>>>>>>>onDestroy");
    }
}
