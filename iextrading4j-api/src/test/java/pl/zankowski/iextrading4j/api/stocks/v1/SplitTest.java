package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class SplitTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final String id = fixture.create(String.class);
        final String key = fixture.create(String.class);
        final String subkey = fixture.create(String.class);
        final Long updated = fixture.create(Long.class);
        final Long date = fixture.create(Long.class);
        final LocalDate exDate = fixture.create(LocalDate.class);
        final LocalDate declaredDate = fixture.create(LocalDate.class);
        final BigDecimal ratio = fixture.create(BigDecimal.class);
        final BigDecimal toFactor = fixture.create(BigDecimal.class);
        final BigDecimal fromFactory = fixture.create(BigDecimal.class);
        final String description = fixture.create(String.class);
        final String refId = fixture.create(String.class);

        final Split split = new Split(symbol, id, key, subkey, updated, date, exDate, declaredDate, ratio, toFactor,
                fromFactory, description, refId);

        assertThat(split.getSymbol()).isEqualTo(symbol);
        assertThat(split.getId()).isEqualTo(id);
        assertThat(split.getKey()).isEqualTo(key);
        assertThat(split.getSubkey()).isEqualTo(subkey);
        assertThat(split.getUpdated()).isEqualTo(updated);
        assertThat(split.getDate()).isEqualTo(date);
        assertThat(split.getExDate()).isEqualTo(exDate);
        assertThat(split.getDeclaredDate()).isEqualTo(declaredDate);
        assertThat(split.getRatio()).isEqualTo(ratio);
        assertThat(split.getToFactor()).isEqualTo(toFactor);
        assertThat(split.getFromFactor()).isEqualTo(fromFactory);
        assertThat(split.getDescription()).isEqualTo(description);
        assertThat(split.getRefid()).isEqualTo(refId);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Split.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Split.class))
                .verify();
    }

}
