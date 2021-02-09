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
}
