package com.example;

import java.util.List;

public class SenateData {
    private List<Senator> senators;

    public SenateData(List<Senator> newSenators) {
        senators = newSenators;
    }

    public List<Senator> getSenators() {
        return senators;
    }
}
