package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ImageScrollMission extends AppCompatActivity {
    ImageView img1;
    ImageView img2;
    int index1;
    int index2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_scroll_mission);
        img1 = findViewById(R.id.bike1);
        img2 = findViewById(R.id.bike2);

    }

    //클릭메서드
    public void clickImg1(View v) {
        changeImg1();
    }

    //클릭메서드
    public void clickImg2(View v) {
        changeImg2();
    }

    //이미지 교체 메서드
    public void changeImg1() {
        if(index1==0){
        img2.setVisibility(View.VISIBLE);
        img1.setVisibility(View.INVISIBLE);
            Log.d("value", "현재1: " + index1);
        index1=1;

        }else if(index1==1){
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
            Log.d("value", "현재1: " + index1);
            index1=0;
        }
    }
    //이미지 교체 메서드
        public void changeImg2() {
            if(index2==0){
                img2.setVisibility(View.VISIBLE);
                img1.setVisibility(View.INVISIBLE);
                Log.d("value", "현재2: " + index2);
                index2=1;

            }else if(index2==1){
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.INVISIBLE);
                Log.d("value", "현재2: " + index2);
                index2=0;
            }
        }


}


