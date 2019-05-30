package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"symbol", "exchange", "region"})
public class SymbolMapping implements Serializable {

    private static final long serialVersionUID = 7796962782222356844L;

    private final String symbol;
    private final String exchange;
    private final String region;

    @JsonCreator
    public SymbolMapping(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("exchange") final String exchange,
            @JsonProperty("region") final String region) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.region = region;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SymbolMapping that = (SymbolMapping) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(exchange, that.exchange) &&
                Objects.equal(region, that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, exchange, region);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("exchange", exchange)
                .add("region", region)
                .toString();
    }

}
