package com.itkhanz.utils.json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class JSONUtils {

    public static HashMap<String, String> getUserCredentials(String environment) {
        try {
            // Read the JSON from the file
            FileReader reader = new FileReader("src//test//resources//test-data//users.json");
            HashMap<String,  HashMap<String, String>> userMap = new Gson().fromJson(reader, new TypeToken<HashMap<String, HashMap<String, String>>>() {}.getType());
            return userMap.get(environment);

        }catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read user credentials from users.json");
        }

    }
}
