package exam.day03.view.selectview.view.adapter;

import android.widget.CheckBox;

import java.util.ArrayList;

import exam.day03.view.selectview.R;

public class ActorItem {
    int cele_img;
    String cele_name;
    String cele_date;
    String cele_msg;


    public ActorItem(int cele_img, String cele_name, String cele_date, String cele_msg) {
        this.cele_img = cele_img;
        this.cele_name = cele_name;
        this.cele_date = cele_date;
        this.cele_msg = cele_msg;
    }

    @Override
    public String toString() {
        return "ActorItem{" +
                "cele_img=" + cele_img +
                ", cele_name='" + cele_name + '\'' +
                ", cele_date='" + cele_date + '\'' +
                ", cele_msg='" + cele_msg + '\'' +
                '}';
    }
}


