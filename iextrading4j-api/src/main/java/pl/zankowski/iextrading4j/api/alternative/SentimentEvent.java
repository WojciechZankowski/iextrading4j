package pl.zankowski.iextrading4j.api.alternative;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.io.Serializable;
import java.math.BigDecimal;

public class SentimentEvent implements Serializable {

    private static final long serialVersionUID = -4716020002316419582L;

    private final String symbol;
    private final BigDecimal score;
    private final BigDecimal sequence;
    private final BigDecimal date;

    @JsonCreator
    public SentimentEvent(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("score") final BigDecimal score,
            @JsonProperty("sequence") final BigDecimal sequence,
            @JsonProperty("date") final BigDecimal date) {
        this.symbol = symbol;
        this.score = score;
        this.sequence = sequence;
        this.date = date;
    }

    public String getSymbol() {
        return symbol;
    }
    
    public BigDecimal getScore() {
        return score;
    }

    public BigDecimal getSequence() {
        return sequence;
    }

    public BigDecimal getDate() {
        return date;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SentimentEvent sentiment1 = (SentimentEvent) o;
        return Objects.equal(symbol, sentiment1.symbol) &&
                Objects.equal(score, sentiment1.score) &&
                Objects.equal(sequence, sentiment1.sequence) &&
                Objects.equal(date, sentiment1.date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, score, sequence, date);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("score", score)
                .add("sequence", sequence)
                .add("date", date)
                .toString();
    }

}
