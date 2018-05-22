package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({"symbol", "date", "open", "high", "low", "close", "volume",
        "unadjustedVolume", "change", "changePercent", "vwap"})
public class BarData implements Serializable {

    private final String symbol;
    private final LocalDate date;
    private final BigDecimal open;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal close;
    private final BigDecimal volume;
    private final BigDecimal unadjustedVolume;
    private final BigDecimal change;
    private final BigDecimal changePercent;
    private final BigDecimal vwap;

    @JsonCreator
    public BarData(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("open") final BigDecimal open,
            @JsonProperty("high") final BigDecimal high,
            @JsonProperty("low") final BigDecimal low,
            @JsonProperty("close") final BigDecimal close,
            @JsonProperty("volume") final BigDecimal volume,
            @JsonProperty("unadjustedVolume") final BigDecimal unadjustedVolume,
            @JsonProperty("change") final BigDecimal change,
            @JsonProperty("changePercent") final BigDecimal changePercent,
            @JsonProperty("vwap") final BigDecimal vwap) {
        this.symbol = symbol;
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
    }

    public String getSymbol() {
        return symbol;
    }

    public LocalDate getDate() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarData barData = (BarData) o;
        return Objects.equal(symbol, barData.symbol) &&
                Objects.equal(date, barData.date) &&
                Objects.equal(open, barData.open) &&
                Objects.equal(high, barData.high) &&
                Objects.equal(low, barData.low) &&
                Objects.equal(close, barData.close) &&
                Objects.equal(volume, barData.volume) &&
                Objects.equal(unadjustedVolume, barData.unadjustedVolume) &&
                Objects.equal(change, barData.change) &&
                Objects.equal(changePercent, barData.changePercent) &&
                Objects.equal(vwap, barData.vwap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, date, open, high, low, close, volume,
                unadjustedVolume, change, changePercent, vwap);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
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
                .toString();
    }
}
