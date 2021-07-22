package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

public class TimeSeries implements Serializable {

    private static final long serialVersionUID = -5513479374604990501L;

    private final String symbol;
    private final String id;
    private final String key;
    private final String subkey;
    private final Long updated;
    private final String date;
    private final BigDecimal open;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal close;
    private final BigDecimal volume;
    private final BigDecimal uOpen;
    private final BigDecimal uHigh;
    private final BigDecimal uLow;
    private final BigDecimal uClose;
    private final BigDecimal uVolume;
    private final BigDecimal fOpen;
    private final BigDecimal fHigh;
    private final BigDecimal fLow;
    private final BigDecimal fClose;
    private final BigDecimal fVolume;
    private final BigDecimal unadjustedVolume;
    private final BigDecimal change;
    private final BigDecimal changePercent;
    private final BigDecimal vwap;
    private final String label;
    private final BigDecimal changeOverTime;

    @JsonCreator
    public TimeSeries(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("id") final String id,
            @JsonProperty("key") final String key,
            @JsonProperty("subkey") final String subkey,
            @JsonProperty("updated") final Long updated,
            @JsonProperty("date") final String date,
            @JsonProperty("open") final BigDecimal open,
            @JsonProperty("high") final BigDecimal high,
            @JsonProperty("low") final BigDecimal low,
            @JsonProperty("close") final BigDecimal close,
            @JsonProperty("volume") final BigDecimal volume,
            @JsonProperty("uOpen") final BigDecimal uOpen,
            @JsonProperty("uHigh") final BigDecimal uHigh,
            @JsonProperty("uLow") final BigDecimal uLow,
            @JsonProperty("uClose") final BigDecimal uClose,
            @JsonProperty("uVolume") final BigDecimal uVolume,
            @JsonProperty("fOpen") final BigDecimal fOpen,
            @JsonProperty("fHigh") final BigDecimal fHigh,
            @JsonProperty("fLow") final BigDecimal fLow,
            @JsonProperty("fClose") final BigDecimal fClose,
            @JsonProperty("fVolume") final BigDecimal fVolume,
            @JsonProperty("unadjustedVolume") final BigDecimal unadjustedVolume,
            @JsonProperty("change") final BigDecimal change,
            @JsonProperty("changePercent") final BigDecimal changePercent,
            @JsonProperty("vwap") final BigDecimal vwap,
            @JsonProperty("label") final String label,
            @JsonProperty("changeOverTime") final BigDecimal changeOverTime) {
        this.symbol = symbol;
        this.id = id;
        this.key = key;
        this.subkey = subkey;
        this.updated = updated;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.uOpen = uOpen;
        this.uHigh = uHigh;
        this.uLow = uLow;
        this.uClose = uClose;
        this.uVolume = uVolume;
        this.fOpen = fOpen;
        this.fHigh = fHigh;
        this.fLow = fLow;
        this.fClose = fClose;
        this.fVolume = fVolume;
        this.unadjustedVolume = unadjustedVolume;
        this.change = change;
        this.changePercent = changePercent;
        this.vwap = vwap;
        this.label = label;
        this.changeOverTime = changeOverTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getSubkey() {
        return subkey;
    }

    public Long getUpdated() {
        return updated;
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

    public BigDecimal getuOpen() {
        return uOpen;
    }

    public BigDecimal getuHigh() {
        return uHigh;
    }

    public BigDecimal getuLow() {
        return uLow;
    }

    public BigDecimal getuClose() {
        return uClose;
    }

    public BigDecimal getuVolume() {
        return uVolume;
    }

    public BigDecimal getfOpen() {
        return fOpen;
    }

    public BigDecimal getfHigh() {
        return fHigh;
    }

    public BigDecimal getfLow() {
        return fLow;
    }

    public BigDecimal getfClose() {
        return fClose;
    }

    public BigDecimal getfVolume() {
        return fVolume;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TimeSeries that = (TimeSeries) o;
        return Objects.equals(symbol, that.symbol) && Objects.equals(id, that.id) &&
                Objects.equals(key, that.key) && Objects.equals(subkey, that.subkey) &&
                Objects.equals(updated, that.updated) && Objects.equals(date, that.date) &&
                Objects.equals(open, that.open) && Objects.equals(high, that.high) &&
                Objects.equals(low, that.low) && Objects.equals(close, that.close) &&
                Objects.equals(volume, that.volume) && Objects.equals(uOpen, that.uOpen) &&
                Objects.equals(uHigh, that.uHigh) && Objects.equals(uLow, that.uLow) &&
                Objects.equals(uClose, that.uClose) && Objects.equals(uVolume, that.uVolume) &&
                Objects.equals(fOpen, that.fOpen) && Objects.equals(fHigh, that.fHigh) &&
                Objects.equals(fLow, that.fLow) && Objects.equals(fClose, that.fClose) &&
                Objects.equals(fVolume, that.fVolume) &&
                Objects.equals(unadjustedVolume, that.unadjustedVolume) &&
                Objects.equals(change, that.change) &&
                Objects.equals(changePercent, that.changePercent) && Objects.equals(vwap, that.vwap) &&
                Objects.equals(label, that.label) &&
                Objects.equals(changeOverTime, that.changeOverTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, id, key, subkey, updated, date, open, high, low, close, volume, uOpen, uHigh, uLow,
                uClose, uVolume, fOpen, fHigh, fLow, fClose, fVolume, unadjustedVolume, change, changePercent, vwap,
                label, changeOverTime);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TimeSeries.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("id='" + id + "'")
                .add("key='" + key + "'")
                .add("subkey='" + subkey + "'")
                .add("updated=" + updated)
                .add("date='" + date + "'")
                .add("open=" + open)
                .add("high=" + high)
                .add("low=" + low)
                .add("close=" + close)
                .add("volume=" + volume)
                .add("uOpen=" + uOpen)
                .add("uHigh=" + uHigh)
                .add("uLow=" + uLow)
                .add("uClose=" + uClose)
                .add("uVolume=" + uVolume)
                .add("fOpen=" + fOpen)
                .add("fHigh=" + fHigh)
                .add("fLow=" + fLow)
                .add("fClose=" + fClose)
                .add("fVolume=" + fVolume)
                .add("unadjustedVolume=" + unadjustedVolume)
                .add("change=" + change)
                .add("changePercent=" + changePercent)
                .add("vwap=" + vwap)
                .add("label='" + label + "'")
                .add("changeOverTime=" + changeOverTime)
                .toString();
    }
}
