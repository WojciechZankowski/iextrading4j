package pl.zankowski.iextrading4j.api.stocks;

public enum ChartRange {

    MAX("max"),
    INTRADAY("today"),
    ONE_DAY("1d"),
    FIVE_DAYS("5d"),
    FIVE_DAYS_10_MIN_INTERVAL("5dm"),
    ONE_MONTH("1m"),
    ONE_MONTH_30_MIN_INTERVAL("1mm"),
    THREE_MONTHS("3m"),
    SIX_MONTHS("6m"),
    YEAR_TO_DATE("ytd"),
    ONE_YEAR("1y"),
    TWO_YEARS("2y"),
    FIVE_YEARS("5y"),
    DYNAMIC("dynamic");

    private final String code;

    ChartRange(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ChartRange getValueFromCode(final String code) {
        for (final ChartRange range : values()) {
            if (range.getCode().equals(code)) {
                return range;
            }
        }
        throw new IllegalArgumentException("Not valid chart range: " + code);
    }

}
