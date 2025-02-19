package com.json.practiceproblem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.util.Map;

public class MergeJsonObjects {
    public static void main(String[] args) {
        try {
            // Create an ObjectMapper instance for reading JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the first JSON file and parse it into a JsonNode
            JsonNode js1 = objectMapper.readTree(new File("C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day02\\src\\main\\java\\com\\json\\practiceproblem\\CarRead.json"));

            // Read the second JSON file and parse it into a JsonNode
            JsonNode js2 = objectMapper.readTree(new File("C:\\Users\\HP\\OneDrive\\Desktop\\Week_05\\Day02\\src\\main\\java\\com\\json\\practiceproblem\\CarRead2.json"));

            // Convert the first JsonNode to a Map
            Map<String, Object> map1 = objectMapper.convertValue(js1, Map.class);

            // Convert the second JsonNode to a Map
            Map<String, Object> map2 = objectMapper.convertValue(js2, Map.class);

            // Merge the second map into the first map
            map1.putAll(map2);

            // Convert the merged map back to a JsonNode
            JsonNode mergedJsonNode = objectMapper.valueToTree(map1);

            // Print the merged JsonNode as a JSON string
            System.out.println("Merged json files are: " + mergedJsonNode.toString());
        } catch (Exception e) {
            // Handle any exceptions that occur during the process
            e.printStackTrace();
        }
    }
}
