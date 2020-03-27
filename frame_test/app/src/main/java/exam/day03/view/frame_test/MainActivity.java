package exam.day03.view.frame_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout page1;
    LinearLayout page2;
    LinearLayout page3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.btnLogin);
        Button accnt = findViewById(R.id.btnAccnt);
        Button accnt_detail = findViewById(R.id.btnAccntDetail);

        page1 = findViewById(R.id.page1);
        page2 = findViewById(R.id.page2);
        page3 = findViewById(R.id.page3);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.VISIBLE);
                page2.setVisibility(View.INVISIBLE);
                page3.setVisibility(View.INVISIBLE);

            }
        });

        accnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.INVISIBLE);
                page2.setVisibility(View.VISIBLE);
                page3.setVisibility(View.INVISIBLE);
            }
        });

        accnt_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page1.setVisibility(View.INVISIBLE);
                page2.setVisibility(View.INVISIBLE);
                page3.setVisibility(View.VISIBLE);
            }
        });
    }
}
