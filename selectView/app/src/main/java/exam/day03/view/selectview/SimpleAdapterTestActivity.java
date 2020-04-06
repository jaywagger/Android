package exam.day03.view.selectview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

//전체가 리스트이다
public class SimpleAdapterTestActivity extends ListActivity {
    //두 줄 텍스트로 리스트뷰를 구성하기
    ArrayList<HashMap<String,String>> listdata =
            new ArrayList<HashMap<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //리스트를 구성할 샘플 데이터 준비
        HashMap<String,String> item = new HashMap<String, String>();
        item.put("name","황제윤");
        item.put("telNum","010-1111-1111");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name","황제윤2");
        item.put("telNum","010-2222-2222");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name","황제윤3");
        item.put("telNum","010-3333-3333");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name","황제윤4");
        item.put("telNum","010-4444-4444");
        listdata.add(item);

        SimpleAdapter adapter = new SimpleAdapter(this,
                   listdata, //HashMap으로 구성된 데이터가 저장된 리스트
                   android.R.layout.simple_list_item_2,
                   new String[]{"name","telNum"}, //HashMap에 저장된 키 리스트
                   //위에서 정의한 맵 데이터를 어떤 view에 출력할 것 인지
                   //키의 순서와 동일한 리소스아이디 순서
                   new int[]{android.R.id.text1,android.R.id.text2}
                   );
        setListAdapter(adapter);

    }
}
