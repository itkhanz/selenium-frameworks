package framework.utils;

import java.io.*;
import java.util.Properties;

public class PropertyUtils {
    /**
     * This method takes the filePath as an argument, and it will return the loaded properties.
     * The method is static, so it can be used without creating the instance.
     *
     * @param filePath file path of the config.properties file
     * @return loaded properties
     */
    public static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to load properties file " + filePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found at " + filePath);
        }
        return properties;

        //Alternative way of reading the file using FileInputStream
        /*try {
            properties.load(new FileInputStream(new File(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found at " + filePath);
        }*/
    }
}
