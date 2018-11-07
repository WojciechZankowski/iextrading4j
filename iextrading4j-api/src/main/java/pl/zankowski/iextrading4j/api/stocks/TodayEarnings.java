package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

@JsonPropertyOrder({"bto", "amc"})
public class TodayEarnings implements Serializable {

    private final List<TodayEarning> bto;
    private final List<TodayEarning> amc;

    @JsonCreator
    public TodayEarnings(
            @JsonProperty("bto") final List<TodayEarning> bto,
            @JsonProperty("amc") final List<TodayEarning> amc) {
        this.bto = immutableList(bto);
        this.amc = immutableList(amc);
    }

    public List<TodayEarning> getBto() {
        return bto;
    }

    public List<TodayEarning> getAmc() {
        return amc;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TodayEarnings that = (TodayEarnings) o;
        return Objects.equals(bto, that.bto) &&
                Objects.equals(amc, that.amc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bto, amc);
    }

    @Override
    public String toString() {
        return "TodayEarnings{" +
                "bto=" + bto +
                ", amc=" + amc +
                '}';
    }

}
