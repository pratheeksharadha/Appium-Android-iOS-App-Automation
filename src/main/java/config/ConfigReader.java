
package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigReader {

    private final Properties properties = new Properties();

    public ConfigReader(String filePath) {

        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException(
                    "Configuration file path cannot be null or blank."
            );
        }

        try (FileInputStream inputStream = new FileInputStream(filePath)) {

            properties.load(inputStream);

        } catch (IOException e) {

            throw new IllegalStateException(
                    "Unable to load configuration file: " + filePath,
                    e
            );
        }
    }

    public String getProperty(String key) {

        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException(
                    "Configuration property key cannot be null or blank."
            );
        }

        return properties.getProperty(key);
    }
}
