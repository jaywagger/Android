package multi.android.datamanagementpro.permission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import multi.android.datamanagementpro.R;

public class RuntimePermissionTest extends AppCompatActivity {
    //퍼미션의 상태를 저장할 변수
    boolean permission_state; //초기값이 없으면 false다

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_permission_test);

        //1. Permission Check
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
            permission_state= true;
            printToast("권한이 설정되었습니다");
        }else{
            permission_state= false;
            printToast("권한이 설정해야 합니다.");
            //2. 권한이 없으니 설정하기
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    1000); //요청코드는 맘대로
                    //카메라에서 권한 요청 yes or no
                    //그 후 액션은 아래 3번으로
        }
    }

    // 3. requestPermissions의 메세지창에서 선택 후 호출되는 메서드
    // 결과를 리턴: 결과에 따라 다르게 처리할 수 있도록 구현
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1000 && grantResults.length>0){
            //0보다 크면 하나라도 권한에 대한 처리가 있다는 뜻
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                //첫 번째 승락이면
                permission_state=true;
                printToast("권한 설정 마무리 완료");
            }else {
                printToast("권한 설정 NO, 기능 사용 못함");
            }

        }
    }

    public void printToast(String msg){
        Toast.makeText(this, msg,Toast.LENGTH_LONG).show();
    }
    public void runCamera(View v){
        if(permission_state){
            //true일때만
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        }else{
            printToast("권한이 설정해야 카메라를 사용할 수 있음.");
            //권한 설정할 수 있는 액티비티로 자동 이동되도록 개발해야 함
        }


    }
}
