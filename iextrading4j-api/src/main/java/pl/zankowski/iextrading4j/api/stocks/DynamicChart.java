package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import pl.zankowski.iextrading4j.api.util.ListUtil;

import java.io.Serializable;
import java.util.List;

@JsonPropertyOrder({"range", "data"})
public class DynamicChart implements Serializable {

    private final ChartRange range;
    private final List<Chart> data;

    @JsonCreator
    public DynamicChart(
            @JsonProperty("range") final ChartRange range,
            @JsonProperty("data") final List<Chart> data) {
        this.range = range;
        this.data = ListUtil.immutableList(data);
    }

    public ChartRange getRange() {
        return range;
    }

    public List<Chart> getData() {
        return data;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DynamicChart that = (DynamicChart) o;
        return range == that.range &&
                Objects.equal(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(range, data);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("range", range)
                .add("data", data)
                .toString();
    }
}
