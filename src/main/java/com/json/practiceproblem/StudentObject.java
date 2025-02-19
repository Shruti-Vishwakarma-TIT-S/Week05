package com.json.practiceproblem;

import org.json.JSONObject;
import org.json.JSONArray;

public class StudentObject {
    public static void main(String[] args) {
        // Creating a JSONArray to store the subjects
        JSONArray subject = new JSONArray();
        subject.put("Mathematics");
        subject.put("Hindi");
        subject.put("English");
        subject.put("Biology");

        // Creating a JSONObject to store student details
        JSONObject user = new JSONObject();

        // Adding name to the JSON object
        user.put("Name", "Dhani");

        // Adding age to the JSON object
        user.put("Age", "22");

        // Adding subjects array to the JSON object
        user.put("Subjects", subject);

        // Printing the JSON object with indentation for readability
        System.out.println(user.toString(3));
    }
}
