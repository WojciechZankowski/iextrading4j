package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class RecommendationTrendsTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final Long consensusEndDate = fixture.create(Long.class);
        final Long consensusStartDate = fixture.create(Long.class);
        final Long corporateActionsAppliedDate = fixture.create(Long.class);
        final BigDecimal ratingBuy = fixture.create(BigDecimal.class);
        final BigDecimal ratingHold = fixture.create(BigDecimal.class);
        final BigDecimal ratingNone = fixture.create(BigDecimal.class);
        final BigDecimal ratingOverweight = fixture.create(BigDecimal.class);
        final BigDecimal ratingScaleMark = fixture.create(BigDecimal.class);
        final BigDecimal ratingSell = fixture.create(BigDecimal.class);
        final BigDecimal ratingUnderweight = fixture.create(BigDecimal.class);

        final RecommendationTrends recommendationTrends = new RecommendationTrends(consensusEndDate,
                consensusStartDate, corporateActionsAppliedDate, ratingBuy, ratingHold, ratingNone,
                ratingOverweight, ratingScaleMark, ratingSell, ratingUnderweight);

        assertThat(recommendationTrends.getConsensusEndDate()).isEqualTo(consensusEndDate);
        assertThat(recommendationTrends.getConsensusStartDate()).isEqualTo(consensusStartDate);
        assertThat(recommendationTrends.getCorporateActionsAppliedDate()).isEqualTo(corporateActionsAppliedDate);
        assertThat(recommendationTrends.getRatingBuy()).isEqualTo(ratingBuy);
        assertThat(recommendationTrends.getRatingHold()).isEqualTo(ratingHold);
        assertThat(recommendationTrends.getRatingNone()).isEqualTo(ratingNone);
        assertThat(recommendationTrends.getRatingOverweight()).isEqualTo(ratingOverweight);
        assertThat(recommendationTrends.getRatingScaleMark()).isEqualTo(ratingScaleMark);
        assertThat(recommendationTrends.getRatingSell()).isEqualTo(ratingSell);
        assertThat(recommendationTrends.getRatingUnderweight()).isEqualTo(ratingUnderweight);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(RecommendationTrends.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(RecommendationTrends.class))
                .verify();
    }

}
