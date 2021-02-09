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
    private final int END_OF_YEAR_SUBSTRING = 4;

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

        // Checks to make sure all senators in the filtered list belong to the passed party.
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
            if (Integer.parseInt(senator.getPersonalInfo().getBirthday().substring(0, END_OF_YEAR_SUBSTRING)) < 1960) {
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
            if (Integer.parseInt(senator.getStartDate().substring(0, END_OF_YEAR_SUBSTRING)) < 2000) {
                isListWithSenatorsStartingOnOrAfterStartYear = false;
                break;
            }
        }

        assertTrue(isListWithSenatorsStartingOnOrAfterStartYear);
    }

    @Test
    public void testFilteringForSenatorStaringAtStartYearFloor() {
        boolean isListWithSenatorStartingAtStartYearFloor = false;

        // Checks for presence of Sen. Jon Ossoff, who started his term in 2021.
        for (Senator senator : senateFilter.filterByStartYearFloor(2021)) {
            if (senator.getPersonalInfo().getName().equals("Sen. Jon Ossoff [D-GA]")) {
                isListWithSenatorStartingAtStartYearFloor = true;
                break;
            }
        }

        assertTrue(isListWithSenatorStartingAtStartYearFloor);
    }

    @Test
    public void testFilteringForTooHighStartDateFloor() {
        assertEquals(new IllegalArgumentException(), senateFilter.filterByStartYearFloor(3000));
    }

    /*
     * The following section of tests evaluate the filterByState method in SenateFiltering.java.
     * 1. If a valid party name is passed, the returned List is checked for only containing senators who
     * belong to the given state.
     * 2. Any invalid state name passed should return an IllegalArgumentException.
     */

    @Test
    public void testFilteringForValidStatePass() {
        boolean isMatchToGivenState = true;

        // Checks to make sure all senators in the filtered list belong to the passed state.
        for (Senator senator : senateFilter.filterByState("IL")) {
            if (!(senator.getState().equals("IL"))) {
                isMatchToGivenState = false;
                break;
            }
        }

        assertTrue(isMatchToGivenState);
    }

    @Test
    public void testFilteringForInvalidStatePass() {
        assertEquals(new IllegalArgumentException(), senateFilter.filterByState("Quebec"));
    }

    @Test
    public void testFilteringForEmptyStatePass() {
        assertEquals(new IllegalArgumentException(), senateFilter.filterByState(""));
    }

    @Test
    public void testFilteringForNullStatePass() {
        assertEquals(new IllegalArgumentException(), senateFilter.filterByState(null));
    }
}