package com.example;

import java.util.ArrayList;
import java.util.List;

public class SenateFiltering {
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
        return senateData.getSenators();
    }

    public List<Senator> filterBySenateClass(String senateClass) {
        return senateData.getSenators();
    }

    public List<Senator> filterByState(String stateInitials) {
        return senateData.getSenators();
    }
}
