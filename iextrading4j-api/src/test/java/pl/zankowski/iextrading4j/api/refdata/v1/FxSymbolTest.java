package pl.zankowski.iextrading4j.api.refdata.v1;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FxSymbolTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final List<Currency> currencies = Lists.newArrayList(fixture.collections().createCollection(Currency.class));
        final List<Pair> pairs = Lists.newArrayList(fixture.collections().createCollection(Pair.class));

        final FxSymbol fxSymbol = new FxSymbol(currencies, pairs);

        assertThat(fxSymbol.getCurrencies()).isEqualTo(currencies);
        assertThat(fxSymbol.getPairs()).isEqualTo(pairs);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(FxSymbol.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(FxSymbol.class))
                .verify();
    }

}
