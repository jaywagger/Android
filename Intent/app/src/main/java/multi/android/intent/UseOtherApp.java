package multi.android.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//intent를 이용한 서로 다른 앱에서 작업 (다른 프로젝트)
public class UseOtherApp extends AppCompatActivity {

    public static final int SELECT_VIEW = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_other_test);
    }

    public void callActivity(View view){
        //다른 앱의 엑티비티를 호출
        //암시적 인텐트 - 정확하게 실행할 엑티비티명을 모르는 경우
        Intent intent = new Intent("com.exam.selectview");
                                            //암시적 인텐트로 설정한 경우
                                            //다른 앱 중 manifest에 com.exam.selectview
                                            // 설정한 앱이 다 뜬다.
        startActivityForResult(intent,SELECT_VIEW);
    }
}
