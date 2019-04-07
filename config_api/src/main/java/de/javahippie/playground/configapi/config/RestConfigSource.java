package de.javahippie.playground.configapi.config;

import org.eclipse.microprofile.config.spi.ConfigSource;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class RestConfigSource implements ConfigSource {

    public static final String CONFIG_SOURCE_NAME = "RestConfigSource";

    private final Map<String, String> properties = new HashMap<>();

    public void updateProperty(String propertyKey, String propertyValue) {
        this.properties.put(propertyKey, propertyValue);
    }

    @Override
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public String getValue(String propertyName) {
        return properties.get(propertyName);
    }

    @Override
    public String getName() {
        return CONFIG_SOURCE_NAME;
    }

    @Override
    public int getOrdinal() {
        return 401;
    }
}
