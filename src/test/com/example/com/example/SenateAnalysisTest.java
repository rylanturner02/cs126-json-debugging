package com.example;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

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

    /**
     * Test case examines accuracy of averageStartYear method in SenateAnalysis.
     */
    @Test
    public void testAnalysisForCorrectMostFrequentClass() {
        assertEquals("class3", senateAnalysis.mostFrequentClass());
    }

    /**
     * Test case examines accuracy of averageBirthYear method in SenateAnalysis.
     */
    @Test
    public void testAnalysisForCorrectAverageBirthYear() {
        assertEquals(1956, senateAnalysis.averageBirthYear());
    }

    /**
     * Test case examines accuracy of list produced by mostFrequentParty method in SenateAnalysis.
     */
    @Test
    public void testAnalysisForCorrectMostFrequentParty() {
        assertEquals("Republican", senateAnalysis.mostFrequentParty());
    }

    /**
     * Test case examines accuracy of party returned by mostFrequentPartyByRank method in SenateAnalysis.
     */
    @Test
    public void testAnalysisForCorrectHighestFrequencyPartyGivenJuniorRank() {
        assertEquals("Republican", senateAnalysis.mostFrequentPartyByRank("junior"));
    }

    @Test
    public void testAnalysisForCorrectHighestFrequencyPartyGivenSeniorRank() {
        assertEquals("Democrat", senateAnalysis.mostFrequentPartyByRank("senior"));
    }
}
