package pl.zankowski.iextrading4j.client.properties;

public enum PropertyType {

    API_REST_V1("https://api.iextrading.com/1.0"),
    API_SOCKET_V1("https://ws-api.iextrading.com/1.0");

    private final String defaultValue;

    PropertyType(final String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

}
