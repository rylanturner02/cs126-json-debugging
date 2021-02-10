package com.example;

import com.google.gson.annotations.SerializedName;

public class Senator implements Comparable {
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

    public int numericizeBirthdayString(Senator senator) {
        return Integer.parseInt(senator.getPersonalInfo().getBirthday().substring(0, 4)
                + senator.getPersonalInfo().getBirthday().substring(5, 7)
                + senator.getPersonalInfo().getBirthday().substring(8));
    }

    @Override
    public int compareTo(Object comparedObject) {
        if (!(comparedObject instanceof Senator)) {
            throw new IllegalArgumentException();
        }

        int thisNumericizedBirthday = numericizeBirthdayString(this);
        int otherNumericizedBirthday = numericizeBirthdayString((Senator) comparedObject);

        return Integer.compare(thisNumericizedBirthday, otherNumericizedBirthday);
    }
}