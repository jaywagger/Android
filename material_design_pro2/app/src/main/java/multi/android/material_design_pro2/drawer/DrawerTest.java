package multi.android.material_design_pro2.drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import multi.android.material_design_pro2.R;

public class DrawerTest extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle; //메뉴 아이콘처럼 누르면 나오도록

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.main_drawer); //전체 숨긴 메뉴 뷰 (Drawer)

        //Actionbar에 추가될 버튼 - 버튼을 선택하면 NavigationView가 보이고
        //                       - 다시 선택하면 사라지도록
        toggle = new ActionBarDrawerToggle(this,
                                    drawerLayout,
                                    R.string.open_str,
                                    R.string.close_str); //String을 직접 입력 못 하고
                                                        // string value에 설정해서 사용
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //기본 버튼으로 추가하겠다
                                                                //default: 뒤로가기 버튼
        toggle.syncState();    //뒤로가기 버튼이 토글로 변경 됌

        //drawer안에 있는 메뉴
        NavigationView navigationView = findViewById(R.id.main_drawer_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id==R.id.item1){
                    Toast.makeText(DrawerTest.this,
                            "회원정보", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }
    //이제 누르면 나오도록 이벤트를 걸어주자
    //Drawer를 사용할 때 onOptionsItemSelected 메소드가 필수다.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "선택",Toast.LENGTH_SHORT).show();
        if(toggle.onOptionsItemSelected(item)){
            Toast.makeText(this, "if", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
