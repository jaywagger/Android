package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

public class AsyncTaskTest extends AppCompatActivity {
    TextView view1;
    TextView view2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_test);
        view1 = findViewById(R.id.txtView1);
        view2 = findViewById(R.id.txtView2);

    }
    public void btn_click(View view){
        long now_time = System.currentTimeMillis();
		view1.setText(now_time+"");
    }
   
}
