package multi.android.datamanagementpro.filesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import multi.android.datamanagementpro.R;

public class ExternalFileMgr extends AppCompatActivity {

    boolean permission_state;
    TextView externalTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_file_mgr);
        externalTxt = findViewById(R.id.fileTxt);

        //1. 권한체크
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                PackageManager.PERMISSION_GRANTED){
            permission_state= true;

        }else{
            permission_state= false;


            //2. 권한 설정요청하기
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
        }
    }

    //저장버튼
    public void saveExternalFileSystem(View v){
        //printToast("이것은 <저장하기> 버튼이오");
        if(permission_state){
            printToast("권한이 설정되었습니다");
            String state = Environment.getExternalStorageState();
            if (state.equals((Environment.MEDIA_MOUNTED))) {
                printToast("사용가능");
                //경로설정
                File external = Environment.getExternalStorageDirectory();
                /*String dirPath = external.getAbsolutePath()+"/myApp";*/
                String dirPath = external.getAbsolutePath();
                String pkg = getPackageName();


                //디렉토리가 없으면 생성
                //File dir = new File(dirPath);
                File dir = new File(dirPath+"/android/data/"+pkg);
                                //외부저장소 저 위치에 패키지명(테이터매니지프로)으로 디렉토리 생성
                                //앱 삭제 시 같이 지워진다
                if(dir.exists()==false){
                    dir.mkdir();
                }

                FileWriter fw = null;
                try {
                    //파일 저장
                    Log.d("test1", "외부파일");
                    fw = new FileWriter(dir+"/test1.txt");
                    fw.write("외부 저장소 테스트 중");
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if(fw!=null){
                            fw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }else {
            printToast("권한이 없습니다ㅠㅠ");
        }

    }
    //열기버튼
    public void openInternalFile(View v){
        //printToast("이것은 <열기> 버튼이오");
        //1. 권한체크
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)==
                PackageManager.PERMISSION_GRANTED){
            permission_state= true;
            printToast("권한이 설정되었습니다");
        }else{
            permission_state= false;
            printToast("권한이 없습니다ㅠㅠ");

            //2. 권한 설정요청하기
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    2);
        }
    }
    //출력메서드
    public void printToast(String msg){
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    //3. 권한 설정하기
    //ctr+o
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1 && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                permission_state=true;
                printToast("저장 권한이 설정되었습니다 ㅎㅅㅎ");
            }else {
                printToast("저장 권한 설정 안 하시네요 ㅠㅠ");
            }
        }else if(requestCode==2 && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                permission_state=true;
                printToast("열기 권한이 설정되었습니다 ㅎㅅㅎ");
            }else {
                printToast("열기 권한 설정 안 하시네요 ㅠㅠ");
            }

        }
    }
}
