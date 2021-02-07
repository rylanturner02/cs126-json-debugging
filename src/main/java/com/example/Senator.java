package com.example;

import com.google.gson.annotations.SerializedName;

public class Senator {
    @SerializedName("startdate")
    private final String startDate;
    private final String name;
    private final String gender;
    private final String birthday;
    private final String state;

    public Senator(String newStartDate, String newName, String newGender, String newBirthday, String newState) {
        startDate = newStartDate;
        name = newName;
        gender = newGender;
        birthday = newBirthday;
        state = newState;
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

    public String getStartDate() {
        return startDate;
    }

    public String getState() {
        return state;
    }
}
