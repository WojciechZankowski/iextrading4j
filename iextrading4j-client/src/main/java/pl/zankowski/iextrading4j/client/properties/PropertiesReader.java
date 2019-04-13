package pl.zankowski.iextrading4j.client.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static final String PROPERTIES_NAME = "iextrading.properties";

    private static final PropertiesReader INSTANCE = new PropertiesReader();

    private final Properties properties = new Properties();

    public PropertiesReader() {
        setDefaults();
        try (InputStream propertiesStream = PropertiesReader.class.getClassLoader()
                .getResourceAsStream(PROPERTIES_NAME)) {
            if (propertiesStream != null) {
                properties.load(propertiesStream);
            }
        } catch (IOException e1) {
            // Whatever, we have defaults
        }
    }

    public static PropertiesReader getInstance() {
        return INSTANCE;
    }

    private void setDefaults() {
        for (final PropertyType propertyType : PropertyType.values()) {
            properties.setProperty(propertyType.name(), propertyType.getDefaultValue());
        }
    }

    public String getString(final PropertyType propertyType) {
        return properties.getProperty(propertyType.name());
    }

    public Boolean getBoolean(final PropertyType propertyType) {
        return Boolean.valueOf(getString(propertyType));
    }

}
