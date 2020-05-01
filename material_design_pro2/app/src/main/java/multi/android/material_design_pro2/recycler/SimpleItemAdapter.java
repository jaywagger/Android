package multi.android.material_design_pro2.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import multi.android.material_design_pro2.R;

//RecyclerView에서 사용하는 Adapter를 커스트마이징
//Adapter안에 ViewHoldewr가 포함되어 있음. 정의해야함 (ListVIew 사용할 떄와 동일한 역할)
//            -----------
//              L Inner Class로 정의
public class SimpleItemAdapter
        extends RecyclerView.Adapter<SimpleItemAdapter.ViewHolder> {

    Context context;
    int row_res_id; //row를 구성하는 layout
    List<SimpleItem> data; //RecycleView에 출력될 데이터

    public SimpleItemAdapter(Context context, int row_res_id, List<SimpleItem> data) {
        this.context = context;
        this.row_res_id = row_res_id;
        this.data = data;
    }

    //xml로 부터 한 개의 Row에 대한 뷰를 만들어서 Viewholder한테 넘기는 메서드
    //View를 구성하는 구성요소의 리소스를 가져오는 작업을 하는 객체
    //1. onCreateViewHolder에서 row에 대한 뷰를 inflate해서 생성
    //2. ViewHolder 객체를 만들어서 1번에서 생성한 뷰를 넘긴다.
    //3. ViewHolder 객체 안에서 onCreateViewHolder 메서드 리턴받아 객체에
    // 데이터를 연결할 뷰를 찾아온다
    //4. onBindViewHolder메서드에서 ViewHolder가 갖고 있는 구성요소에 데이터 연결하기
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(row_res_id,null);
        return new ViewHolder(view);
        //ViewHolder로
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        TextView row_text_view = holder.textView;
        row_text_view.setText(data.get(position).getData());
        row_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "데이터 연결 완료",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    //RecyclerView에 출력할 데이터의 갯수를 리턴
    @Override
    public int getItemCount() {
        return data.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);                        //simple_item_xml
            textView = itemView.findViewById(R.id.itemview);
        }
    }

}
