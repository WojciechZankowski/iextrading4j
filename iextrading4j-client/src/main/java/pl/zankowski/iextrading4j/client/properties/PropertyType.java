package pl.zankowski.iextrading4j.client.properties;

public enum PropertyType {

    API_REST_V1("https://api.iextrading.com/1.0"),
    API_REST_V2("https://cloud.iexapis.com/beta"),
    API_REST_V2_SANDBOX("https://sandbox.iexapis.com"),
    API_SOCKET_V1("https://ws-api.iextrading.com/1.0"),
    FAIL_ON_UNKNOWN_PROPERTIES("false");

    private final String defaultValue;

    PropertyType(final String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

}
