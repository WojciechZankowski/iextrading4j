package pl.zankowski.iextrading4j.api.alternative;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

public class Sentiment implements Serializable {

    private final BigDecimal sentiment;
    private final BigDecimal totalScores;
    private final String positive;
    private final String negative;
    @JsonFormat(pattern = "HHmm")
    private final LocalTime minute;

    @JsonCreator
    public Sentiment(
            @JsonProperty("sentiment") final BigDecimal sentiment,
            @JsonProperty("totalScores") final BigDecimal totalScores,
            @JsonProperty("positive") final String positive,
            @JsonProperty("negative") final String negative,
            @JsonProperty("minute") final LocalTime minute) {
        this.sentiment = sentiment;
        this.totalScores = totalScores;
        this.positive = positive;
        this.negative = negative;
        this.minute = minute;
    }

    public BigDecimal getSentiment() {
        return sentiment;
    }

    public BigDecimal getTotalScores() {
        return totalScores;
    }

    public String getPositive() {
        return positive;
    }

    public String getNegative() {
        return negative;
    }

    public LocalTime getMinute() {
        return minute;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Sentiment sentiment1 = (Sentiment) o;
        return Objects.equal(sentiment, sentiment1.sentiment) &&
                Objects.equal(totalScores, sentiment1.totalScores) &&
                Objects.equal(positive, sentiment1.positive) &&
                Objects.equal(negative, sentiment1.negative) &&
                Objects.equal(minute, sentiment1.minute);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sentiment, totalScores, positive, negative, minute);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("sentiment", sentiment)
                .add("totalScores", totalScores)
                .add("positive", positive)
                .add("negative", negative)
                .add("minute", minute)
                .toString();
    }

}
