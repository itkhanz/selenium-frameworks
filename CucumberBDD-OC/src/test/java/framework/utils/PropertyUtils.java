package framework.utils;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

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

    /**
     * This method accepts the location of the POM.xml file and returns the Maven properties defined in POM
     *
     * @param filePath location of the POM.xml file
     * @return Properties object from Maven POM.xml file
     * @throws IOException
     * @throws XmlPullParserException
     */
    public static Properties mavenPropsLoader(String filePath) throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader(filePath));
        /*System.out.println(model.getId());
        System.out.println(model.getGroupId());
        System.out.println(model.getArtifactId());
        System.out.println(model.getVersion());*/
        return model.getProperties();
    }
}
