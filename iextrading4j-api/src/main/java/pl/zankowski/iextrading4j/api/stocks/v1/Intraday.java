package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class Intraday implements Serializable {

    private static final long serialVersionUID = -3518267839991998431L;

    private final String date;
    private final String minute;
    private final String label;
    private final BigDecimal marketOpen;
    private final BigDecimal marketClose;
    private final BigDecimal marketHigh;
    private final BigDecimal marketLow;
    private final BigDecimal marketAverage;
    private final BigDecimal marketVolume;
    private final BigDecimal marketNotional;
    private final BigDecimal marketNumberOfTrades;
    private final BigDecimal marketChangeOverTime;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal open;
    private final BigDecimal close;
    private final BigDecimal average;
    private final BigDecimal volume;
    private final BigDecimal notional;
    private final BigDecimal numberOfTrades;
    private final BigDecimal changeOverTime;

    @JsonCreator
    public Intraday(
            @JsonProperty("date") final String date,
            @JsonProperty("minute") final String minute,
            @JsonProperty("label") final String label,
            @JsonProperty("marktOpen") final BigDecimal marketOpen,
            @JsonProperty("marketClose") final BigDecimal marketClose,
            @JsonProperty("marktHigh") final BigDecimal marketHigh,
            @JsonProperty("marketLow") final BigDecimal marketLow,
            @JsonProperty("marketAverage") final BigDecimal marketAverage,
            @JsonProperty("marketVolume") final BigDecimal marketVolume,
            @JsonProperty("marketNotional") final BigDecimal marketNotional,
            @JsonProperty("marketNumberOfTrades") final BigDecimal marketNumberOfTrades,
            @JsonProperty("marketChangeOverTime") final BigDecimal marketChangeOverTime,
            @JsonProperty("high") final BigDecimal high,
            @JsonProperty("low") final BigDecimal low,
            @JsonProperty("open") final BigDecimal open,
            @JsonProperty("close") final BigDecimal close,
            @JsonProperty("average") final BigDecimal average,
            @JsonProperty("volume") final BigDecimal volume,
            @JsonProperty("notional") final BigDecimal notional,
            @JsonProperty("numberOfTrades") final BigDecimal numberOfTrades,
            @JsonProperty("changeOverTime") final BigDecimal changeOverTime) {
        this.date = date;
        this.minute = minute;
        this.label = label;
        this.marketOpen = marketOpen;
        this.marketClose = marketClose;
        this.marketHigh = marketHigh;
        this.marketLow = marketLow;
        this.marketAverage = marketAverage;
        this.marketVolume = marketVolume;
        this.marketNotional = marketNotional;
        this.marketNumberOfTrades = marketNumberOfTrades;
        this.marketChangeOverTime = marketChangeOverTime;
        this.high = high;
        this.low = low;
        this.open = open;
        this.close = close;
        this.average = average;
        this.volume = volume;
        this.notional = notional;
        this.numberOfTrades = numberOfTrades;
        this.changeOverTime = changeOverTime;
    }

    public String getDate() {
        return date;
    }

    public String getMinute() {
        return minute;
    }

    public String getLabel() {
        return label;
    }

    public BigDecimal getMarketOpen() {
        return marketOpen;
    }

    public BigDecimal getMarketClose() {
        return marketClose;
    }

    public BigDecimal getMarketHigh() {
        return marketHigh;
    }

    public BigDecimal getMarketLow() {
        return marketLow;
    }

    public BigDecimal getMarketAverage() {
        return marketAverage;
    }

    public BigDecimal getMarketVolume() {
        return marketVolume;
    }

    public BigDecimal getMarketNotional() {
        return marketNotional;
    }

    public BigDecimal getMarketNumberOfTrades() {
        return marketNumberOfTrades;
    }

    public BigDecimal getMarketChangeOverTime() {
        return marketChangeOverTime;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public BigDecimal getNotional() {
        return notional;
    }

    public BigDecimal getNumberOfTrades() {
        return numberOfTrades;
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
        final Intraday intraday = (Intraday) o;
        return Objects.equal(date, intraday.date) &&
                Objects.equal(minute, intraday.minute) &&
                Objects.equal(label, intraday.label) &&
                Objects.equal(marketOpen, intraday.marketOpen) &&
                Objects.equal(marketClose, intraday.marketClose) &&
                Objects.equal(marketHigh, intraday.marketHigh) &&
                Objects.equal(marketLow, intraday.marketLow) &&
                Objects.equal(marketAverage, intraday.marketAverage) &&
                Objects.equal(marketVolume, intraday.marketVolume) &&
                Objects.equal(marketNotional, intraday.marketNotional) &&
                Objects.equal(marketNumberOfTrades, intraday.marketNumberOfTrades) &&
                Objects.equal(marketChangeOverTime, intraday.marketChangeOverTime) &&
                Objects.equal(high, intraday.high) &&
                Objects.equal(low, intraday.low) &&
                Objects.equal(open, intraday.open) &&
                Objects.equal(close, intraday.close) &&
                Objects.equal(average, intraday.average) &&
                Objects.equal(volume, intraday.volume) &&
                Objects.equal(notional, intraday.notional) &&
                Objects.equal(numberOfTrades, intraday.numberOfTrades) &&
                Objects.equal(changeOverTime, intraday.changeOverTime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date, minute, label, marketOpen, marketClose, marketHigh,
                marketLow, marketAverage, marketVolume, marketNotional, marketNumberOfTrades,
                marketChangeOverTime, high, low, open, close, average, volume, notional,
                numberOfTrades, changeOverTime);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("date", date)
                .add("minute", minute)
                .add("label", label)
                .add("marketOpen", marketOpen)
                .add("marketClose", marketClose)
                .add("marketHigh", marketHigh)
                .add("marketLow", marketLow)
                .add("marketAverage", marketAverage)
                .add("marketVolume", marketVolume)
                .add("marketNotional", marketNotional)
                .add("marketNumberOfTrades", marketNumberOfTrades)
                .add("marketChangeOverTime", marketChangeOverTime)
                .add("high", high)
                .add("low", low)
                .add("open", open)
                .add("close", close)
                .add("average", average)
                .add("volume", volume)
                .add("notional", notional)
                .add("numberOfTrades", numberOfTrades)
                .add("changeOverTime", changeOverTime)
                .toString();
    }

}
