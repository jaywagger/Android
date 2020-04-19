package com.example.exercise.intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.exercise.R;

public class ClickFunction extends AppCompatActivity {
    //승인받을 권한의 목록
    String[] permission_list = {Manifest.permission.CALL_PHONE

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_function);
        Button btn_back = findViewById(R.id.btn_back);


        //액티비티가 만들어질 떄 권한 체크를 할 수 있는 메서드 호출
        runPermission();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//액티비티 종료
            }
        });



        //뒤로 돌아가기 버튼 만들기

    }
    //실제 전화걸기 실행
    public void runCall(View v){
        Intent intent = null;
        int chk = PermissionChecker.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE);
        if(chk==PackageManager.PERMISSION_GRANTED){
            //권한 승락이 된 상태                           //5554번에서 5556번 전화하기
            Log.d("tel","성공");
            intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-8231-0841"));

        }else {
            Log.d("tel","실패");
            return;
        }
        startActivity(intent);
    }
    //구글맵 실행
    public void runGoogleMap(View v){
        //앱에서 보여줄 데이터
        Uri uri = Uri.parse("geo:37.501579, 127.039585");
        //안드로이드에서 정의되어 있는 맵뷰, 보여줄 데이터
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    //권한을 체크할 메서드 : 승인처리
    public void runPermission(){
        //하위버전이면 실행되지 않도록 처리
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return; // 이러면 그냥 종료
        }
        //모든 권한을 셀프체크  permission_list에서 하나씩 꺼내서 작업
        for(String permission:permission_list){
            int chk = checkCallingOrSelfPermission(permission);
            //권한 셀프 체크가 안되는 경우에
            if(chk== PackageManager.PERMISSION_DENIED){
                requestPermissions(permission_list,0);
                break;
            }

        }
    }
}
