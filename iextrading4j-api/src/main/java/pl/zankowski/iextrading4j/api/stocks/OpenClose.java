package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

@JsonPropertyOrder({"open", "close"})
public class OpenClose implements Serializable {

    private final Point open;
    private final Point close;

    @JsonCreator
    public OpenClose(
            @JsonProperty("open") final Point open,
            @JsonProperty("close") final Point close) {
        this.open = open;
        this.close = close;
    }

    public Point getOpen() {
        return open;
    }

    public Point getClose() {
        return close;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenClose openClose = (OpenClose) o;
        return Objects.equal(open, openClose.open) &&
                Objects.equal(close, openClose.close);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(open, close);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("open", open)
                .add("close", close)
                .toString();
    }
}
