package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonPropertyOrder({"date", "open", "high", "low", "close", "volume", "unadjustedVolume", "change",
        "changePercent", "vwap", "label", "changeOverTime"})
public class TimeSeries implements Serializable {

    private final String date;
    private final BigDecimal open;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal close;
    private final BigDecimal volume;
    private final BigDecimal unadjustedVolume;
    private final BigDecimal change;
    private final BigDecimal changePercent;
    private final BigDecimal vwap;
    private final String label;
    private final BigDecimal changeOverTime;

    @JsonCreator
    public TimeSeries(
            @JsonProperty("date") final String date,
            @JsonProperty("open") final BigDecimal open,
            @JsonProperty("high") final BigDecimal high,
            @JsonProperty("low") final BigDecimal low,
            @JsonProperty("close") final BigDecimal close,
            @JsonProperty("volume") final BigDecimal volume,
            @JsonProperty("unadjustedVolume") final BigDecimal unadjustedVolume,
            @JsonProperty("change") final BigDecimal change,
            @JsonProperty("changePercent") final BigDecimal changePercent,
            @JsonProperty("vwap") final BigDecimal vwap,
            @JsonProperty("label") final String label,
            @JsonProperty("changeOverTime") final BigDecimal changeOverTime) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.unadjustedVolume = unadjustedVolume;
        this.change = change;
        this.changePercent = changePercent;
        this.vwap = vwap;
        this.label = label;
        this.changeOverTime = changeOverTime;
    }

    public String getDate() {
        return date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getVolume() {
        return volume;
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
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TimeSeries that = (TimeSeries) o;
        return Objects.equal(date, that.date) &&
                Objects.equal(open, that.open) &&
                Objects.equal(high, that.high) &&
                Objects.equal(low, that.low) &&
                Objects.equal(close, that.close) &&
                Objects.equal(volume, that.volume) &&
                Objects.equal(unadjustedVolume, that.unadjustedVolume) &&
                Objects.equal(change, that.change) &&
                Objects.equal(changePercent, that.changePercent) &&
                Objects.equal(vwap, that.vwap) &&
                Objects.equal(label, that.label) &&
                Objects.equal(changeOverTime, that.changeOverTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date, open, high, low, close, volume, unadjustedVolume, change,
                changePercent, vwap, label, changeOverTime);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("date", date)
                .add("open", open)
                .add("high", high)
                .add("low", low)
                .add("close", close)
                .add("volume", volume)
                .add("unadjustedVolume", unadjustedVolume)
                .add("change", change)
                .add("changePercent", changePercent)
                .add("vwap", vwap)
                .add("label", label)
                .add("changeOverTime", changeOverTime)
                .toString();
    }
}
