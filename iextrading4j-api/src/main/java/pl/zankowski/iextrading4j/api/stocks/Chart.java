package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import pl.zankowski.iextrading4j.api.util.ListUtil;

import java.math.BigDecimal;
import java.util.List;

@JsonPropertyOrder({"minute", "marketAverage", "marketNotional", "marketNumberOfTrades", "marketHigh",
        "marketLow", "marketVolume", "marketChangeOverTime", "marketOpen", "marketClose", "average", "notional",
        "numberOfTrades", "high", "low", "volume", "date", "open", "close", "unadjustedVolume",
        "change", "changeInPercent", "vwap", "label", "changeOverTime", "simplifyFactor"})
public class Chart extends TimeSeries {

    private final String minute;
    private final BigDecimal marketAverage;
    private final BigDecimal marketNotional;
    private final BigDecimal marketNumberOfTrades;
    private final BigDecimal marketHigh;
    private final BigDecimal marketLow;
    private final BigDecimal marketVolume;
    private final BigDecimal marketChangeOverTime;
    private final BigDecimal marketOpen;
    private final BigDecimal marketClose;
    private final BigDecimal average;
    private final BigDecimal notional;
    private final BigDecimal numberOfTrades;
    private final List<BigDecimal> simplifyFactor;

    @JsonCreator
    public Chart(
            @JsonProperty("minute") final String minute,
            @JsonProperty("marketAverage") final BigDecimal marketAverage,
            @JsonProperty("marketNotional") final BigDecimal marketNotional,
            @JsonProperty("marketNumberOfTrades") final BigDecimal marketNumberOfTrades,
            @JsonProperty("marketHigh") final BigDecimal marketHigh,
            @JsonProperty("marketLow") final BigDecimal marketLow,
            @JsonProperty("marketVolume") final BigDecimal marketVolume,
            @JsonProperty("marketChangeOverTime") final BigDecimal marketChangeOverTime,
            @JsonProperty("marketOpen") final BigDecimal marketOpen,
            @JsonProperty("marketClose") final BigDecimal marketClose,
            @JsonProperty("average") final BigDecimal average,
            @JsonProperty("notional") final BigDecimal notional,
            @JsonProperty("numberOfTrades") final BigDecimal numberOfTrades,
            @JsonProperty("simplifyFactor") final List<BigDecimal> simplifyFactor,
            @JsonProperty("high") final BigDecimal high,
            @JsonProperty("low") final BigDecimal low,
            @JsonProperty("volume") final BigDecimal volume,
            @JsonProperty("label") final String label,
            @JsonProperty("changeOverTime") final BigDecimal changeOverTime,
            @JsonProperty("date") final String date,
            @JsonProperty("open") final BigDecimal open,
            @JsonProperty("close") final BigDecimal close,
            @JsonProperty("unadjustedVolume") final BigDecimal unadjustedVolume,
            @JsonProperty("change") final BigDecimal change,
            @JsonProperty("changePercent") final BigDecimal changePercent,
            @JsonProperty("vwap") final BigDecimal vwap) {
        super(date, open, high, low, close, volume, unadjustedVolume, change, changePercent, vwap, label, changeOverTime);
        this.minute = minute;
        this.marketAverage = marketAverage;
        this.marketNotional = marketNotional;
        this.marketNumberOfTrades = marketNumberOfTrades;
        this.marketHigh = marketHigh;
        this.marketLow = marketLow;
        this.marketVolume = marketVolume;
        this.marketChangeOverTime = marketChangeOverTime;
        this.marketOpen = marketOpen;
        this.marketClose = marketClose;
        this.average = average;
        this.notional = notional;
        this.numberOfTrades = numberOfTrades;
        this.simplifyFactor = ListUtil.immutableList(simplifyFactor);
    }

    public String getMinute() {
        return minute;
    }

    public BigDecimal getMarketAverage() {
        return marketAverage;
    }

    public BigDecimal getMarketNotional() {
        return marketNotional;
    }

    public BigDecimal getMarketNumberOfTrades() {
        return marketNumberOfTrades;
    }

    public BigDecimal getMarketHigh() {
        return marketHigh;
    }

    public BigDecimal getMarketLow() {
        return marketLow;
    }

    public BigDecimal getMarketVolume() {
        return marketVolume;
    }

    public BigDecimal getMarketChangeOverTime() {
        return marketChangeOverTime;
    }

    public BigDecimal getMarketOpen() {
        return marketOpen;
    }

    public BigDecimal getMarketClose() {
        return marketClose;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public BigDecimal getNotional() {
        return notional;
    }

    public BigDecimal getNumberOfTrades() {
        return numberOfTrades;
    }

    public List<BigDecimal> getSimplifyFactor() {
        return simplifyFactor;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final Chart chart = (Chart) o;
        return Objects.equal(minute, chart.minute) &&
                Objects.equal(marketAverage, chart.marketAverage) &&
                Objects.equal(marketNotional, chart.marketNotional) &&
                Objects.equal(marketNumberOfTrades, chart.marketNumberOfTrades) &&
                Objects.equal(marketHigh, chart.marketHigh) &&
                Objects.equal(marketLow, chart.marketLow) &&
                Objects.equal(marketVolume, chart.marketVolume) &&
                Objects.equal(marketChangeOverTime, chart.marketChangeOverTime) &&
                Objects.equal(marketOpen, chart.marketOpen) &&
                Objects.equal(marketClose, chart.marketClose) &&
                Objects.equal(average, chart.average) &&
                Objects.equal(notional, chart.notional) &&
                Objects.equal(numberOfTrades, chart.numberOfTrades) &&
                Objects.equal(simplifyFactor, chart.simplifyFactor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), minute, marketAverage, marketNotional, marketNumberOfTrades,
                marketHigh, marketLow, marketVolume, marketChangeOverTime, marketOpen, marketClose, average,
                notional, numberOfTrades, simplifyFactor);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("date", getDate())
                .add("open", getOpen())
                .add("high", getHigh())
                .add("low", getLow())
                .add("close", getClose())
                .add("volume", getVolume())
                .add("unadjustedVolume", getUnadjustedVolume())
                .add("change", getChange())
                .add("changePercent", getChangePercent())
                .add("vwap", getVwap())
                .add("label", getLabel())
                .add("changeOverTime", getChangeOverTime())
                .add("minute", minute)
                .add("marketAverage", marketAverage)
                .add("marketNotional", marketNotional)
                .add("marketNumberOfTrades", marketNumberOfTrades)
                .add("marketHigh", marketHigh)
                .add("marketLow", marketLow)
                .add("marketVolume", marketVolume)
                .add("marketChangeOverTime", marketChangeOverTime)
                .add("marketOpen", marketOpen)
                .add("marketClose", marketClose)
                .add("average", average)
                .add("notional", notional)
                .add("numberOfTrades", numberOfTrades)
                .add("simplifyFactor", simplifyFactor)
                .toString();
    }
}
