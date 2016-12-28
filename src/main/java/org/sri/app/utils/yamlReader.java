package org.sri.app.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sridhar.easwaran on 12/28/2016.
 */

public class yamlReader {
    Yaml yaml = new Yaml();
    InputStream baseConfig_IS = null;
    InputStream envConfig_IS = null;
    Map<String, String> baseConfig_data = new HashMap<String, String>();
    Map<String, HashMap<String, String>> envConfig_data = new HashMap<String, HashMap<String, String>>();

    public HashMap<String, String> currentEnv_data = new HashMap<String, String>();
    public String currentEnv = null;

    public yamlReader() {
        try {
            baseConfig_IS = yamlReader.class.getResourceAsStream("/config/baseConfig.yml");
            envConfig_IS = yamlReader.class.getResourceAsStream("/config/envConfig.yml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        baseConfig_data = (HashMap<String, String>) yaml.load(baseConfig_IS);
        envConfig_data = (HashMap<String, HashMap<String, String>>) yaml.load(envConfig_IS);
        currentEnv = baseConfig_data.get("TestEnvironment");

        /** get the current ENV details in to HashMap */
        for (Map.Entry<String, HashMap<String, String>> data : envConfig_data.entrySet()) {
            if(data.getKey().equals(currentEnv))
                currentEnv_data=data.getValue();
        }

    }

    public HashMap<String, String> getBaseConfig_data() {
        return (HashMap<String, String>) baseConfig_data;
    }

    public HashMap<String, HashMap<String, String>> getEnvConfig_data() {
        return (HashMap<String, HashMap<String, String>>) envConfig_data;
    }

}
