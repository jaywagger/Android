package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

//이벤트를 발생시킬 소스객체(버튼)가 있는 엑티비티에서  이벤트를 처리하는
//작업도 같이 할 수 있도록 구현
//1. 이벤트에 반응하는(미리 정해져있음) 클래스를 상속받는다.
//2. 메소드를 오버라이딩한다.
// ex. 버튼을 클릭할 때
//      실행될 리스너 => view.onclickListener의 onclick 메소드가 호출

public class LayoutExam extends AppCompatActivity implements View.OnClickListener{
    ImageView firstView;
    Button btnfirst;
    ImageView secondView;
    Button btnsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_exam);
        //layout에 디자인한 ImageView와 Button 객체를 받아오기
        firstView = findViewById(R.id.firstImg);
        btnfirst = findViewById(R.id.btnUp);
        secondView = findViewById(R.id.secondImg);
        btnsecond = findViewById(R.id.btndown);

        //setOnClickListener를 이용해서 이벤트를 처리하는데 이떄 구현된 리스너객체가
        //어떤 것인지 등록
        btnfirst.setOnClickListener(this);
        btnsecond.setOnClickListener(this);
    }

    //onClick메소드를 호출하는 이벤트 소스 객체는 다양
    //매개변수에 전달되는 View는 이벤트를 발생시킨 소스 객체
    @Override
    public void onClick(View v) {
        Log.d("myEvent","이벤트 발생");
        if(v.getId()==R.id.btnUp){
            imageUp();
        }else if(v.getId()==R.id.btndown){
            imageDown();
        }
    }
    public void imageDown(){
        //ImageView에 이미지리소스를 추가. 리조스로 보여주기하면 됌
        secondView.setImageResource(R.drawable.beach);
        firstView.setImageResource(0);//이미지를 없애기
        //setImageResource메소드를 이용해서 이미지를 변경했지만 화면이
        //자동으로 갱신/변경되지 않는다.
        secondView.invalidate();
        firstView.invalidate();

    }
    public void imageUp(){

        secondView.setImageResource(0);
        firstView.setImageResource(R.drawable.flower);
        secondView.invalidate();
        firstView.invalidate();

    }

}
