package pl.zankowski.iextrading4j.client.rest.request.datapoint;

public enum TimeSeriesRange {

    TODAY("today"),
    YTD("ytd"),
    LAST_WEEK("last-week"),
    LAST_MONTH("last-month"),
    LAST_QUARTER("last-quarter"),
    TOMORROW("tomorrow"),
    THIS_WEEK("this-week"),
    THIS_MONTH("this-month"),
    THIS_QUARTER("this-quarter"),
    NEXT_WEEK("next-week"),
    NEXT_MONTH("next-month"),
    NEXT_QUARTER("next-quarter");

    private final String code;

    TimeSeriesRange(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
