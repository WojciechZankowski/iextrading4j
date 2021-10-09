package pl.zankowski.iextrading4j.api.alternative;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class SentimentTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final BigDecimal sentiment = fixture.create(BigDecimal.class);
        final BigDecimal totalScores = fixture.create(BigDecimal.class);
        final BigDecimal positive = fixture.create(BigDecimal.class);
        final BigDecimal negative = fixture.create(BigDecimal.class);
        final LocalTime minute = fixture.create(LocalTime.class);

        final Sentiment sentimentObject = new Sentiment(sentiment, totalScores, positive,
                negative, minute);

        assertThat(sentimentObject.getSentiment()).isEqualTo(sentiment);
        assertThat(sentimentObject.getTotalScores()).isEqualTo(totalScores);
        assertThat(sentimentObject.getPositive()).isEqualTo(positive);
        assertThat(sentimentObject.getNegative()).isEqualTo(negative);
        assertThat(sentimentObject.getMinute()).isEqualTo(minute);
    }


    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Sentiment.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Sentiment.class))
                .verify();
    }

}
