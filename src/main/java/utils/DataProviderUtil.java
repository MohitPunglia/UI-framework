package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataProviderUtil {

    public static Object[][] getTestData(JSONArray jsonArray, String... keys) {

        Object[][] data = new Object[jsonArray.size()][keys.length];

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject obj = (JSONObject) jsonArray.get(i);

            for (int j = 0; j < keys.length; j++) {
                data[i][j] = obj.get(keys[j]);
            }
        }

        return data;
    }
}