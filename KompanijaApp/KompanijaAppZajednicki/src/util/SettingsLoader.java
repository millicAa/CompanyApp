/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Milica
 */
public class SettingsLoader {

    private static SettingsLoader instance;
    
    private Properties properties;
    
    private SettingsLoader() throws FileNotFoundException, IOException {
        loadProperties();
    }
    
    public static SettingsLoader getInstance() throws IOException {
        if (instance == null) {
            instance = new SettingsLoader();
        }
        return instance;
    }
    

    private void loadProperties() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("settings.properties");
        properties = new Properties();
        properties.load(fis);
    }

    public String getValue(String key) {
        return properties.getProperty(key, "n/a");
    }

}
