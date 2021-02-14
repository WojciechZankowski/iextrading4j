package pl.zankowski.iextrading4j.api.corporate;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvancedDistributionTest {

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
        final LocalDate withdrawalFromDate = fixture.create(LocalDate.class);
        final LocalDate withdrawalToDate = fixture.create(LocalDate.class);
        final LocalDate electionDate = fixture.create(LocalDate.class);
        final BigDecimal minPrice = fixture.create(BigDecimal.class);
        final BigDecimal maxPrice = fixture.create(BigDecimal.class);
        final BigDecimal hasWithdrawalRights = fixture.create(BigDecimal.class);

        final AdvancedDistribution advancedBonus = new AdvancedDistribution(symbol, id, key, subkey, updated, refid,
                source, date, created, lastUpdated, notes, figi, parValue, parValueCurrency, exDate, recordDate,
                paymentDate, withdrawalFromDate, withdrawalToDate, electionDate, fromFactor, toFactor, ratio,
                minPrice, maxPrice, description, flag, securityType, hasWithdrawalRights, countryCode);

        assertThat(advancedBonus.getSymbol()).isEqualTo(symbol);
        assertThat(advancedBonus.getId()).isEqualTo(id);
        assertThat(advancedBonus.getKey()).isEqualTo(key);
        assertThat(advancedBonus.getSubkey()).isEqualTo(subkey);
        assertThat(advancedBonus.getUpdated()).isEqualTo(updated);
        assertThat(advancedBonus.getRefid()).isEqualTo(refid);
        assertThat(advancedBonus.getSource()).isEqualTo(source);
        assertThat(advancedBonus.getDate()).isEqualTo(date);
        assertThat(advancedBonus.getCreated()).isEqualTo(created);
        assertThat(advancedBonus.getLastUpdated()).isEqualTo(lastUpdated);
        assertThat(advancedBonus.getNotes()).isEqualTo(notes);
        assertThat(advancedBonus.getFigi()).isEqualTo(figi);
        assertThat(advancedBonus.getParValue()).isEqualTo(parValue);
        assertThat(advancedBonus.getParValueCurrency()).isEqualTo(parValueCurrency);
        assertThat(advancedBonus.getExDate()).isEqualTo(exDate);
        assertThat(advancedBonus.getFromFactor()).isEqualTo(fromFactor);
        assertThat(advancedBonus.getToFactor()).isEqualTo(toFactor);
        assertThat(advancedBonus.getRatio()).isEqualTo(ratio);
        assertThat(advancedBonus.getDescription()).isEqualTo(description);
        assertThat(advancedBonus.getFlag()).isEqualTo(flag);
        assertThat(advancedBonus.getSecurityType()).isEqualTo(securityType);
        assertThat(advancedBonus.getCountryCode()).isEqualTo(countryCode);
        assertThat(advancedBonus.getRecordDate()).isEqualTo(recordDate);
        assertThat(advancedBonus.getPaymentDate()).isEqualTo(paymentDate);
        assertThat(advancedBonus.getWithdrawalToDate()).isEqualTo(withdrawalFromDate);
        assertThat(advancedBonus.getWithdrawalFromDate()).isEqualTo(withdrawalFromDate);
        assertThat(advancedBonus.getElectionDate()).isEqualTo(electionDate);
        assertThat(advancedBonus.getMinPrice()).isEqualTo(minPrice);
        assertThat(advancedBonus.getMaxPrice()).isEqualTo(maxPrice);
        assertThat(advancedBonus.getHasWithdrawalRights()).isEqualTo(hasWithdrawalRights);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(AdvancedDistribution.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(AdvancedDistribution.class))
                .verify();
    }



}
