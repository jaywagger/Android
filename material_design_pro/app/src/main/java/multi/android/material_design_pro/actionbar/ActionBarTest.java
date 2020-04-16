package multi.android.material_design_pro.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import multi.android.material_design_pro.R;

public class ActionBarTest extends AppCompatActivity {
    TextView result;
    TextView result2;
    ListView listView;
    String[] datalist = {"가","나","다","라","바","마","사","아","자","차"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_test);
        result = findViewById(R.id.result);
        result2 = findViewById(R.id.result2);
        listView = findViewById(R.id.mylistview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1,
                datalist); //저 형식대로 datalist를 안에 넣기
        listView.setAdapter(adapter);

        //리스트뷰가 검색이 가능하도록 설정
        listView.setTextFilterEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);

        //검색뷰가 셋팅되어 있는 메뉴아이템을 추출
        MenuItem search_item = menu.findItem(R.id.search);
        //액션뷰로 설정되어 있는 뷰를 추출한다
        SearchView searchView= (SearchView)search_item.getActionView();
        searchView.setQueryHint("검색어를 입력하세요");

        //이벤트 연결하기
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                result.setText(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                result2.setText(newText);
                //전달되는 입력하는 문자열을 이용하여 리스트뷰에서 필터링
                listView.setFilterText(newText);
                if(newText.length()==0){
                    listView.clearTextFilter();
                }
                return true;
            }
        });

        //seartcj_item에 이벤트를 연결: TextView에 텍스트가 변경됌
        search_item.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                result.setText("메뉴 펼쳐짐");
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                result.setText("메뉴 접혀짐");
                return true;
            }
        });

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("menu", item.getItemId()+"");
        int id = item.getItemId();
        String msg="";
        switch (id){
            case R.id.search:
                msg="첫 번째 메뉴 선택";
                break;
            case R.id.option_1:
                msg="공유";
                break;

        }
        result2.setText(msg);
        return super.onOptionsItemSelected(item);
    }
}
