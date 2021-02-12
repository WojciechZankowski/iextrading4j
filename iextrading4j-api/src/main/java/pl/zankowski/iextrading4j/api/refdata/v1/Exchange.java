package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

public class Exchange implements Serializable {

    private static final long serialVersionUID = -7878559134922419823L;

    private final String exchange;
    private final String region;
    private final String description;
    private final String mic;
    private final String exchangeSuffix;

    @JsonCreator
    public Exchange(
            @JsonProperty("exchange") final String exchange,
            @JsonProperty("region") final String region,
            @JsonProperty("description") final String description,
            @JsonProperty("mic") final String mic,
            @JsonProperty("exchangeSuffix") final String exchangeSuffix) {
        this.exchange = exchange;
        this.region = region;
        this.description = description;
        this.mic = mic;
        this.exchangeSuffix = exchangeSuffix;
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

    public String getMic() {
        return mic;
    }

    public String getExchangeSuffix() {
        return exchangeSuffix;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Exchange exchange1 = (Exchange) o;
        return Objects.equal(exchange, exchange1.exchange) &&
                Objects.equal(region, exchange1.region) &&
                Objects.equal(description, exchange1.description) &&
                Objects.equal(mic, exchange1.mic) &&
                Objects.equal(exchangeSuffix, exchange1.exchangeSuffix);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(exchange, region, description, mic, exchangeSuffix);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("exchange", exchange)
                .add("region", region)
                .add("description", description)
                .add("mic", mic)
                .add("exchangeSuffix", exchangeSuffix)
                .toString();
    }

}
