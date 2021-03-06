package com.example.exercise.childView;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.exercise.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class bottomAppBar extends AppCompatActivity {
    Toolbar toolbar;
    ImageView app_bar_image;
    CollapsingToolbarLayout toolbarLayout;
    FloatingActionButton fab;
    ListView listView;
    ArrayList<String> datalist = new ArrayList<String>();
    BottomAppBar bottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomappbar);

        fab=findViewById(R.id.fab);
        listView = findViewById(R.id.mylistview);
        bottomAppBar = findViewById(R.id.bottom_bar);

        //버텀 디자인
        bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        bottomAppBar.setFabCradleRoundedCornerRadius(100);
        bottomAppBar.setFabCradleMargin(20);


        //리스트
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                datalist);

        listView.setAdapter(adapter);

        //FloadtingActionButton을 눌렀을 때 대화상자가 뜨고 입력한 데이터가
        //리스트뷰에 추가되도록 구현
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(bottomAppBar.this);
                //AlerDialog의 타이틀을 정의
                builder.setTitle("데이터입력");

                //AlerDialog에 보여질 화면을 inflate
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.input, null);
                //AlerDialog에 추가할 버튼을 정의
                builder.setPositiveButton("확인",new DialogListener());
                builder.setNegativeButton("취소", null);
                //AlerDialog에 화면 설정
                builder.setView(dialogView);
                builder.show();

            }
        });
    }

    //눌렀을 때 나오는 팝업: input
    class DialogListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
            //AlertDialog에서 입력한 내용을 ListView에 추가하기
            AlertDialog inputAlert = (AlertDialog)dialog; //뷰가 inputAlert안으로.
            EditText input = inputAlert.findViewById(R.id.input);
            String data = input.getText().toString();
            datalist.add(data);

            //ArrayList에 데이터를 추가한 후 adapter가 가지고 있는 데이터를 업데이트
            // => adapter에게 데이터가 변경되었음을 알려줘야 한다
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) listView.getAdapter();
            adapter.notifyDataSetChanged();

        }
    }

}
