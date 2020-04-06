package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class today_exercise extends AppCompatActivity {

    ProgressBar bar;
    Button btnBar1;
    Button btnBar2;
    Button btnBar3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_exercise);

        bar = findViewById(R.id.bar1);
        btnBar1 = findViewById(R.id.barBtn1);
        btnBar2 = findViewById(R.id.barBtn2);
        btnBar3 = findViewById(R.id.barBtn3);

        btnBar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });
        btnBar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Decrease();
            }
        });
        btnBar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVal();
            }
        });
    }

    public void increase(){
        bar.incrementProgressBy(5);
    }
    public void Decrease(){
        bar.incrementProgressBy(-5);
    }
    public void setVal(){
        bar.setProgress(80);
    }
}
