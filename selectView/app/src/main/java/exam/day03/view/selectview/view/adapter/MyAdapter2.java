package exam.day03.view.selectview.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import exam.day03.view.selectview.R;
//성능 개선을 위한 작업을 추가
// 1. 한 번 만든 뷰는 재사용
// 2. findViewById 한 번 작업한 뷰에 대한 정보는 저장해 놓고 다시 사용
public class MyAdapter2 extends ArrayAdapter<User> {
    private Context context;
    private int resId;
    private ArrayList<User> datalist;

    //row마다 사용자가 설정한 값을 position과 함께 저장
    //해당 position에 대한 설정 값을 같이 출력
    //저장하는 시점은 사용자가 설정을 끝낸 시점 - focus를 잃어버리는 시점
    HashMap<Integer,SavaUserState> saveData =
            new HashMap<Integer,SavaUserState>();

    public MyAdapter2(Context context, int resId, ArrayList<User> datalist) {
        super(context, resId, datalist);
        this.context = context;
        this.resId = resId;
        this.datalist = datalist;
    }

    //리스트 갯수 반환
    @Override
    public int getCount() {
        return datalist.size();
    }

    //매개변수로 전달받은 순서에 있는 리스트 항목을 반환
    @Override
    public User getItem(int position) {
        return datalist.get(position);
    }

    //리스트의 한 항목을 만들 떄 호출되는 메소드 - 리스트 항목이 100개면, 100번 호출되는 메소드
    //position => list순서
    //convertView => 한 항목에 대한 뷰
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.d("getview","getview"+position);
        long start = System.nanoTime();
        //뷰를 생성 - 매개변수로 전달되는 converView를 재 사용
        UserViewHolder holder = null;
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            //뷰를 만드는 최초 작업 찾아서 가져오기
            holder = new UserViewHolder(convertView);
            //홈더를 저장
            convertView.setTag(holder);
        }else {//여기는 뷰를 재 사용중
            holder = (UserViewHolder)convertView.getTag();
        }


        //ArrayList에서 리턴된 리스트 항목의 번호와 동일한 데이터를 구하기
        User user= datalist.get(position);
        if(user!=null){
            //위에서 생성한 뷰의 각 요소에 데이터를 연결
            //convertView 를 재 사용하니깐 매번 findViewById로 호출할 필요가 없음
            //그렇기 위해서 ViewHolder 객체를 생성해야 한다.
            ImageView imageView = holder.myImg;
            TextView nameView = holder.nameView;
            TextView telNumView = holder.telNumView;
            final EditText editVew = holder.editView;

            imageView.setImageResource(user.myImg);
            nameView.setText(user.name);
            telNumView.setText(user.telNum);

            //뷰를 만들 떄 저장된 내용이 있는지 체크해서 값을 출력하기
            SavaUserState state = saveData.get(position); //saveData는 위에 지정한 hashmap
            if(state==null){
                editVew.setText(""); //없으면 빈값
            }else {
                editVew.setText(state.data); //데이터 있으면 데이터 출력
            }

            //EditText가 focus를 잃어버리는 시점에 입력한 데이터를 저장
            editVew.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(!hasFocus){ //포커스가 없을 떄
                        String data = editVew.getText().toString();
                        SavaUserState objstate = new SavaUserState();
                        objstate.data = data;
                        saveData.put(position,objstate); //이게 저장되는 거다
                    }
                }
            });
        }
        long end = System.nanoTime();
        Log.d("getview",(end-start)+"");

        return convertView;
    }
}
