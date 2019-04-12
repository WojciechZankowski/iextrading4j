package pl.zankowski.iextrading4j.client.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static final String PROPERTIES_NAME = "iextrading.properties";

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

    private void setDefaults() {
        for (final PropertyType propertyType : PropertyType.values()) {
            properties.setProperty(propertyType.name(), propertyType.getDefaultValue());
        }
    }

    public String getString(final PropertyType propertyType) {
        return properties.getProperty(propertyType.name());
    }

}
