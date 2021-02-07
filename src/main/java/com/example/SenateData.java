package com.example;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SenateData {
    @SerializedName("objects")
    private List<Senator> senators;

    public SenateData(List<Senator> newSenators) {
        senators = newSenators;
    }

    public Senator getSenator(int senatorIndex) {
        return senators.get(senatorIndex);
    }

    public List<Senator> getSenators() {
        return senators;
    }
}
