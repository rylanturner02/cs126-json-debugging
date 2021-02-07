package com.example;

import com.google.gson.annotations.SerializedName;

public class Senator {
    @SerializedName("startDate")
    private String startdate;
    private String name;
    private String gender;
    private String birthday;
    private String state;

    public Senator() {

    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getState() {
        return state;
    }
}
