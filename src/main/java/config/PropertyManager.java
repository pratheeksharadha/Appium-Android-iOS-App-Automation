
package config;

import constants.FrameworkConstants;

public final class PropertyManager {

    private static ConfigReader configReader;
    private static ConfigReader environmentReader;
    private static ConfigReader deviceReader;
    private static ConfigReader sauceReader;

    private static String environment;
    private static String platform;
    private static String execution;

    static {
        loadProperties();
    }

    private PropertyManager() {
    }

    private static void loadProperties() {

        configReader = new ConfigReader(FrameworkConstants.CONFIG_PATH);

        environment = requireProperty(
                configReader, "environment", "config.properties"
        );

        platform = requireProperty(
                configReader, "platform", "config.properties"
        );

        execution = requireProperty(
                configReader, "execution", "config.properties"
        );

        validateConfiguration();

        environmentReader = new ConfigReader(
                FrameworkConstants.CONFIG_FOLDER + environment + ".properties"
        );

        deviceReader = new ConfigReader(
                FrameworkConstants.CONFIG_FOLDER + platform + ".properties"
        );

        if ("sauce".equalsIgnoreCase(execution)) {
            sauceReader = new ConfigReader(
                    FrameworkConstants.CONFIG_FOLDER + "sauce.properties"
            );
        }
    }

    private static void validateConfiguration() {

        if (!"local".equalsIgnoreCase(execution)
                && !"sauce".equalsIgnoreCase(execution)) {
            throw new IllegalArgumentException(
                    "Unsupported execution type: " + execution
            );
        }

        if (!"Android".equalsIgnoreCase(platform)
                && !"iOS".equalsIgnoreCase(platform)) {
            throw new IllegalArgumentException(
                    "Unsupported platform: " + platform
            );
        }

        if ("local".equalsIgnoreCase(execution)
                && "iOS".equalsIgnoreCase(platform)) {
            throw new UnsupportedOperationException(
                    "Local iOS execution is not supported in the current "
                            + "Windows environment. Use Sauce Labs."
            );
        }

        if (environment.isBlank()) {
            throw new IllegalStateException(
                    "Environment cannot be blank."
            );
        }
    }

    public static String getConfig(String key) {
        return requireProperty(configReader, key, "config.properties");
    }

    public static String getEnvironment(String key) {
        return requireProperty(
                environmentReader, key, environment + ".properties"
        );
    }

    public static String getDevice(String key) {
        return requireProperty(
                deviceReader, key, platform + ".properties"
        );
    }

    public static String getSauce(String key) {

        if (sauceReader == null) {
            throw new IllegalStateException(
                    "Sauce configuration is unavailable. "
                            + "Current execution mode: " + execution
            );
        }

        return requireProperty(sauceReader, key, "sauce.properties");
    }

    private static String requireProperty(
            ConfigReader reader,
            String key,
            String fileName
    ) {

        if (reader == null) {
            throw new IllegalStateException(
                    "Configuration reader is not initialized for " + fileName
            );
        }

        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException(
                    "Configuration property key cannot be blank."
            );
        }

        String value = reader.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Missing or empty configuration property: "
                            + key + " in " + fileName
            );
        }

        return value.trim();
    }
}
