package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties prop = new Properties();

    public ConfigReader(String filePath){
        try(FileInputStream fis = new FileInputStream(filePath)){
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProperty(String key){
        return prop.getProperty(key);
    }

}
