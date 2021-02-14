package pl.zankowski.iextrading4j.api.corporate;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvancedSplitsTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final String id = fixture.create(String.class);
        final String key = fixture.create(String.class);
        final String subkey = fixture.create(String.class);
        final Long updated = fixture.create(Long.class);
        final String refid = fixture.create(String.class);
        final String source = fixture.create(String.class);
        final Long date = fixture.create(Long.class);
        final LocalDate created = fixture.create(LocalDate.class);
        final LocalDate lastUpdated = fixture.create(LocalDate.class);
        final String notes = fixture.create(String.class);
        final String figi = fixture.create(String.class);
        final String description = fixture.create(String.class);
        final String flag = fixture.create(String.class);
        final String securityType = fixture.create(String.class);
        final BigDecimal fromFactor = fixture.create(BigDecimal.class);
        final BigDecimal toFactor = fixture.create(BigDecimal.class);
        final BigDecimal ratio = fixture.create(BigDecimal.class);
        final BigDecimal parValue = fixture.create(BigDecimal.class);
        final String parValueCurrency = fixture.create(String.class);
        final LocalDate exDate = fixture.create(LocalDate.class);
        final String countryCode = fixture.create(String.class);
        final LocalDate recordDate = fixture.create(LocalDate.class);
        final LocalDate paymentDate = fixture.create(LocalDate.class);
        final BigDecimal oldParValue = fixture.create(BigDecimal.class);
        final String oldParValueCurrency = fixture.create(String.class);
        final String splitType = fixture.create(String.class);

        final AdvancedSplits advancedSplits = new AdvancedSplits(symbol, id, key, subkey, updated, refid, source, date,
                created, lastUpdated, notes, figi, parValue, parValueCurrency, exDate, fromFactor, toFactor, ratio,
                description, flag, securityType, countryCode, recordDate, paymentDate, oldParValue,
                oldParValueCurrency, splitType);

        assertThat(advancedSplits.getSymbol()).isEqualTo(symbol);
        assertThat(advancedSplits.getId()).isEqualTo(id);
        assertThat(advancedSplits.getKey()).isEqualTo(key);
        assertThat(advancedSplits.getSubkey()).isEqualTo(subkey);
        assertThat(advancedSplits.getUpdated()).isEqualTo(updated);
        assertThat(advancedSplits.getRefid()).isEqualTo(refid);
        assertThat(advancedSplits.getSource()).isEqualTo(source);
        assertThat(advancedSplits.getDate()).isEqualTo(date);
        assertThat(advancedSplits.getCreated()).isEqualTo(created);
        assertThat(advancedSplits.getLastUpdated()).isEqualTo(lastUpdated);
        assertThat(advancedSplits.getNotes()).isEqualTo(notes);
        assertThat(advancedSplits.getFigi()).isEqualTo(figi);
        assertThat(advancedSplits.getParValue()).isEqualTo(parValue);
        assertThat(advancedSplits.getParValueCurrency()).isEqualTo(parValueCurrency);
        assertThat(advancedSplits.getExDate()).isEqualTo(exDate);
        assertThat(advancedSplits.getFromFactor()).isEqualTo(fromFactor);
        assertThat(advancedSplits.getToFactor()).isEqualTo(toFactor);
        assertThat(advancedSplits.getRatio()).isEqualTo(ratio);
        assertThat(advancedSplits.getDescription()).isEqualTo(description);
        assertThat(advancedSplits.getFlag()).isEqualTo(flag);
        assertThat(advancedSplits.getSecurityType()).isEqualTo(securityType);
        assertThat(advancedSplits.getCountryCode()).isEqualTo(countryCode);
        assertThat(advancedSplits.getRecordDate()).isEqualTo(recordDate);
        assertThat(advancedSplits.getPaymentDate()).isEqualTo(paymentDate);
        assertThat(advancedSplits.getOldParValue()).isEqualTo(oldParValue);
        assertThat(advancedSplits.getOldParValueCurrency()).isEqualTo(oldParValueCurrency);
        assertThat(advancedSplits.getSplitType()).isEqualTo(splitType);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(AdvancedSplits.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(AdvancedSplits.class))
                .verify();
    }

}
