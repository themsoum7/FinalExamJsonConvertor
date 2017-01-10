package domain;

import json.*;

import java.security.PrivateKey;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    protected String name;
    protected String surname;
    protected Integer year;
    private Tuple<String, Integer> exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        // ToDo
        return null;
    }
}