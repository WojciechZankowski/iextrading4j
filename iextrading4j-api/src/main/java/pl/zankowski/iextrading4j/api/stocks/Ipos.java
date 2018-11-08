package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

@JsonPropertyOrder({"rawData", "viewData"})
public class Ipos implements Serializable {

    private final List<Ipo> rawData;
    private final List<IpoSummary> viewData;

    @JsonCreator
    public Ipos(
            @JsonProperty("rawData") final List<Ipo> rawData,
            @JsonProperty("viewData") final List<IpoSummary> viewData) {
        this.rawData = immutableList(rawData);
        this.viewData = immutableList(viewData);
    }

    public List<Ipo> getRawData() {
        return rawData;
    }

    public List<IpoSummary> getViewData() {
        return viewData;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ipos ipos = (Ipos) o;
        return Objects.equal(rawData, ipos.rawData) &&
                Objects.equal(viewData, ipos.viewData);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rawData, viewData);
    }

    @Override
    public String toString() {
        return "Ipos{" +
                "rawData=" + rawData +
                ", viewData=" + viewData +
                '}';
    }

}
