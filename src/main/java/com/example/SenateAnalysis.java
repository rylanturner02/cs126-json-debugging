package com.example;

import java.util.ArrayList;
import java.util.List;

public class SenateAnalysis {
    private SenateData senateData;
    private final int END_OF_YEAR_SUBSTRING = 4;

    public SenateAnalysis(SenateData newSenateData) {
        senateData = newSenateData;
    }

    public int averageBirthYear() {
        int totalSumOfBirthYears = 0;

        for (Senator senator : senateData.getSenators()) {
            totalSumOfBirthYears += Integer.parseInt(senator.getPersonalInfo().getBirthday()
                    .substring(0, END_OF_YEAR_SUBSTRING));
        }

        return totalSumOfBirthYears / senateData.getSenators().size();
    }

    public List<Senator> sortedNamesByBirthDate() {
        // work on it later
        return senateData.getSenators();
    }

    public String mostFrequentPartyByRank(String rank) {
        int democratCount = 0, republicanCount = 0, independentCount = 0;

        for (Senator senator : senateData.getSenators()) {
            if (senator.getSenatorRank().equals(rank)) {
                switch (senator.getParty()) {
                    case "Democrat":
                        democratCount++;
                        break;
                    case "Republican":
                        republicanCount++;
                        break;
                    case "Independent":
                        independentCount++;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }

        if (democratCount > republicanCount && democratCount > independentCount) {
            return "Democrat";
        } else if (republicanCount > democratCount && republicanCount > independentCount) {
            return "Republican";
        } else if (independentCount > democratCount && independentCount > republicanCount) {
            return "Independent";
        } else {
            return "No most frequent party for rank: " + rank;
        }
    }

    public String mostFrequentClass() {
        int classIFrequency = 0, classIIFrequency = 0, classIIIFrequency = 0;

        for (Senator senator : senateData.getSenators()) {
            switch (senator.getSenatorClass()) {
                case "class1":
                    classIFrequency++;
                    break;
                case "class2":
                    classIIFrequency++;
                    break;
                case "class3":
                    classIIIFrequency++;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        if (classIFrequency > classIIFrequency && classIFrequency > classIIIFrequency) {
            return "Class I";
        } else if (classIIFrequency > classIFrequency && classIIFrequency > classIIIFrequency) {
            return "Class II";
        } else if (classIIIFrequency > classIFrequency && classIIIFrequency > classIIFrequency) {
            return "Class III";
        } else {
            return "No most frequent class.";
        }
    }
}
