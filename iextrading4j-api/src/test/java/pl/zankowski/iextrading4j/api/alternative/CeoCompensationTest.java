package pl.zankowski.iextrading4j.api.alternative;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CeoCompensationTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final String name = fixture.create(String.class);
        final String companyName = fixture.create(String.class);
        final String location = fixture.create(String.class);
        final BigDecimal salary = fixture.create(BigDecimal.class);
        final BigDecimal bonus = fixture.create(BigDecimal.class);
        final BigDecimal stockAwards = fixture.create(BigDecimal.class);
        final BigDecimal optionAwards = fixture.create(BigDecimal.class);
        final BigDecimal nonEquityIncentives = fixture.create(BigDecimal.class);
        final BigDecimal pensionAndDeferred = fixture.create(BigDecimal.class);
        final BigDecimal otherComp = fixture.create(BigDecimal.class);
        final BigDecimal total = fixture.create(BigDecimal.class);
        final String year = fixture.create(String.class);

        final CeoCompensation ceoCompensation = new CeoCompensation(symbol, name, companyName,
                location, salary, bonus, stockAwards, optionAwards, nonEquityIncentives,
                pensionAndDeferred, otherComp, total, year);

        assertThat(ceoCompensation.getSymbol()).isEqualTo(symbol);
        assertThat(ceoCompensation.getName()).isEqualTo(name);
        assertThat(ceoCompensation.getCompanyName()).isEqualTo(companyName);
        assertThat(ceoCompensation.getLocation()).isEqualTo(location);
        assertThat(ceoCompensation.getSalary()).isEqualTo(salary);
        assertThat(ceoCompensation.getBonus()).isEqualTo(bonus);
        assertThat(ceoCompensation.getStockAwards()).isEqualTo(stockAwards);
        assertThat(ceoCompensation.getOptionAwards()).isEqualTo(optionAwards);
        assertThat(ceoCompensation.getNonEquityIncentives()).isEqualTo(nonEquityIncentives);
        assertThat(ceoCompensation.getPensionAndDeferred()).isEqualTo(pensionAndDeferred);
        assertThat(ceoCompensation.getOtherComp()).isEqualTo(otherComp);
        assertThat(ceoCompensation.getTotal()).isEqualTo(total);
        assertThat(ceoCompensation.getYear()).isEqualTo(year);
    }


    @Test
    void equalsContract() {
        EqualsVerifier.forClass(CeoCompensation.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CeoCompensation.class))
                .verify();
    }

}
