package pl.zankowski.iextrading4j.client.rest.request.stocks;

public enum DividendRange {

    ONE_MONTH("1m"),
    THREE_MONTHS("3m"),
    SIX_MONTHS("6m"),
    YEAR_TO_DATE("ytd"),
    ONE_YEAR("1y"),
    TWO_YEARS("2y"),
    FIVE_YEARS("5y");

    private final String code;

    DividendRange(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
