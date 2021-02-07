package com.example;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SenateData {
    @SerializedName("objects")
    private List<Senator> senators;
    private final Meta meta;

    public SenateData(Meta newMeta, List<Senator> newSenators) {
        meta = newMeta;
        senators = newSenators;
    }

    public Senator getSenator(int senatorIndex) {
        return senators.get(senatorIndex);
    }

    public List<Senator> getSenators() {
        return senators;
    }

    public Meta getMeta() {
        return meta;
    }
}
