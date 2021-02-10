package com.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        Reader jsonReader = Files.newBufferedReader(Paths.get("src/main/resources/senators.json"));
        SenateData senateData = gson.fromJson(jsonReader, SenateData.class);

        System.out.println("Choose 'analysis' or 'filtering': ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.equals("analysis")) {
            toAnalysisFunctions(senateData);
        } else if (input.equals("filtering")) {
            toFilteringFunctions(senateData);
        } else {
            System.out.println("Invalid answer.");
        }
    }

    /**
     * Introduces user-input choices for showcasing analysis functions.
     */
    public static void toAnalysisFunctions(SenateData senateData) {
        SenateAnalysis senateAnalysis = new SenateAnalysis(senateData);

        System.out.println("Choose 'averageBirthYear', 'mostFrequentParty',"
                + "'mostFrequentPartyByRank', or 'mostFrequentClass': ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        switch (input) {
            case "averageBirthYear":
                System.out.println(senateAnalysis.averageBirthYear());
                break;
            case "mostFrequentParty":
                System.out.println(senateAnalysis.mostFrequentParty());
                break;
            case "mostFrequentPartyByRank":
                String parameterRankInput = scan.nextLine();

                System.out.println(senateAnalysis.mostFrequentPartyByRank(parameterRankInput));
                break;
            case "mostFrequentClass":
                System.out.println(senateAnalysis.mostFrequentClass());
                break;
            default:
                System.out.println("Invalid answer.");
                break;
        }
    }

    /**
     * Introduces user-input options for filtering functions.
     */
    public static void toFilteringFunctions(SenateData senateData) {
        SenateFiltering senateFiltering = new SenateFiltering(senateData);

        System.out.println("Choose 'filterByParty', 'filterByBirthYearFloor',"
                + "'filterBySenateClass', or 'filterByState': ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        switch (input) {
            case "filterByParty":
                String parameterPartyInput = scan.nextLine();

                System.out.println(senateFiltering.filterByParty(parameterPartyInput));
                break;
            case "filterByBirthYearFloor":
                int parameterBirthYearInput = scan.nextInt();

                System.out.println(senateFiltering.filterByBirthYearFloor(parameterBirthYearInput));
                break;
            case "filterBySenateClass":
                String parameterSenateClassInput = scan.nextLine();

                System.out.println(senateFiltering.filterBySenateClass(parameterSenateClassInput));
                break;
            case "filterByState":
                String parameterStateInput = scan.nextLine();

                System.out.println(senateFiltering.filterByState(parameterStateInput));
                break;
            default:
                System.out.println("Invalid answer.");
                break;
        }
    }
}