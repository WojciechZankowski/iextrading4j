package pl.zankowski.iextrading4j.api.stocks.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;

public class RecommendationTrends implements Serializable {

    private final Long consensusEndDate;
    private final Long consensusStartDate;
    private final Long corporateActionsAppliedDate;
    private final BigDecimal ratingBuy;
    private final BigDecimal ratingHold;
    private final BigDecimal ratingNone;
    private final BigDecimal ratingOverweight;
    private final BigDecimal ratingScaleMark;
    private final BigDecimal ratingSell;
    private final BigDecimal ratingUnderweight;

    @JsonCreator
    public RecommendationTrends(
            @JsonProperty("consensusEndDate") final Long consensusEndDate,
            @JsonProperty("consensusStartDate") final Long consensusStartDate,
            @JsonProperty("corporateActionsAppliedDate") final Long corporateActionsAppliedDate,
            @JsonProperty("ratingBuy") final BigDecimal ratingBuy,
            @JsonProperty("ratingHold") final BigDecimal ratingHold,
            @JsonProperty("ratingNone") final BigDecimal ratingNone,
            @JsonProperty("ratingOverweight") final BigDecimal ratingOverweight,
            @JsonProperty("ratingScaleMark") final BigDecimal ratingScaleMark,
            @JsonProperty("ratingSell") final BigDecimal ratingSell,
            @JsonProperty("ratingUnderweight") final BigDecimal ratingUnderweight) {
        this.consensusEndDate = consensusEndDate;
        this.consensusStartDate = consensusStartDate;
        this.corporateActionsAppliedDate = corporateActionsAppliedDate;
        this.ratingBuy = ratingBuy;
        this.ratingHold = ratingHold;
        this.ratingNone = ratingNone;
        this.ratingOverweight = ratingOverweight;
        this.ratingScaleMark = ratingScaleMark;
        this.ratingSell = ratingSell;
        this.ratingUnderweight = ratingUnderweight;
    }

    public Long getConsensusEndDate() {
        return consensusEndDate;
    }

    public Long getConsensusStartDate() {
        return consensusStartDate;
    }

    public Long getCorporateActionsAppliedDate() {
        return corporateActionsAppliedDate;
    }

    public BigDecimal getRatingBuy() {
        return ratingBuy;
    }

    public BigDecimal getRatingHold() {
        return ratingHold;
    }

    public BigDecimal getRatingNone() {
        return ratingNone;
    }

    public BigDecimal getRatingOverweight() {
        return ratingOverweight;
    }

    public BigDecimal getRatingScaleMark() {
        return ratingScaleMark;
    }

    public BigDecimal getRatingSell() {
        return ratingSell;
    }

    public BigDecimal getRatingUnderweight() {
        return ratingUnderweight;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof RecommendationTrends)) return false;
        final RecommendationTrends that = (RecommendationTrends) o;
        return Objects.equal(consensusEndDate, that.consensusEndDate) &&
                Objects.equal(consensusStartDate, that.consensusStartDate) &&
                Objects.equal(corporateActionsAppliedDate, that.corporateActionsAppliedDate) &&
                Objects.equal(ratingBuy, that.ratingBuy) &&
                Objects.equal(ratingHold, that.ratingHold) &&
                Objects.equal(ratingNone, that.ratingNone) &&
                Objects.equal(ratingOverweight, that.ratingOverweight) &&
                Objects.equal(ratingScaleMark, that.ratingScaleMark) &&
                Objects.equal(ratingSell, that.ratingSell) &&
                Objects.equal(ratingUnderweight, that.ratingUnderweight);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(consensusEndDate, consensusStartDate, corporateActionsAppliedDate,
                ratingBuy, ratingHold, ratingNone, ratingOverweight, ratingScaleMark, ratingSell,
                ratingUnderweight);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("consensusEndDate", consensusEndDate)
                .add("consensusStartDate", consensusStartDate)
                .add("corporateActionsAppliedDate", corporateActionsAppliedDate)
                .add("ratingBuy", ratingBuy)
                .add("ratingHold", ratingHold)
                .add("ratingNone", ratingNone)
                .add("ratingOverweight", ratingOverweight)
                .add("ratingScaleMark", ratingScaleMark)
                .add("ratingSell", ratingSell)
                .add("ratingUnderweight", ratingUnderweight)
                .toString();
    }

}
