package com.example.exercise.recycler;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercise.R;
import com.example.exercise.intent.ClickFunction;

import java.util.ArrayList;
import android.content.Intent;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {
    //DTPRecycler: 내가 원하는 데이터 형식의 DTO
    //ArrayList<DTORecycler>: 내가 원하는 데이터 형식을 담은 ArrayList
    private ArrayList<DTORecycler> arrayList;
    Context context;

    //리스트 생성자
    public RecyclerAdapter(ArrayList<DTORecycler> arrayList,Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    //LayoutInflater란 xml 파일을 View 객체로 변환해주는 기능
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder holder, int position) {
        holder.profile_img.setImageResource(arrayList.get(position).getProfile_img());
        holder.profile_name.setText(arrayList.get(position).getProfile_name());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String crrntName = holder.profile_name.getText().toString(); 이거 대신 아래 text
                Toast.makeText(v.getContext(),"짧게 클릭하셨습니다.",Toast.LENGTH_SHORT).show();
                popup();


            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),"길게 눌러 삭제하셨습니다.",Toast.LENGTH_SHORT).show();
                remove(holder.getAdapterPosition());
                return true;
            }
        });

    }

    public void popup(){
        final Dialog MyDialog = new Dialog(context);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.activity_click_function);
        MyDialog.setTitle("My Custom Dialog");

        Button close = (Button)MyDialog.findViewById(R.id.btn_back);
        Button runCall = (Button)MyDialog.findViewById(R.id.run_call);

        runCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "전화",Toast.LENGTH_SHORT).show();

            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.cancel();
            }
        });
        MyDialog.show();


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void remove(int position){
        try {
            arrayList.remove(position);
            notifyItemRemoved(position);

        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();

        }
    }
    //컨텐츠 정의
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView profile_img;
        protected TextView profile_name;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profile_img = (ImageView)itemView.findViewById(R.id.profile_img_father);
            this.profile_name = (TextView)itemView.findViewById(R.id.profile_name_father);
        }
    }
}
