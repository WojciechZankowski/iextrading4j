package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

public class Exchange implements Serializable {

    private final String exchange;
    private final String region;
    private final String description;

    @JsonCreator
    public Exchange(
            @JsonProperty("exchange") final String exchange,
            @JsonProperty("region") final String region,
            @JsonProperty("description") final String description) {
        this.exchange = exchange;
        this.region = region;
        this.description = description;
    }

    public String getExchange() {
        return exchange;
    }

    public String getRegion() {
        return region;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Exchange)) return false;
        final Exchange exchange1 = (Exchange) o;
        return Objects.equal(exchange, exchange1.exchange) &&
                Objects.equal(region, exchange1.region) &&
                Objects.equal(description, exchange1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(exchange, region, description);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("exchange", exchange)
                .add("region", region)
                .add("description", description)
                .toString();
    }

}
