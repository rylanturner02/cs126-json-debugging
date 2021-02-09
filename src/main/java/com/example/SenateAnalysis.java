package com.example;

import java.util.ArrayList;
import java.util.List;

public class SenateAnalysis {
    private SenateData senateData;

    public SenateAnalysis(SenateData newSenateData) {
        senateData = newSenateData;
    }

    public int averageStartYear() {
        return 1960;
    }

    public int averageBirthYear() {
        return 1960;
    }

    public List<Senator> sortedNamesByStartDate() {
        return senateData.getSenators();
    }

    public String mostFrequentPartyByRank(String rank) {
        return "Democrat";
    }
}
