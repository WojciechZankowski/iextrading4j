package pl.zankowski.iextrading4j.client.properties;

public enum PropertyType {

    API_REST_V1("https://api.iextrading.com/1.0"),
    API_REST_V2("https://cloud.iexapis.com/v1"),
    API_REST_V2_SANDBOX("https://sandbox.iexapis.com/v1"),
    API_REST_V2_BETA("https://cloud.iexapis.com/beta"),
    API_REST_V2_BETA_SANDBOX("https://sandbox.iexapis.com/beta"),
    API_REST_STABLE("https://cloud.iexapis.com/stable"),
    API_REST_STABLE_SANDBOX("https://sandbox.iexapis.com/stable"),

    API_SSE_V2("https://cloud-sse.iexapis.com/v1"),
    API_SSE_V2_SANDBOX("https://sandbox-sse.iexapis.com/v1"),

    API_SOCKET_V1("https://ws-api.iextrading.com/1.0"),
    API_SOCKET_V2("https://ws-cloud.iexapis.com/v1"),
    API_SOCKET_V2_SANDBOX("https://ws-sandbox.iexapis.com/v1"),

    FAIL_ON_UNKNOWN_PROPERTIES("false");

    private final String defaultValue;

    PropertyType(final String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

}
