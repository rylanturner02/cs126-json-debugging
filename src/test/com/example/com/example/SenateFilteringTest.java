package com.example;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SenateFilteringTest {
    private SenateFiltering senateFilter;

    /**
     * Sets up senateData exactly like in Main.java and instantiates senateFiltering.
     * @throws IOException for Files.newBufferedReader().
     */
    @Before
    public void setUp() throws IOException {
        Gson gson = new Gson();
        Reader jsonReader = Files.newBufferedReader(Paths.get("src/main/resources/senators.json"));
        SenateData senateData = gson.fromJson(jsonReader, SenateData.class);
        senateFilter = new SenateFiltering(senateData);
    }

    /*
     * The following section of tests evaluate the filterByParty method in SenateFiltering.java.
     * 1. If a valid party name is passed, the returned List is checked for only containing senators
     * of the given party.
     * 2. Any invalid party passed should return an IllegalArgumentException.
     */

    /**
     * @param party A valid party that a senator could be registered under.
     * @return isMatchToGivenParty True if returned List only contains passed party and False otherwise.
     */
    public boolean isListOfSenatorsOfGivenParty(List<Senator> filteredSenators, String party) {
        boolean isMatchToGivenParty = true;

        for (Senator senator : filteredSenators) {
            if (!(senator.getParty().equals(party))) {
                isMatchToGivenParty = false;
                break;
            }
        }

        return isMatchToGivenParty;
    }

    @Test
    public void testFilteringForDemocratPass() {
        assertTrue(isListOfSenatorsOfGivenParty(senateFilter.filterByParty("Democrat"), "Democrat"));
    }

    @Test
    public void testFilteringForRepublicanPass() {
        assertTrue(isListOfSenatorsOfGivenParty(senateFilter.filterByParty("Republican"), "Republican"));
    }

    @Test
    public void testFilteringForIndependentPass() {
        assertTrue(isListOfSenatorsOfGivenParty(senateFilter.filterByParty("Independent"), "Independent"));
    }

    @Test
    public void testFilteringForInvalidPartyPass() {
        assertEquals(new IllegalArgumentException(), senateFilter.filterByParty("Bull-moose"));
    }

    @Test
    public void testFilteringForEmptyStringPartyPass() {
        assertEquals(new IllegalArgumentException(), senateFilter.filterByParty(""));
    }

    @Test
    public void testFilteringForNullPartyPass() {
        assertEquals(new IllegalArgumentException(), senateFilter.filterByParty(null));
    }

    /*
     * The following section of tests evaluate the filterAfterBirthYear method in SenateFiltering.java.
     * 1. If a valid party name is passed, the returned List is checked for only containing senators born
     * after the passed birth year.
     * 2. Any invalid birth year passed should return an IllegalArgumentException.
     */

    public boolean isListOfSenatorsAfterGivenBirthYear(String birthYear) {
        return true;
    }

    @Test
    public void testFilteringForValidBirthYearFloor() {

    }

    @Test
    public void testFilteringForTooHighBirthYearFloor() {

    }

    @Test
    public void testFilteringForInvalidBirthYearFloorPass() {

    }

    @Test
    public void testFilteringForEmptyStringBirthYearFloor() {

    }

    @Test
    public void testFilteringForNullBirthYearFloor() {

    }

    // ...

    @Test
    public void testFilteringForValidStartDateFloor() {

    }

    @Test
    public void testFilteringForTooHighStartDateFloor() {

    }

    @Test
    public void testFilteringForInvalidStartDateFloorPass() {

    }

    @Test
    public void testFilteringForEmptyStringStartDateFloor() {

    }

    @Test
    public void testFilteringForNullStartDateFloor() {

    }

    // ...

    @Test
    public void testFilteringForValidStatePass() {

    }

    @Test
    public void testFilteringForInvalidStatePass() {

    }

    @Test
    public void testFilteringForNonStringStatePass() {

    }

    @Test
    public void testFileringForEmptyStatePass() {

    }

    @Test
    public void testFilteringForNullStatePass() {

    }
}