package pl.zankowski.iextrading4j.api.stats.builder;

import pl.zankowski.iextrading4j.api.stats.IntradayStat;

/**
 * @author Wojciech Zankowski
 */
public class IntradayStatDataBuilder {

    private double value = 1234d;
    private long lastUpdated = 1489438707493L;

    public static IntradayStat defaultIntradayStat() {
        return anIntradayStatDataBuilder().build();
    }

    public static IntradayStatDataBuilder anIntradayStatDataBuilder() {
        return new IntradayStatDataBuilder();
    }

    public IntradayStatDataBuilder withValue(double value) {
        this.value = value;
        return this;
    }

    public IntradayStatDataBuilder withLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public IntradayStat build() {
        return new IntradayStat(value, lastUpdated);
    }

}
