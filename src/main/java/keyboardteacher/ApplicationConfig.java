package keyboardteacher;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;


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
