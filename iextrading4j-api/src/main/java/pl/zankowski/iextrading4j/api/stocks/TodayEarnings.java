package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

@JsonPropertyOrder({"bto", "amc", "other"})
public class TodayEarnings implements Serializable {

    private static final long serialVersionUID = -66409416779499106L;

    private final List<TodayEarning> bto;
    private final List<TodayEarning> amc;
    private final List<TodayEarning> other;

    @JsonCreator
    public TodayEarnings(
            @JsonProperty("bto") final List<TodayEarning> bto,
            @JsonProperty("amc") final List<TodayEarning> amc,
            @JsonProperty("other") final List<TodayEarning> other) {
        this.bto = immutableList(bto);
        this.amc = immutableList(amc);
        this.other = immutableList(other);
    }

    public List<TodayEarning> getBto() {
        return bto;
    }

    public List<TodayEarning> getAmc() {
        return amc;
    }

    public List<TodayEarning> getOther() {
        return other;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TodayEarnings that = (TodayEarnings) o;
        return Objects.equal(bto, that.bto) &&
                Objects.equal(amc, that.amc) &&
                Objects.equal(other, that.other);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bto, amc, other);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("bto", bto)
                .add("amc", amc)
                .add("other", other)
                .toString();
    }

}
