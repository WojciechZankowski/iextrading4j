package pl.zankowski.iextrading4j.client.socket.request.marketdata.deep;

public enum DeepChannel {

    TRADING_STATUS("trading-status"),
    AUCTION("auction"),
    OP_HALT_STATUS("op-halt-status"),
    SSR_STATUS("ssr-status"),
    SECURITY_EVENT("security-event"),
    TRADE_BREAK("trade-breaks"),
    TRADES("trades"),
    BOOK("book"),
    SYSTEM_EVENT("system-event"),
    DEEP("deep"),
    UNKNOWN("");

    private final String name;

    DeepChannel(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
