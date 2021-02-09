package com.example;

import java.util.ArrayList;

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

    public ArrayList<String> sortedNamesByStartDate() {
        return new ArrayList<>();
    }

    public String mostFrequentPartyByRank(String rank) {
        return "Democrat";
    }
}
