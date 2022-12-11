package framework.utils;

import framework.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    /**
     * This method will load the properties from the config properties file based on the maven command
     */
    private ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)){
            case PROD -> properties = PropertyUtils.propertyLoader("src/test/resources/framework/properties/prod_config.properties");
            case STAGE -> properties = PropertyUtils.propertyLoader("src/test/resources/framework/properties/stage_config.properties");
            default -> throw new IllegalStateException("INVALID ENV: " + env);
        }
    }


    /**
     * This method creates the new instance of the ConfigLoader class if it has not been created yet
     * @return the instance of the ConfigLoader
     */
    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    /**
     * This method fetches the baseUrl from the loaded properties
     * @return Url
     */
    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the stage_config.properties file");
    }
}
