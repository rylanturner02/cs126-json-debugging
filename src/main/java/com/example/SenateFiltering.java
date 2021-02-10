package com.example;

import java.util.ArrayList;
import java.util.List;

public class SenateFiltering {
    private static final int LATEST_YEAR_TO_BE_SENATOR = 1991;
    private static final int END_OF_YEAR_SUBSTRING = 4;
    private final SenateData senateData;

    public SenateFiltering(SenateData newSenateData) {
        senateData = newSenateData;
    }

    public List<Senator> filterByParty(String party) {
        int MINIMUM_STRING_LENGTH = 8;

        if (party == null || party.length() < MINIMUM_STRING_LENGTH) {
            throw new IllegalArgumentException();
        }

        ArrayList<Senator> partyFilteredSenators = new ArrayList<>();

        for (Senator senator : senateData.getSenators()) {
            if (senator.getParty().equals(party)) {
                partyFilteredSenators.add(senator);
            }
        }

        if (partyFilteredSenators.size() > 0) {
            return partyFilteredSenators;
        }

        return null;
    }

    public List<Senator> filterByBirthYearFloor(int birthYearFloor) {
        if (birthYearFloor > LATEST_YEAR_TO_BE_SENATOR) {
            throw new IllegalArgumentException();
        }

        ArrayList<Senator> birthYearFilteredSenators = new ArrayList<>();

        for (Senator senator : senateData.getSenators()) {
            String birthdayString = senator.getPersonalInfo().getBirthday();
            int birthYear = Integer.parseInt(birthdayString.substring(0, END_OF_YEAR_SUBSTRING));

            if (birthYear >= birthYearFloor) {
                birthYearFilteredSenators.add(senator);
            }
        }

        if (birthYearFilteredSenators.size() > 0) {
            return birthYearFilteredSenators;
        }

        return null;
    }

    public List<Senator> filterBySenateClass(String senateClass) {
        int MINIMUM_STRING_LENGTH = 6;
        ArrayList<String> validClasses = new ArrayList<>();
        validClasses.add("class1");
        validClasses.add("class2");
        validClasses.add("class3");

        if (senateClass == null || !(validClasses.contains(senateClass))) {
            throw new IllegalArgumentException();
        }

        ArrayList<Senator> classFilteredSenators = new ArrayList<>();

        for (Senator senator : senateData.getSenators()) {
            if (senator.getSenatorClass().equals(senateClass)) {
                classFilteredSenators.add(senator);
            }
        }

        if (classFilteredSenators.size() > 0) {
            return classFilteredSenators;
        }

        return null;
    }

    public List<Senator> filterByState(String stateInitials) {
        return senateData.getSenators();
    }
}
