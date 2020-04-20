package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
//동시에 여러 작업을 하기 위해
//동시다발로 진행될 떄 멀티 쓰레드를 사용한다. 하나의 실행 단위: Thread
public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    int progressVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.text1);
    }


    public void btnNoThread(View view){
        for(progressVal=1;progressVal<100;progressVal++){
            progressBar.setProgress(progressVal); //1~100까지
            SystemClock.sleep(1000); // 1초동안 쉬게
                                        //1초씩 멈춰보이게 하는 효과

        }
    }
}
