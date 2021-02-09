package com.example;

import java.util.List;

public class SenateAnalysis {
    private SenateData senateData;
    private final int END_OF_YEAR_SUBSTRING = 4;

    public SenateAnalysis(SenateData newSenateData) {
        senateData = newSenateData;
    }

    public int averageBirthYear() {
        return 1960;
    }

    public List<Senator> sortedNamesByBirthDate() {
        return senateData.getSenators();
    }

    public String mostFrequentPartyByRank(String rank) {
        return "Democrat";
    }

    public String mostFrequentClass() {
        int classIFrequency = 0, classIIFrequency = 0, classIIIFrequency = 0;

        for (Senator senator : senateData.getSenators()) {
            if (senator.getClass)
        }
    }
}
