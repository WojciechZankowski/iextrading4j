package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BarData implements Serializable {

    private final LocalDate date;
    private final BigDecimal open;
    private final BigDecimal close;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal volume;
    private final BigDecimal uOpen;
    private final BigDecimal uClose;
    private final BigDecimal uHigh;
    private final BigDecimal uLow;
    private final BigDecimal uVolume;
    private final BigDecimal change;
    private final BigDecimal changePercent;
    private final BigDecimal changeOverTime;
    private final String symbol;

    @JsonCreator
    public BarData(
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("open") final BigDecimal open,
            @JsonProperty("close") final BigDecimal close,
            @JsonProperty("high") final BigDecimal high,
            @JsonProperty("low") final BigDecimal low,
            @JsonProperty("volume") final BigDecimal volume,
            @JsonProperty("uOpen") final BigDecimal uOpen,
            @JsonProperty("uClose") final BigDecimal uClose,
            @JsonProperty("uHigh") final BigDecimal uHigh,
            @JsonProperty("uLow") final BigDecimal uLow,
            @JsonProperty("uVolume") final BigDecimal uVolume,
            @JsonProperty("change") final BigDecimal change,
            @JsonProperty("changePercent") final BigDecimal changePercent,
            @JsonProperty("changeOverTime") final BigDecimal changeOverTime,
            @JsonProperty("symbol") final String symbol) {
        this.date = date;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.uOpen = uOpen;
        this.uClose = uClose;
        this.uHigh = uHigh;
        this.uLow = uLow;
        this.uVolume = uVolume;
        this.change = change;
        this.changePercent = changePercent;
        this.changeOverTime = changeOverTime;
        this.symbol = symbol;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getClose() {
        return close;
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

    public BigDecimal getuOpen() {
        return uOpen;
    }

    public BigDecimal getuClose() {
        return uClose;
    }

    public BigDecimal getuHigh() {
        return uHigh;
    }

    public BigDecimal getuLow() {
        return uLow;
    }

    public BigDecimal getuVolume() {
        return uVolume;
    }

    public BigDecimal getChange() {
        return change;
    }

    public BigDecimal getChangePercent() {
        return changePercent;
    }

    public BigDecimal getChangeOverTime() {
        return changeOverTime;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BarData)) return false;
        final BarData barData = (BarData) o;
        return Objects.equal(date, barData.date) &&
                Objects.equal(open, barData.open) &&
                Objects.equal(close, barData.close) &&
                Objects.equal(high, barData.high) &&
                Objects.equal(low, barData.low) &&
                Objects.equal(volume, barData.volume) &&
                Objects.equal(uOpen, barData.uOpen) &&
                Objects.equal(uClose, barData.uClose) &&
                Objects.equal(uHigh, barData.uHigh) &&
                Objects.equal(uLow, barData.uLow) &&
                Objects.equal(uVolume, barData.uVolume) &&
                Objects.equal(change, barData.change) &&
                Objects.equal(changePercent, barData.changePercent) &&
                Objects.equal(changeOverTime, barData.changeOverTime) &&
                Objects.equal(symbol, barData.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date, open, close, high, low, volume, uOpen, uClose,
                uHigh, uLow, uVolume, change, changePercent, changeOverTime, symbol);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("date", date)
                .add("open", open)
                .add("close", close)
                .add("high", high)
                .add("low", low)
                .add("volume", volume)
                .add("uOpen", uOpen)
                .add("uClose", uClose)
                .add("uHigh", uHigh)
                .add("uLow", uLow)
                .add("uVolume", uVolume)
                .add("change", change)
                .add("changePercent", changePercent)
                .add("changeOverTime", changeOverTime)
                .add("symbol", symbol)
                .toString();
    }

}
