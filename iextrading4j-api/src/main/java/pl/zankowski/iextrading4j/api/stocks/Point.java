package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class Point implements Serializable {

    private static final long serialVersionUID = 8714265705173592739L;

    private final BigDecimal price;
    private final Long time;

    @JsonCreator
    public Point(
            @JsonProperty("price") final BigDecimal price,
            @JsonProperty("time") final Long time) {
        this.price = price;
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equal(price, point.price) &&
                Objects.equal(time, point.time);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price, time);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("price", price)
                .add("time", time)
                .toString();
    }
}
