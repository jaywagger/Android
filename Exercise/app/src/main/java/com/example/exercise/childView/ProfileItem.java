package com.example.exercise.childView;

public class ProfileItem {
    int profile_img;
    String profile_name;
    String profile_msg;

    public ProfileItem(int profile_img, String profile_name, String profile_msg) {
        this.profile_img = profile_img;
        this.profile_name = profile_name;
        this.profile_msg = profile_msg;
    }

    @Override
    public String toString() {
        return "profileItem{" +
                "profile_img=" + profile_img +
                ", profile_name='" + profile_name + '\'' +
                ", profile_msg='" + profile_msg + '\'' +
                '}';
    }
}
