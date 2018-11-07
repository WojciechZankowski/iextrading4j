package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@JsonPropertyOrder({"actualEPS", "consensusEPS", "estimatedEPS", "announceTime",
        "numberOfEstimates", "EPSSurpriseDollar", "EPSReportDate", "fiscalPeriod",
        "fiscalEndDate", "yearAgo", "yearAgoChangePercent", "estimatedChangePercent",
        "symbolId", "quote", "headline"})
public class TodayEarning extends Earning {

    private final Quote quote;
    private final String headline;

    @JsonCreator
    public TodayEarning(
            @JsonProperty("actualEPS") final BigDecimal actualEPS,
            @JsonProperty("consensusEPS") final BigDecimal consensusEPS,
            @JsonProperty("estimatedEPS") final BigDecimal estimatedEPS,
            @JsonProperty("announceTime") final String announceTime,
            @JsonProperty("numberOfEstimates") final BigDecimal numberOfEstimates,
            @JsonProperty("EPSSurpriseDollar") final BigDecimal EPSSurpriseDollar,
            @JsonProperty("EPSReportDate") final LocalDate EPSReportDate,
            @JsonProperty("fiscalPeriod") final String fiscalPeriod,
            @JsonProperty("fiscalEndDate") final LocalDate fiscalEndDate,
            @JsonProperty("yearAgo") final BigDecimal yearAgo,
            @JsonProperty("yearAgoChangePercent") final BigDecimal yearAgoChangePercent,
            @JsonProperty("estimatedChangePercent") final BigDecimal estimatedChangePercent,
            @JsonProperty("symbolId") final BigDecimal symbolId,
            @JsonProperty("quote") final Quote quote,
            @JsonProperty("headline") final String headline) {
        super(actualEPS, consensusEPS, estimatedEPS, announceTime, numberOfEstimates, EPSSurpriseDollar, EPSReportDate,
                fiscalPeriod, fiscalEndDate, yearAgo, yearAgoChangePercent, estimatedChangePercent, symbolId);
        this.quote = quote;
        this.headline = headline;
    }

    public Quote getQuote() {
        return quote;
    }

    public String getHeadline() {
        return headline;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final TodayEarning that = (TodayEarning) o;
        return Objects.equals(quote, that.quote) &&
                Objects.equals(headline, that.headline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quote, headline);
    }

    @Override
    public String toString() {
        return "TodayEarning{" +
                "quote=" + quote +
                ", headline='" + headline + '\'' +
                "} " + super.toString();
    }

}
