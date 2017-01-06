package org.sri.app.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sridhar.easwaran on 12/28/2016.
 */

public class configReader {

    static Yaml yaml = new Yaml();

    static InputStream baseConfig_IS = null;
    static InputStream envConfig_IS = null;
    static InputStream androidConfig_IS = null;
    static InputStream iOSConfig_IS = null;

    public static Map<String, String> baseConfig_data = new HashMap<>();
    public static Map<String, String> android_data = new HashMap<>();
    public static Map<String, String> iOS_data = new HashMap<>();
    public static Map<String, HashMap<String, String>> envConfig_data = new HashMap<String, HashMap<String, String>>();

    public static Map<String, String> current_Env_Data = new HashMap<>();

    public static String currentEnv = null;

    public static void initConfigReader() {
        try {

            baseConfig_IS = configReader.class.getResourceAsStream("/config/baseConfig.yml");
            envConfig_IS = configReader.class.getResourceAsStream("/config/envConfig.yml");
            androidConfig_IS = configReader.class.getResourceAsStream("/config/androidConfig.yml");
            iOSConfig_IS = configReader.class.getResourceAsStream("/config/iOSConfig.yml");

        } catch (Exception e) {
            e.printStackTrace();
        }

        android_data = (HashMap<String, String>) yaml.load(androidConfig_IS);
        iOS_data = (HashMap<String, String>) yaml.load(iOSConfig_IS);
        baseConfig_data = (HashMap<String, String>) yaml.load(baseConfig_IS);
        envConfig_data = (HashMap<String, HashMap<String, String>>) yaml.load(envConfig_IS);
        currentEnv = baseConfig_data.get("TestEnvironment");

        /** get the current ENV details in to HashMap */
        current_Env_Data = envConfig_data.get(currentEnv);
    }

    public HashMap<String, String> getBaseConfig_data() {
        return (HashMap<String, String>) baseConfig_data;
    }

    public HashMap<String, String> getCurrent_Env_Data() {
        return (HashMap<String, String>) current_Env_Data;
    }

    public HashMap<String, String> getAndroid_Data() {
        return (HashMap<String, String>) android_data;
    }

    public HashMap<String, String> getIOS_Data() {
        return (HashMap<String, String>) iOS_data;
    }

}
