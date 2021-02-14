package pl.zankowski.iextrading4j.api.options;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Option implements Serializable {

    private static final long serialVersionUID = 2983757072405826797L;

    private final String symbol;
    private final String id;
    private final String expirationDate;
    private final BigDecimal contractSize;
    private final BigDecimal strikePrice;
    private final BigDecimal closingPrice;
    private final String side;
    private final String type;
    private final BigDecimal volume;
    private final BigDecimal openInterest;
    private final BigDecimal bid;
    private final BigDecimal ask;
    private final LocalDate lastUpdated;

    @JsonCreator
    public Option(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("id") final String id,
            @JsonProperty("expirationDate") final String expirationDate,
            @JsonProperty("contractSize") final BigDecimal contractSize,
            @JsonProperty("strikePrice") final BigDecimal strikePrice,
            @JsonProperty("closingPrice") final BigDecimal closingPrice,
            @JsonProperty("side") final String side,
            @JsonProperty("type") final String type,
            @JsonProperty("volume") final BigDecimal volume,
            @JsonProperty("openInterest") final BigDecimal openInterest,
            @JsonProperty("bid") final BigDecimal bid,
            @JsonProperty("ask") final BigDecimal ask,
            @JsonProperty("lastUpdated") final LocalDate lastUpdated) {
        this.symbol = symbol;
        this.id = id;
        this.expirationDate = expirationDate;
        this.contractSize = contractSize;
        this.strikePrice = strikePrice;
        this.closingPrice = closingPrice;
        this.side = side;
        this.type = type;
        this.volume = volume;
        this.openInterest = openInterest;
        this.bid = bid;
        this.ask = ask;
        this.lastUpdated = lastUpdated;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getId() {
        return id;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public BigDecimal getContractSize() {
        return contractSize;
    }

    public BigDecimal getStrikePrice() {
        return strikePrice;
    }

    public BigDecimal getClosingPrice() {
        return closingPrice;
    }

    public String getSide() {
        return side;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public BigDecimal getOpenInterest() {
        return openInterest;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Option option = (Option) o;
        return Objects.equal(symbol, option.symbol) &&
                Objects.equal(id, option.id) &&
                Objects.equal(expirationDate, option.expirationDate) &&
                Objects.equal(contractSize, option.contractSize) &&
                Objects.equal(strikePrice, option.strikePrice) &&
                Objects.equal(closingPrice, option.closingPrice) &&
                Objects.equal(side, option.side) &&
                Objects.equal(type, option.type) &&
                Objects.equal(volume, option.volume) &&
                Objects.equal(openInterest, option.openInterest) &&
                Objects.equal(bid, option.bid) &&
                Objects.equal(ask, option.ask) &&
                Objects.equal(lastUpdated, option.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, id, expirationDate, contractSize, strikePrice, closingPrice,
                side, type, volume, openInterest, bid, ask, lastUpdated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("id", id)
                .add("expirationDate", expirationDate)
                .add("contractSize", contractSize)
                .add("strikePrice", strikePrice)
                .add("closingPrice", closingPrice)
                .add("side", side)
                .add("type", type)
                .add("volume", volume)
                .add("openInterest", openInterest)
                .add("bid", bid)
                .add("ask", ask)
                .add("lastUpdated", lastUpdated)
                .toString();
    }

}
