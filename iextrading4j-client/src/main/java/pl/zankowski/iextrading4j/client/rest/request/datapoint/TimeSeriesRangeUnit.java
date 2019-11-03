package pl.zankowski.iextrading4j.client.rest.request.datapoint;

public enum TimeSeriesRangeUnit {

    DAY("d"),
    WEEK("w"),
    MONTH("m"),
    QUARTER("q"),
    YEAR("y");

    private final String code;

    TimeSeriesRangeUnit(final String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
