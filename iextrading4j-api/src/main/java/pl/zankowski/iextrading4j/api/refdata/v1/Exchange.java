package pl.zankowski.iextrading4j.api.refdata.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Exchange implements Serializable {

    private static final long serialVersionUID = -7878559134922419823L;

    private final String exchange;
    private final String region;
    private final String description;
    private final String mic;
    private final String segment;
    private final String segmentDescription;
    private final String suffix;
    private final String exchangeSuffix;

    @JsonCreator
    public Exchange(
            @JsonProperty("exchange") final String exchange,
            @JsonProperty("region") final String region,
            @JsonProperty("description") final String description,
            @JsonProperty("mic") final String mic,
            @JsonProperty("segment") final String segment,
            @JsonProperty("segmentDescription") final String segmentDescription,
            @JsonProperty("suffix") final String suffix,
            @JsonProperty("exchangeSuffix") final String exchangeSuffix) {
        this.exchange = exchange;
        this.region = region;
        this.description = description;
        this.mic = mic;
        this.segment = segment;
        this.segmentDescription = segmentDescription;
        this.suffix = suffix;
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

    public String getSegment() {
        return segment;
    }

    public String getSegmentDescription() {
        return segmentDescription;
    }

    public String getSuffix() {
        return suffix;
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
        return Objects.equals(exchange, exchange1.exchange) &&
                Objects.equals(region, exchange1.region) &&
                Objects.equals(description, exchange1.description) &&
                Objects.equals(mic, exchange1.mic) && Objects.equals(segment, exchange1.segment) &&
                Objects.equals(segmentDescription, exchange1.segmentDescription) &&
                Objects.equals(suffix, exchange1.suffix) &&
                Objects.equals(exchangeSuffix, exchange1.exchangeSuffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exchange, region, description, mic, segment, segmentDescription, suffix, exchangeSuffix);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Exchange.class.getSimpleName() + "[", "]")
                .add("exchange='" + exchange + "'")
                .add("region='" + region + "'")
                .add("description='" + description + "'")
                .add("mic='" + mic + "'")
                .add("segment='" + segment + "'")
                .add("segmentDescription='" + segmentDescription + "'")
                .add("suffix='" + suffix + "'")
                .add("exchangeSuffix='" + exchangeSuffix + "'")
                .toString();
    }
}
