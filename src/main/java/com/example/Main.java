package com.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        Reader jsonReader = Files.newBufferedReader(Paths.get("src/main/resources/senators.json"));
        SenateData senateData = gson.fromJson(jsonReader, SenateData.class);

        System.out.println(senateData.getSenator(98).getPersonalInfo().getName() + "; "
                + senateData.getSenator(98).getPersonalInfo().getBirthday());
    }
}