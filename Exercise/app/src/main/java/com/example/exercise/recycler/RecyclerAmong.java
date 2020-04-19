package com.example.exercise.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.exercise.R;
import java.util.ArrayList;


public class RecyclerAmong extends AppCompatActivity {
    private ArrayList<DTORecycler> arrayList;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerlist;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_among);

        recyclerlist = findViewById(R.id.rv);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerlist.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        recyclerAdapter = new RecyclerAdapter(arrayList);
        recyclerlist.setAdapter(recyclerAdapter);

        //추가버튼
        Button btn_add = (Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DTORecycler dtoRecycler = new DTORecycler(R.drawable.profile_mother,"엄마");
                arrayList.add(dtoRecycler);
                recyclerAdapter.notifyDataSetChanged();
            }
        });

        GridLayoutManager manager =
                new GridLayoutManager(getApplicationContext(),2);
        recyclerlist.setHasFixedSize(true);
        recyclerlist.setLayoutManager(manager);
        recyclerlist.setAdapter(recyclerAdapter);




    }
}