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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import multi.android.datamanagementpro.R;

public class ExternalFile_Exam extends AppCompatActivity {
    boolean permission_state;
    TextView externalTxt;
    //승인받을 권한의 목록
    String[] permission_list = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_file__exam);

        externalTxt = findViewById(R.id.editTxt1);

        //1. 권한체크
        //모든 권한을 셀프체크  permission_list에서 하나씩 꺼내서 작업
        for(String permission:permission_list){
            int chk = ContextCompat.checkSelfPermission(this,
                    permission);
            if(chk==PackageManager.PERMISSION_GRANTED){
                permission_state= true;
                printToast("READ / WRITE 권한 OK");
            }else {
                permission_state= false;
                printToast("READ / WRITE 권한 NO");

                //2. 권한 설정요청하기
                ActivityCompat.requestPermissions(this,
                        new String[]{permission_list[0]},
                        1);
                ActivityCompat.requestPermissions(this,
                        new String[]{permission_list[1]},
                        2);
            }
        }
    }
    //3. 권한 설정하기


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //저장 설정
        if(requestCode==1 && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                permission_state=true;
                printToast("저장 권한이 설정되었습니다 ㅎㅅㅎ");
            }else {
                printToast("저장 권한 설정 안 하시네요 ㅠㅠ");
            }
        }//열기 설정
        else if(requestCode==2 && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                permission_state=true;
                printToast("열기 권한이 설정되었습니다 ㅎㅅㅎ");
            }else {
                printToast("열기 권한 설정 안 하시네요 ㅠㅠ");
            }

        }
    }

    //저장하기 버튼
    public void btnWrite(View v){
        if(permission_state){
            printToast("저장되었습니다.");
            String state = Environment.getExternalStorageState();
            if (state.equals((Environment.MEDIA_MOUNTED))) {
                printToast("사용가능");

                //경로설정
                File external = Environment.getExternalStorageDirectory();
                String dirPath = external.getAbsolutePath();
                File dir = new File(dirPath);

                if(dir.exists()==false){
                    dir.mkdir();
                }
                FileWriter fw = null;
                try {
                   //파일 저장
                    //날짜
                    SimpleDateFormat today1 = new
                            SimpleDateFormat("yyyyMMdd");
                    Calendar c1 = Calendar.getInstance();
                    String today = today1.format(c1.getTime());

                    fw = new FileWriter(dirPath+"/myNote/"+today+"_memo.txt");
                    fw.write(externalTxt.getText().toString());
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
    //열기 버튼
    public void btnRead(View v){
        if(permission_state){
            printToast("파일열기");
            String state = Environment.getExternalStorageState();
            if (state.equals((Environment.MEDIA_MOUNTED))) {
                printToast("사용가능");

                //경로설정
                File external = Environment.getExternalStorageDirectory();
                String dirPath = external.getAbsolutePath();
                File dir = new File(dirPath);

                if(dir.exists()==false){
                    dir.mkdir();
                }
                BufferedReader br = null;
                try {
                    //파일 열기
                    //날짜
                    SimpleDateFormat today1 = new
                            SimpleDateFormat("yyyyMMdd");
                    Calendar c1 = Calendar.getInstance();
                    String today = today1.format(c1.getTime());

                    br = new BufferedReader(new
                            FileReader(dirPath+"/myNote/"+today+"_memo.txt"));
                    externalTxt.setText( br.readLine());

                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if(br!=null){
                            br.close();
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
    //새파일 버튼
    public void btnNew(View v){

    }
    //출력 메서드
    public void printToast(String msg){
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }
}
