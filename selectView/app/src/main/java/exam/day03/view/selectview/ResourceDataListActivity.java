package exam.day03.view.selectview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

//리소스 파일 mydata를 만들어서 리스트로 출력하기
public class ResourceDataListActivity extends AppCompatActivity {

    ListView listview;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_test);

        listview = findViewById(R.id.listview1);
        txt = findViewById(R.id.listTxt);

        //리소스로 저장되어 있는 데이터를 ListView에 출력
        ArrayAdapter adapter =
                ArrayAdapter.createFromResource(this,
                        R.array.mylist_data,
                        android.R.layout.simple_list_item_1);//simple_list_item_1 안드로이드에서 제공하는 디자인
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //View view 매개변수는 목록을 구성하는 하나의 데이터가 출력되는
                //Row를 구성하는 View
                TextView listTxt = (TextView)view;
                txt.setText(listTxt.getText());
            }
        });

    }
}
