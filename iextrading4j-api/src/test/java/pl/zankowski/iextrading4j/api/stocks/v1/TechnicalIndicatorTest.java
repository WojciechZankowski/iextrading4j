package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.ImmutableList;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.Chart;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TechnicalIndicatorTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final List<BigDecimal> indicator = Lists.newArrayList(fixture.collections().createCollection(BigDecimal.class));
        final List<List<BigDecimal>> indicators = ImmutableList.<List<BigDecimal>>builder()
                .add(indicator)
                .build();
        final List<Chart> chart = Lists.newArrayList(fixture.collections().createCollection(Chart.class));

        final TechnicalIndicator technicalIndicator = new TechnicalIndicator(indicators, chart);

        assertThat(technicalIndicator.getIndicator()).isEqualTo(indicators);
        assertThat(technicalIndicator.getChart()).isEqualTo(chart);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(TechnicalIndicator.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(TechnicalIndicator.class))
                .verify();
    }

}
