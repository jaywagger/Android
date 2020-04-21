package multi.android.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
//동시에 여러 작업을 하기 위해
//동시다발로 진행될 떄 멀티 쓰레드를 사용한다. 하나의 실행 단위: Thread
public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    int progressVal;
    Handler handler1;
    Handler handler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);

        //worker thread의 요청을 처리할 handler 객체를 정의
        handler1 = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Log.d("mythread", "handleMessage 요청: ");
                textView.setText("progressbar 진행률: " +
                        progressVal+"%");
                progressBar.incrementProgressBy(1);
            }
        };
        handler2 = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                Log.d("mythread",msg.what+"");
                if(msg.what==1){
                    int val = msg.arg1;
                    textView.setText("progressbar 진행률: " +
                            val+"%");
                    progressBar.incrementProgressBy(1);
                }
            }
        };


    }
/*
        화면을 변경하는 작업을 다른 메서드에서 처리
        문제점: 오랜 작업 시간. 작업동안 다른 작업을 할 수 없다.
        그래서 오류로 튕김. 안드로이드는 이벤트가 발생하고 5초가 넘으면
        강제로 어플리케이션을 종료한다.멀티 쓰레드로 작업해야 함

        오랫동안 처리해야 하는 작업은 UI 쓰레드가 아닌 별로의 작업 쓰레드를 생성
        메인 실행시키면 UI 쓰레드가 작동하는 것 이다. 이벤트를 리스닝하는 일.

    */

   public void btnNoThread(View view){
        for(progressVal=1;progressVal<=100;progressVal++){
            progressBar.setProgress(progressVal); //1~100까지
            SystemClock.sleep(1000); // 1초동안 쉬게
                                        //1초씩 멈춰보이게 하는 효과

        }
    }
    //개발자가 만든 쓰레드 안에서 UI를 변경
    //잠정적인 문제점을 갖고 있는 방법 (UI의 변경은 UI쓰레드에서만 작업)
    public void useThread(View view){
        //Progress Bar의 진행상태가 출력
        //Progress Bar의 프로세스가

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(progressVal=1;progressVal<=100;progressVal++){
                    progressBar.setProgress(progressVal); //1~100까지
                    textView.setText("progressbar 진행률: " +
                                        progressVal+"%");
                    SystemClock.sleep(1000); // 1초동안 쉬게
                    //1초씩 멈춰보이게 하는 효과
                }
            }
        }).start();
    }

    //작업쓰레드(Worker Thread)가 핸들러에게 view에 대한 변경을 요청한다.
    //핸들러는 작업쓰레드로 부터 받은 요청정보를 꺼내서 뷰를 변경한다
    public void useHandler(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(progressVal=1;progressVal<=100;progressVal++){
                    handler1.sendMessage(handler1.obtainMessage());
                    SystemClock.sleep(100); // 1초동안 쉬게
                    //1초씩 멈춰보이게 하는 효과
                }
            }
        }).start();
    }
    //핸들러 이용
    //작업 쓰레드에서 값을 핸들러에게 넘기기
    //핸들러에게 작업을 의뢰할 떄 Message 객체를 생성해서 전달
    public void useMessageHandler(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++){
                    //변경할 뷰의 정보나 핸들러에게 전달할 데이터를
                    //메세지 객체로 생성하는 작업
                    Message msg =new Message();
                    msg.what = 1;
                    msg.arg1 = i; //전달할 데이터
                    //Message 객체를 전달하며 핸들러에게 작업을 의뢰
                    handler2.sendMessage(msg);
                    SystemClock.sleep(100);
                }
            }
        }).start();
    }
}

