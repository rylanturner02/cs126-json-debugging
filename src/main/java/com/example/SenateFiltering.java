package com.example;

import java.util.List;

public class SenateFiltering {
    private final SenateData senateData;

    public SenateFiltering(SenateData newSenateData) {
        senateData = newSenateData;
    }

    public List<Senator> filterByParty(String party) {
        return senateData.getSenators();
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
