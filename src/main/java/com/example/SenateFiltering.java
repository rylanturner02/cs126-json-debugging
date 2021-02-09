package com.example;

import java.util.List;

public class SenateFiltering {
    private SenateData senateData;

    public SenateFiltering(SenateData newSenateData) {
        senateData = newSenateData;
    }

    public List<Senator> filterByParty(String party) {
        return senateData.getSenators();
    }

    public List<Senator> filterByBirthYearFloor(int i) {
        return senateData.getSenators();
    }
}
