package com.example;

import java.util.List;

public class SenateAnalysis {
    private SenateData senateData;
    private final int END_OF_YEAR_SUBSTRING = 4;

    public SenateAnalysis(SenateData newSenateData) {
        senateData = newSenateData;
    }

    public int averageStartYear() {
        int sumOfStartYears = 0;

        for (Senator senator : senateData.getSenators()) {
            sumOfStartYears += Integer.parseInt(senator.getStartDate().substring(0, END_OF_YEAR_SUBSTRING));
            System.out.print(senator.getStartDate().substring(0, END_OF_YEAR_SUBSTRING) + "+");
        }

        return sumOfStartYears / senateData.getSenators().size();
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
