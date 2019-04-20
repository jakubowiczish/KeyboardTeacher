package keyboardteacher;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

/**
 * Singleton responsible for getting helping messages for user from a resource file
 */
public enum ApplicationConfig {
    INSTANCE;

    private Map<String, String> config;


    ApplicationConfig() {
        config = readConfigFromYaml();
    }


    public String getValue(String key) {
        return config.get(key);
    }


    private Map<String, String> readConfigFromYaml() {
        return new Yaml().load(
                this.getClass()
                        .getClassLoader()
                        .getResourceAsStream("application.yml")
        );
    }
}
