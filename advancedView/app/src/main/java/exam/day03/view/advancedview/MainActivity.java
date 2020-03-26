package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img01;
    ImageView img02;
    int index; //화면 뭐가 실행되고 있는지. 값이 없으므로 default가 0
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //findViewById()는 여기서 사용이 가능하다
      // ImageView img01 = findViewById(R.id.img01); 지역변수이므로 위에 멤버변수 선언
        img01 = findViewById(R.id.img01);
        img02 = findViewById(R.id.img02);
    }

    //클릭과 이미지교체 2개의 기능이 이뤄진다.

    //버튼 클릭 호출되는 메소드
    public void myclick(View v){

        imageChange();
    }

    //이미지가 교체된다.
    public void imageChange(){
        if(index==1){
            //0번에 해당하는 이미지를 화면에 출력
            img01.setVisibility(View.VISIBLE);
            //위에는 보이고 아래는 안 보이게
            img02.setVisibility(View.INVISIBLE);
            index=0;
            Log.d("value","현재 index 값"+index);

        }else if(index==0){
            img02.setVisibility(View.VISIBLE);
            //위에는 보이고 아래는 안 보이게
            img01.setVisibility(View.INVISIBLE);
            index=1;
            Log.d("value","현재 index 값"+index);
        }
    }
}
