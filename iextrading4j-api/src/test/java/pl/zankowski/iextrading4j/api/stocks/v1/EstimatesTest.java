package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EstimatesTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final List<Estimate> estimate = Lists.newArrayList(fixture.collections().createCollection(Estimate.class));

        final Estimates estimates = new Estimates(symbol, estimate);

        assertThat(estimates.getSymbol()).isEqualTo(symbol);
        assertThat(estimates.getEstimates()).isEqualTo(estimate);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Estimates.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Estimates.class))
                .verify();
    }

}
