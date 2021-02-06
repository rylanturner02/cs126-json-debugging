package com.example;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/json");
        Gson gson = new Gson();
        Reader jsonReader = Files.newBufferedReader(Paths.get("senators.json"));
        SenateData senateData = gson.fromJson(jsonReader, SenateData.class);
    }
}