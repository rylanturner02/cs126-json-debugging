package com.example;

import com.google.gson.annotations.SerializedName;

public class Senator {
    @SerializedName("startdate")
    private final String startDate;
    private final String party;
    private final String state;

    public Senator(String newStartDate, String newParty, String newState) {
        startDate = newStartDate;
        party = newParty;
        state = newState;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getParty() {
        return party;
    }

    public String getState() {
        return state;
    }
}
