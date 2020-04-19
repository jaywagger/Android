package com.example.exercise.recycler;

public class DTORecycler {
    private int profile_img;
    private String profile_name;

    public DTORecycler(int profile_img, String profile_name) {
        this.profile_img = profile_img;
        this.profile_name = profile_name;
    }

    public int getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(int profile_img) {
        this.profile_img = profile_img;
    }

    public String getProfile_name() {
        return profile_name;
    }

    public void setProfile_name(String profile_name) {
        this.profile_name = profile_name;
    }

    @Override
    public String toString() {
        return "DTORecycler{" +
                "profile_img=" + profile_img +
                ", profile_name='" + profile_name + '\'' +
                '}';
    }
}
