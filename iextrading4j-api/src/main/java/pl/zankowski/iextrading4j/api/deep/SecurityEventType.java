package pl.zankowski.iextrading4j.api.deep;

/**
 * @author Wojciech Zankowski
 */
public enum SecurityEventType {

    MARKET_OPEN("MarketOpen"),
    MARKET_CLOSE("MarketClose"),
    UNKNOWN("");

    private final String name;

    SecurityEventType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SecurityEventType getSecurityEventType(String name) {
        for (SecurityEventType securityEventType : values()) {
            if (securityEventType.getName().equals(name)) {
                return securityEventType;
            }
        }
        return SecurityEventType.UNKNOWN;
    }

}
