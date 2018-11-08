package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;

import java.time.LocalDate;
import java.util.List;

@JsonPropertyOrder({"rawData", "viewData", "lastUpdate"})
public class TodayIpos extends Ipos {

    private final LocalDate lastUpdate;

    @JsonCreator
    public TodayIpos(
            @JsonProperty("rawData") final List<Ipo> rawData,
            @JsonProperty("viewData") final List<IpoSummary> viewData,
            @JsonProperty("lastUpdate") final LocalDate lastUpdate) {
        super(rawData, viewData);
        this.lastUpdate = lastUpdate;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final TodayIpos todayIpos = (TodayIpos) o;
        return Objects.equal(lastUpdate, todayIpos.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), lastUpdate);
    }

    @Override
    public String toString() {
        return "TodayIpos{" +
                "lastUpdate=" + lastUpdate +
                "} " + super.toString();
    }

}
