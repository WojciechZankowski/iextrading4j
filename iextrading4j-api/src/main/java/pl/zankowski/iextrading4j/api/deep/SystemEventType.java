package pl.zankowski.iextrading4j.api.deep;

/**
 * @author Wojciech Zankowski
 */
public enum SystemEventType {

    MESSAGES_START('O'),
    SYSTEM_HOURS_START('S'),
    REGULAR_MARKET_HOURS_START('R'),
    REGULAR_MARKET_HOURS_END('M'),
    SYSTEM_HOURS_END('E'),
    MESSAGES_END('C'),
    UNKNOWN(' ');

    private final char code;

    SystemEventType(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static SystemEventType getSystemEventType(char code) {
        for (SystemEventType systemEventType : values()) {
            if (systemEventType.getCode() == code) {
                return systemEventType;
            }
        }
        return SystemEventType.UNKNOWN;
    }

}
