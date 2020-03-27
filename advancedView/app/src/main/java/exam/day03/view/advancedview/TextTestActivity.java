package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TextTestActivity extends AppCompatActivity {

    //layout 페이지에서 사용할 뷰에 대한 리소스를 불러와야한다: 변수선언
    EditText txtinfo;
    TextView lblinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_test);
        lblinfo = findViewById(R.id.myinfo);
        txtinfo = findViewById(R.id.mytext);

        Button btngetter = findViewById(R.id.btnget);
        Button btnsetter = findViewById(R.id.btnset);

        btngetter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               String msg = txtinfo.getText()+"";
               lblinfo.setText(msg);
            }
        });

        btnsetter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                txtinfo.setText("가져온 문자열: 작업완료");
            }
        });
    }
}
