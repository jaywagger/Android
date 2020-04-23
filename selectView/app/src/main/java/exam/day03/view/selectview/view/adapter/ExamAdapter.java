package exam.day03.view.selectview.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

public class ExamAdapter extends ArrayAdapter<ActorItem> {
    private Context context;
    private int resId;
    private ArrayList<ActorItem> datalist;

    HashMap<Integer,UserState> saveData = new HashMap<Integer,UserState>();

    public ExamAdapter(Context context, int resId, ArrayList<ActorItem> datalist) {
        super(context, resId, datalist);
        this.context = context;
        this.resId = resId;
        this.datalist = datalist;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public ActorItem getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        ViewHolder holder = null;
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            //뷰를 만드는 최초 작업 찾아서 가져오기
            holder = new ViewHolder(convertView);
            //홈더를 저장
            convertView.setTag(holder);
        }else {//여기는 뷰를 재 사용중
            holder = (ViewHolder)convertView.getTag();
        }

        //ArrayList에서 리턴된 리스트 항목의 번호와 동일한 데이터를 구하기
        ActorItem user= datalist.get(position);
        if(user!=null){

            ImageView imageView = holder.myImg;
            TextView nameView = holder.nameView;
            TextView dateView = holder.dateView;
            TextView msgView = holder.msgView;
            final CheckBox chkView = holder.chkView;


            imageView.setImageResource(user.cele_img);
            nameView.setText(user.cele_name);
            dateView.setText(user.cele_date);
            msgView.setText(user.cele_msg);

            //뷰를 만들 떄 저장된 내용이 있는지 체크해서 값을 출력하기
            UserState state = saveData.get(position); //saveData는 위에 지정한 hashmap
            if(state==null){
                chkView.setChecked(false); //없으면 빈값
            }else {
                chkView.setChecked(true); //데이터 있으면 데이터 출력
            }


            //EditText가 focus를 잃어버리는 시점에 입력한 데이터를 저장
            chkView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Boolean data = chkView.isChecked();
                    UserState objstate = new UserState();
                    objstate.datachk = data;
                    saveData.put(position,objstate);
                }
            });
        }

        return convertView;
    }
}