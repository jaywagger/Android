package exam.day03.view.selectview.view.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import exam.day03.view.selectview.R;

public class ViewHolder {
    ImageView myImg;
    TextView nameView;
    TextView dateView;
    TextView msgView;
    CheckBox chkView;

    public ViewHolder(View parentView) {
        this.myImg = parentView.findViewById(R.id.cele_img);
        this.nameView = parentView.findViewById(R.id.txt_cele_name);
        this.dateView = parentView.findViewById(R.id.txt_cele_date);
        this.msgView = parentView.findViewById(R.id.txt_cele_msg);
        this.chkView = parentView.findViewById(R.id.cele_chkBox);
    }

}
