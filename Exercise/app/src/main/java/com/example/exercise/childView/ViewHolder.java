package com.example.exercise.childView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exercise.R;

public class ViewHolder {
    ImageView myImg;
    TextView nameView;
    TextView msgView;

    public ViewHolder(View parentView) {
        this.myImg = parentView.findViewById(R.id.profile_img);
        this.nameView = parentView.findViewById(R.id.profile_name);
        this.msgView = parentView.findViewById(R.id.profile_msg);
    }
}
