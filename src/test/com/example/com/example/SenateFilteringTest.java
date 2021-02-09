package com.example;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

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
    public boolean isListOfSenatorsOfGivenParty(String party) {
        boolean isMatchToGivenParty = true;

        for (Senator senator : senateFilter.filterByParty(party)) {
            if (!(senator.getParty().equals(party))) {
                isMatchToGivenParty = false;
                break;
            }
        }

        return isMatchToGivenParty;
    }

    @Test
    public void testFilteringForDemocratPass() {
        assertTrue(isListOfSenatorsOfGivenParty("Democrat"));
    }

    @Test
    public void testFilteringForRepublicanPass() {
        assertTrue(isListOfSenatorsOfGivenParty("Republican"));
    }

    @Test
    public void testFilteringForIndependentPass() {
        assertTrue(isListOfSenatorsOfGivenParty("Independent"));
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
     * The following section of tests evaluate the filterByBirthYearFloor method in SenateFiltering.java.
     * 1. If a valid party name is passed, the returned List is checked for only containing senators born
     * on or after the passed year.
     * 2. Any invalid birth year passed should return an IllegalArgumentException.
     */

    @Test
    public void testFilteringForValidBirthYearFloor() {
        boolean isListWithSenatorsBornOnOrAfterBirthYear = true;

        // Checks for at least one instance of senator in list born before the given year.
        for (Senator senator : senateFilter.filterByBirthYearFloor(1960)) {
            if (Integer.parseInt(senator.getPersonalInfo().getBirthday().substring(0,5)) < 1960) {
                isListWithSenatorsBornOnOrAfterBirthYear = false;
                break;
            }
        }

        assertTrue(isListWithSenatorsBornOnOrAfterBirthYear);
    }

    @Test
    public void testFilteringForSenatorBornAtBirthYearFloor() {
        boolean isListWithSenatorBornAtBirthYearFloor = false;

        // Checks for presence of Sen. Jon Ossoff, who was born during 1987.
        for (Senator senator : senateFilter.filterByBirthYearFloor(1987)) {
            if (senator.getPersonalInfo().getName().equals("Sen. Jon Ossoff [D-GA]")) {
                isListWithSenatorBornAtBirthYearFloor = true;
                break;
            }
        }

        assertTrue(isListWithSenatorBornAtBirthYearFloor);
    }

    @Test
    public void testFilteringForTooHighBirthYearFloor() {
        assertEquals(new IllegalArgumentException(), senateFilter.filterByBirthYearFloor(3000));
    }

    /*
     * The following section of tests evaluate the filterByStartYearFloor method in SenateFiltering.java.
     * 1. If a valid party name is passed, the returned List is checked for only containing senators who
     * started their congressional term on or before the passed year.
     * 2. Any invalid start year passed should return an IllegalArgumentException.
     */

    @Test
    public void testFilteringForValidStartDateFloor() {
        boolean isListWithSenatorsStartingOnOrAfterStartYear = true;

        // Checks for at least one instance of senator in list who started their term before the given year.
        for (Senator senator : senateFilter.filterByStartYearFloor(2000)) {
            if (Integer.parseInt(senator.getStartDate().substring(0,5)) < 2000) {
                isListWithSenatorsStartingOnOrAfterStartYear = false;
                break;
            }
        }

        assertTrue(isListWithSenatorsStartingOnOrAfterStartYear);
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
    public void testFilteringForEmptyStatePass() {

    }

    @Test
    public void testFilteringForNullStatePass() {

    }
}