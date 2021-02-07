package com.example;

import com.google.gson.annotations.SerializedName;

public class Senator {
    @SerializedName("person")
    private final PersonalInfo personalInfo;
    @SerializedName("startdate")
    private final String startDate;
    @SerializedName("senator_rank")
    private final String senatorRank;
    private final String party;
    private final String state;

    public Senator(String newStartDate, String newParty, String newState, PersonalInfo newPersonalInfo,
                   String newSenatorRank) {
        startDate = newStartDate;
        party = newParty;
        state = newState;
        personalInfo = newPersonalInfo;
        senatorRank = newSenatorRank;
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

    public String getSenatorRank() {
        return senatorRank;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }
}
