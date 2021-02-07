package com.example;

import java.util.List;

public class SenateData {
    private final List<Senator> senators;

    public SenateData(List<Senator> newSenators) {
        senators = newSenators;
    }

    public Senator getSenator(int senatorIndex) {
        return senators.get(senatorIndex);
    }
}
