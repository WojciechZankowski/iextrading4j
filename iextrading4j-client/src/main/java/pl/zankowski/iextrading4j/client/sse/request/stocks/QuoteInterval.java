package pl.zankowski.iextrading4j.client.sse.request.stocks;

public enum QuoteInterval {

    REALTIME(""),
    ONE_SECOND("1Second"),
    FIVE_SECONDS("5Second"),
    ONE_MINUTE("1Minute");

    private final String name;

    QuoteInterval(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
