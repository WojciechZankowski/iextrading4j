package pl.zankowski.iextrading4j.client.socket.request.marketdata.deep;

import java.util.HashMap;
import java.util.Map;

public enum DeepMessageType {

    TRADING_STATUS("tradingstatus"),
    AUCTION("auction"),
    OP_HALT_STATUS("ophaltstatus"),
    SSR_STATUS("ssr"),
    SECURITY_EVENT("securityevent"),
    TRADE_BREAK("tradebreak"),
    TRADES("trades"),
    BOOK("book"),
    SYSTEM_EVENT("systemevent"),
    UNKNOWN("");

    private static final Map<String, DeepMessageType> LOOKUP = new HashMap<>();

    static {
        for (DeepMessageType messageType : DeepMessageType.values()) {
            LOOKUP.put(messageType.getName(), messageType);
        }
    }

    private final String name;

    DeepMessageType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static DeepMessageType getMessageType(final String name) {
        final DeepMessageType messageType = LOOKUP.get(name);
        if (messageType == null) {
            return UNKNOWN;
        }
        return messageType;
    }

}
