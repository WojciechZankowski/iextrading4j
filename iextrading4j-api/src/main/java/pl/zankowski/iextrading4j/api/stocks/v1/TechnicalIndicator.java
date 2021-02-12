package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import pl.zankowski.iextrading4j.api.stocks.Chart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

public class TechnicalIndicator implements Serializable {

    private static final long serialVersionUID = 8156047066786014613L;

    private final List<List<BigDecimal>> indicator;
    private final List<Chart> chart;

    @JsonCreator
    public TechnicalIndicator(
            @JsonProperty("indicator") final List<List<BigDecimal>> indicator,
            @JsonProperty("chart") final List<Chart> chart) {
        this.indicator = immutableList(indicator);
        this.chart = immutableList(chart);
    }

    public List<List<BigDecimal>> getIndicator() {
        return indicator;
    }

    public List<Chart> getChart() {
        return chart;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TechnicalIndicator that = (TechnicalIndicator) o;
        return Objects.equal(indicator, that.indicator) &&
                Objects.equal(chart, that.chart);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(indicator, chart);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("indicator", indicator)
                .add("chart", chart)
                .toString();
    }
}
