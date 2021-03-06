package com.example;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SenateData {
    @SerializedName("objects")
    private final List<Senator> senators;

    public SenateData(List<Senator> newSenators) {
        senators = newSenators;
    }

    public List<Senator> getSenators() {
        return senators;
    }
}