package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"minute", "average", "notional", "numberOfTrades", "high",
        "low", "volume", "date", "open", "close", "unadjustedClose", "unadjustedVolume",
        "change", "changeInPercent", "vwap", "label", "changeOverTime"})
public class Chart implements Serializable {

    private final String minute;
    private final BigDecimal average;
    private final BigDecimal notional;
    private final BigDecimal numberOfTrades;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal volume;
    private final String date;
    private final BigDecimal open;
    private final BigDecimal close;
    private final BigDecimal unadjustedClose;
    private final BigDecimal unadjustedVolume;
    private final BigDecimal change;
    private final BigDecimal changePercent;
    private final BigDecimal vwap;
    private final String label;
    private final BigDecimal changeOverTime;

    @JsonCreator
    public Chart(@JsonProperty("minute") final String minute,
                 @JsonProperty("average") final BigDecimal average,
                 @JsonProperty("notional") final BigDecimal notional,
                 @JsonProperty("numberOfTrades") final BigDecimal numberOfTrades,
                 @JsonProperty("high") final BigDecimal high,
                 @JsonProperty("low") final BigDecimal low,
                 @JsonProperty("volume") final BigDecimal volume,
                 @JsonProperty("date") final String date,
                 @JsonProperty("open") final BigDecimal open,
                 @JsonProperty("close") final BigDecimal close,
                 @JsonProperty("unadjustedClose") final BigDecimal unadjustedClose,
                 @JsonProperty("unadjustedVolume") final BigDecimal unadjustedVolume,
                 @JsonProperty("change") final BigDecimal change,
                 @JsonProperty("changePercent") final BigDecimal changePercent,
                 @JsonProperty("vwap") final BigDecimal vwap,
                 @JsonProperty("label") final String label,
                 @JsonProperty("changeOverTime") final BigDecimal changeOverTime) {
        this.minute = minute;
        this.average = average;
        this.notional = notional;
        this.numberOfTrades = numberOfTrades;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.date = date;
        this.open = open;
        this.close = close;
        this.unadjustedClose = unadjustedClose;
        this.unadjustedVolume = unadjustedVolume;
        this.change = change;
        this.changePercent = changePercent;
        this.vwap = vwap;
        this.label = label;
        this.changeOverTime = changeOverTime;
    }

    public String getMinute() {
        return minute;
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

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public String getDate() {
        return date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getUnadjustedClose() {
        return unadjustedClose;
    }

    public BigDecimal getUnadjustedVolume() {
        return unadjustedVolume;
    }

    public BigDecimal getChange() {
        return change;
    }

    public BigDecimal getChangePercent() {
        return changePercent;
    }

    public BigDecimal getVwap() {
        return vwap;
    }

    public String getLabel() {
        return label;
    }

    public BigDecimal getChangeOverTime() {
        return changeOverTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chart chart = (Chart) o;
        return Objects.equal(minute, chart.minute) &&
                Objects.equal(average, chart.average) &&
                Objects.equal(notional, chart.notional) &&
                Objects.equal(numberOfTrades, chart.numberOfTrades) &&
                Objects.equal(high, chart.high) &&
                Objects.equal(low, chart.low) &&
                Objects.equal(volume, chart.volume) &&
                Objects.equal(date, chart.date) &&
                Objects.equal(open, chart.open) &&
                Objects.equal(close, chart.close) &&
                Objects.equal(unadjustedClose, chart.unadjustedClose) &&
                Objects.equal(unadjustedVolume, chart.unadjustedVolume) &&
                Objects.equal(change, chart.change) &&
                Objects.equal(changePercent, chart.changePercent) &&
                Objects.equal(vwap, chart.vwap) &&
                Objects.equal(label, chart.label) &&
                Objects.equal(changeOverTime, chart.changeOverTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(minute, average, notional, numberOfTrades, high, low, volume,
                date, open, close, unadjustedClose, unadjustedVolume, change, changePercent,
                vwap, label, changeOverTime);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("minute", minute)
                .add("average", average)
                .add("notional", notional)
                .add("numberOfTrades", numberOfTrades)
                .add("high", high)
                .add("low", low)
                .add("volume", volume)
                .add("date", date)
                .add("open", open)
                .add("close", close)
                .add("unadjustedClose", unadjustedClose)
                .add("unadjustedVolume", unadjustedVolume)
                .add("change", change)
                .add("changePercent", changePercent)
                .add("vwap", vwap)
                .add("label", label)
                .add("changeOverTime", changeOverTime)
                .toString();
    }
}
