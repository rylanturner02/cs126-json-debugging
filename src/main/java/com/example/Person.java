package com.example;

public class Person {
    private final String name;
    private final String gender;
    private final String birthday;

    public Person(String newName, String newGender, String newBirthday) {
        name = newName;
        gender = newGender;
        birthday = newBirthday;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }
}
