package com.example;

import java.util.Collections;
import java.util.HashMap;

public class SenateAnalysis {
    private final SenateData senateData;

    public SenateAnalysis(SenateData newSenateData) {
        senateData = newSenateData;
    }

    /**
     * Parses all senator birth years from getBirthday to find average birth year.
     *
     * @return Average birth year, truncated.
     */
    public int averageBirthYear() {
        int totalSumOfBirthYears = 0;

        for (Senator senator : senateData.getSenators()) {
            // Due to birthday being formatted as YEAR-MONTH-DAY, the year can be parsed using substring(0, 4).
            int END_OF_YEAR_SUBSTRING = 4;
            totalSumOfBirthYears += Integer.parseInt(senator.getPersonalInfo().getBirthday()
                    .substring(0, END_OF_YEAR_SUBSTRING));
        }

        return totalSumOfBirthYears / senateData.getSenators().size();
    }

    /**
     * Parses all parties from getParty to find most frequent political party.
     *
     * @return The most frequent political party in Senate.
     */
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

    /**
     * Parses all ranks from getSenatorRank to find most frequent.
     *
     * @param rank The specified rank, in form of "classX".
     * @return The most frequent rank of senator.
     */
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

    /**
     * Parses all classes from getClass to find most frequent.
     *
     * @return The most frequent class of senator.
     */
    public String mostFrequentClass() {
        HashMap<String, Integer> classFrequency = new HashMap<>();

        for (Senator senator : senateData.getSenators()) {
            classFrequency.put(senator.getSenatorClass(),
                    classFrequency.getOrDefault(senator.getSenatorClass(), 0) + 1);
        }

        // code below cited from:
        // https://stackoverflow.com/questions/5911174/finding-key-associated-with-max-value-in-a-java-map
        return Collections.max(classFrequency.entrySet(), HashMap.Entry.comparingByValue()).getKey();
    }
}
