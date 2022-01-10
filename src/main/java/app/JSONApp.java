package app;

import domain.*;
import json.*;

import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

    public static JsonObject sessionResult() {

        JsonObject course1, course2, course3;

        course1 = new JsonObject();
        course1.add(new JsonPair("course", new JsonString("OOP")));
        course1.add(new JsonPair("mark", new JsonNumber(3)));
        course1.add(new JsonPair("passed", new JsonBoolean(true)));

        course2 = new JsonObject();
        course2.add(new JsonPair("course", new JsonString("English")));
        course2.add(new JsonPair("mark", new JsonNumber(5)));
        course2.add(new JsonPair("passed", new JsonBoolean(true)));

        course3 = new JsonObject();
        course3.add(new JsonPair("course", new JsonString("Math")));
        course3.add(new JsonPair("mark", new JsonNumber(2)));
        course3.add(new JsonPair("passed", new JsonBoolean(false)));
        JsonArray arr = new JsonArray(course1, course2, course3);

        JsonObject jsonObject = new JsonObject();
        jsonObject.add(new JsonPair("name", new JsonString("Andrii")));
        jsonObject.add(new JsonPair("surname", new JsonString("Rodionov")));
        jsonObject.add(new JsonPair("year", new JsonNumber(2)));
        jsonObject.add(new JsonPair("exams", arr));




        return jsonObject;
    }

}
