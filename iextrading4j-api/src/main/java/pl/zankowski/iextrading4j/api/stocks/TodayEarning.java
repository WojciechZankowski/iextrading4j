package pl.zankowski.iextrading4j.api.stocks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({"actualEPS", "consensusEPS", "estimatedEPS", "announceTime",
        "numberOfEstimates", "EPSSurpriseDollar", "EPSReportDate", "fiscalPeriod",
        "fiscalEndDate", "yearAgo", "yearAgoChangePercent", "estimatedChangePercent",
        "symbolId", "symbol", "quote", "headline"})
public class TodayEarning extends Earning {

    private final String symbol;
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
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("quote") final Quote quote,
            @JsonProperty("headline") final String headline) {
        super(actualEPS, consensusEPS, estimatedEPS, announceTime, numberOfEstimates, EPSSurpriseDollar, EPSReportDate,
                fiscalPeriod, fiscalEndDate, yearAgo, yearAgoChangePercent, estimatedChangePercent, symbolId);
        this.symbol = symbol;
        this.quote = quote;
        this.headline = headline;
    }

    public String getSymbol() {
        return symbol;
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
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(quote, that.quote) &&
                Objects.equal(headline, that.headline);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), symbol, quote, headline);
    }

    @Override
    public String toString() {
        return "TodayEarning{" +
                "symbol='" + symbol + '\'' +
                ", quote=" + quote +
                ", headline='" + headline + '\'' +
                "} " + super.toString();
    }

}
