package domain;

import json.*;

import java.util.Arrays;
import java.util.List;


/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    protected List<Tuple<String, Integer>> exam;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exam = Arrays.asList(exams);

    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject json = super.toJsonObject();
        JsonObject[] exams = new JsonObject[exam.size()];
        for (int i = 0; i < exam.size(); i++) {
            Tuple<String, Integer> tuple = exam.get(i);
            exams[i] = createJsonObj(tuple.key, tuple.value);
        }
        json.add(new JsonPair("exams", new JsonArray(exams)));


        return json;
    }

    private JsonObject createJsonObj(String name, Integer mark) {
        JsonObject obj = new JsonObject();
        obj.add(new JsonPair("course", new JsonString(name)));
        obj.add(new JsonPair("mark", new JsonNumber(mark)));
        obj.add(new JsonPair("passed", new JsonBoolean(mark > 2)));

        return obj;

    }
}