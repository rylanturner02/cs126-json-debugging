package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SenateAnalysisTest {
    private SenateAnalysis senateAnalysis;

    /**
     * Sets up senateData exactly like in Main.java and instantiates senateAnalysis.
     * @throws IOException for Files.newBufferedReader().
     */
    @Before
    public void setUp() throws IOException {
        Gson gson = new Gson();
        Reader jsonReader = Files.newBufferedReader(Paths.get("src/main/resources/senators.json"));
        SenateData senateData = gson.fromJson(jsonReader, SenateData.class);
        senateAnalysis = new SenateAnalysis(senateData);
    }

    // ...

    @Test
    public void testAnalysisForCorrectAverageStartYear() {

    }

    // ...

    @Test
    public void testAnalysisForCorrectAverageBirthYear() {

    }

    // ...

    @Test
    public void testAnalysisForCorrectSortedListByStartDate() {

    }

    // ...

    @Test
    public void testAnalysisForCorrectHighestFrequencyPartyGivenJuniorRank() {

    }

    @Test
    public void testAnalysisForCorrectHighestFrequencyPartyGivenSeniorRank() {

    }
}
