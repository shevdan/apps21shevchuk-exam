package domain;

import json.*;

import java.util.Arrays;
import java.util.List;


/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private List<Tuple<String, Integer>> exam;

    public Student(String name, String surname, Integer year,
                   Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exam = Arrays.asList(exams);

    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject json = super.toJsonObject();
        JsonObject[] exams = new JsonObject[exam.size()];
        for (int i = 0; i < exam.size(); i++) {
            Tuple<String, Integer> tuple = exam.get(i);
            exams[i] = new JsonObject();
            exams[i].add(new JsonPair("course", new JsonString(tuple.key)));
            exams[i].add(new JsonPair("mark", new JsonNumber(tuple.value)));
            exams[i].add(new JsonPair("passed",
                    new JsonBoolean(tuple.value > 2)));
        }
        json.add(new JsonPair("exams", new JsonArray(exams)));


        return json;
    }

}