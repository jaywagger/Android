package multi.android.material_design_pro2.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class SimpleRecyclerTest extends AppCompatActivity {
    RecyclerView recyclerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_test);

        recyclerlist = findViewById(R.id.recyclerlist);

        //1. Recycler에 출력할 데이터 준비
        List<SimpleItem> recycler_simple_data = new ArrayList<SimpleItem>();
        for (int i=0;i<10;i++){
            //우리가 만든 자바 클래스
            SimpleItem item = new SimpleItem("simple_item"+i);
            recycler_simple_data.add(item);
        }
        //2. Adapter 생성
        SimpleItemAdapter adapter = new SimpleItemAdapter(this,
                                        R.layout.simple_item,
                                        recycler_simple_data);
        //3. Recycler에 레이아웃을 설정
        //      LinearLayout, GridLayout
        //RecyclerView에 설정할 레이아웃 객체 생성

        //Linear. 아래는 Grid
        //LinearLayoutManager manager =
        //        new LinearLayoutManager(getApplicationContext());
        //manager.setOrientation(LinearLayoutManager.VERTICAL);

        //Grid
        GridLayoutManager manager =
                new GridLayoutManager(getApplicationContext(),2);
        recyclerlist.setHasFixedSize(true);
        recyclerlist.setLayoutManager(manager); //Vertical LinearLayout이 셋팅 됌

        //4. Recycler와 Adapter를 연결
        recyclerlist.setAdapter(adapter);
        //5. 추가적인 요소들을 적용 - 꾸미기, 애니메이션

    }
}
