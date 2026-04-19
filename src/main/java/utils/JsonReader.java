package utils;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonReader {

    public static JSONArray getJsonData() {
        try {
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader(
                    System.getProperty("user.dir") + "/src/test/java/resources/testdata/loginData.json"));

            return (JSONArray) obj;

        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }
}