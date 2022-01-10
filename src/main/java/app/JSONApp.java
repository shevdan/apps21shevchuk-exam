package app;

import domain.BasicStudent;
import json.*; 

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
        print(jsonObj);
        // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks"));
        // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject());
        // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

    public static JsonObject sessionResult() {

        JsonObject firstCourse, secondCourse, thirdCourse;

        firstCourse = new JsonObject();
        firstCourse.add(new JsonPair("course",
                new JsonString("OOP")));
        firstCourse.add(new JsonPair("mark",
                new JsonNumber(3)));
        firstCourse.add(new JsonPair("passed",
                new JsonBoolean(true)));

        secondCourse = new JsonObject();
        secondCourse.add(new JsonPair("course",
                new JsonString("English")));
        secondCourse.add(new JsonPair("mark",
                new JsonNumber(5)));
        secondCourse.add(new JsonPair("passed",
                new JsonBoolean(true)));

        thirdCourse = new JsonObject();
        thirdCourse.add(new JsonPair("course",
                new JsonString("Math")));
        thirdCourse.add(new JsonPair("mark",
                new JsonNumber(2)));
        thirdCourse.add(new JsonPair("passed",
                new JsonBoolean(false)));
        JsonArray arr = new JsonArray(firstCourse,
                secondCourse, thirdCourse);

        JsonObject jsonObject = new JsonObject();
        jsonObject.add(new JsonPair("name",
                new JsonString("Andrii")));
        jsonObject.add(new JsonPair("surname",
                new JsonString("Rodionov")));
        jsonObject.add(new JsonPair("year",
                new JsonNumber(2)));
        jsonObject.add(new JsonPair("exams", arr));




        return jsonObject;
    }

}
