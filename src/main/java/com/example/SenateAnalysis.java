package com.example;

import java.util.Collections;
import java.util.HashMap;

public class SenateAnalysis {
    private final SenateData senateData;

    public SenateAnalysis(SenateData newSenateData) {
        senateData = newSenateData;
    }

    public int averageBirthYear() {
        int totalSumOfBirthYears = 0;

        for (Senator senator : senateData.getSenators()) {
            int END_OF_YEAR_SUBSTRING = 4;
            totalSumOfBirthYears += Integer.parseInt(senator.getPersonalInfo().getBirthday()
                    .substring(0, END_OF_YEAR_SUBSTRING));
        }

        return totalSumOfBirthYears / senateData.getSenators().size();
    }

    public String mostFrequentParty() {
        HashMap<String, Integer> partyFrequency = new HashMap<>();

        for (Senator senator : senateData.getSenators()) {
            partyFrequency.put(senator.getParty(),
                    partyFrequency.getOrDefault(senator.getParty(), 0) + 1);
        }

        // code below cited from:
        // https://stackoverflow.com/questions/5911174/finding-key-associated-with-max-value-in-a-java-map
        return Collections.max(partyFrequency.entrySet(), HashMap.Entry.comparingByValue()).getKey();
    }

    public String mostFrequentPartyByRank(String rank) {
        HashMap<String, Integer> partyFrequencyByRank = new HashMap<>();

        for (Senator senator : senateData.getSenators()) {
            if (senator.getSenatorRank().equals(rank)) {
                partyFrequencyByRank.put(senator.getParty(),
                        partyFrequencyByRank.getOrDefault(senator.getParty(), 0) + 1);
            }
        }

        // code below cited from:
        // https://stackoverflow.com/questions/5911174/finding-key-associated-with-max-value-in-a-java-map
        return Collections.max(partyFrequencyByRank.entrySet(), HashMap.Entry.comparingByValue()).getKey();
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
