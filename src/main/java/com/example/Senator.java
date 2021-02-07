package com.example;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Senator {
    @SerializedName("startdate")
    private final String startDate;
    private final String party;
    private final String state;
    private final List<PersonalInfo> personals;

    public Senator(String newStartDate, String newParty, String newState, List<PersonalInfo> newPersonals) {
        startDate = newStartDate;
        party = newParty;
        state = newState;
        personals = newPersonals;
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

    public List<PersonalInfo> getPersonals() {
        return personals;
    }
}
