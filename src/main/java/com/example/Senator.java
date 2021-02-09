package com.example;

import com.google.gson.annotations.SerializedName;

public class Senator {
    @SerializedName("person")
    private final PersonalInfo personalInfo;
    @SerializedName("senator_class")
    private final String senatorClass;
    @SerializedName("senator_rank")
    private final String senatorRank;
    private final String party;
    private final String state;

    public Senator(String newSenatorClass, String newParty, String newState, PersonalInfo newPersonalInfo,
                   String newSenatorRank) {
        senatorClass = newSenatorClass;
        party = newParty;
        state = newState;
        personalInfo = newPersonalInfo;
        senatorRank = newSenatorRank;
    }

    public String getSenatorClass() {
        return senatorClass;
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