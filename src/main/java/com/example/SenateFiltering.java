package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SenateFiltering {
    private static final int LATEST_YEAR_TO_BE_SENATOR = 1991;
    private static final int END_OF_YEAR_SUBSTRING = 4;
    private final SenateData senateData;

    public SenateFiltering(SenateData newSenateData) {
        senateData = newSenateData;
    }

    /**
     * Parses all parties from getParty to filter only the given party.
     *
     * @param party The given political party to filter for.
     * @return A list of references for senators of only the given party.
     */
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

    /**
     * Parses all birthdays from getBirthday to filter only the given birth year.
     *
     * @param birthYearFloor The given minimum birth year to filter for.
     * @return A list of references for senators born on or after the given year.
     */
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

    /**
     * Parses all senate classes from getSenateClass to filter only the given class.
     *
     * @param senateClass The given senate class to filter for.
     * @return A list of references for senators of only the given class.
     */
    public List<Senator> filterBySenateClass(String senateClass) {
        String[] validClasses = new String[]{"class1", "class2", "class3"};
        List<String> validClassesList = Arrays.asList(validClasses);

        if (senateClass == null || !(validClassesList.contains(senateClass))) {
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

    /**
     * Parses all state initials from getState to filter only the given state.
     *
     * @param stateInitials The given state to filter for.
     * @return A list of references for senators of only the given state.
     */
    public List<Senator> filterByState(String stateInitials) {
        String[] validInitials = new String[]{"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID",
                "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH",
                "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA",
                "WA", "WV", "WI", "WY"};
        List<String> validInitialsList = Arrays.asList(validInitials);

        if (stateInitials == null || !(validInitialsList.contains(stateInitials))) {
            throw new IllegalArgumentException();
        }

        ArrayList<Senator> stateFilteredSenators = new ArrayList<>();

        for (Senator senator : senateData.getSenators()) {
            if (senator.getState().equals(stateInitials)) {
                stateFilteredSenators.add(senator);
            }
        }

        if (stateFilteredSenators.size() > 0) {
            return stateFilteredSenators;
        }

        return null;
    }
}
