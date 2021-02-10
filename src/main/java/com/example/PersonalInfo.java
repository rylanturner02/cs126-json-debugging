package com.example;

public class PersonalInfo {
    private final String name;
    private final String birthday;

    public PersonalInfo(String newName, String newBirthday) {
        name = newName;
        birthday = newBirthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }
}