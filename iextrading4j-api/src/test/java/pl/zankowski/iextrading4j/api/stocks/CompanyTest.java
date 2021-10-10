package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompanyTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final String companyName = fixture.create(String.class);
        final String exchange = fixture.create(String.class);
        final String industry = fixture.create(String.class);
        final String website = fixture.create(String.class);
        final String description = fixture.create(String.class);
        final String ceo = fixture.create(String.class);
        final String securityName = fixture.create(String.class);
        final String issueType = fixture.create(String.class);
        final String sector = fixture.create(String.class);
        final BigDecimal employees = fixture.create(BigDecimal.class);
        final List<String> tags = Lists.newArrayList(fixture.collections().createCollection(String.class));
        final String address = fixture.create(String.class);
        final String address2 = fixture.create(String.class);
        final String state = fixture.create(String.class);
        final String city = fixture.create(String.class);
        final String zip = fixture.create(String.class);
        final String country = fixture.create(String.class);
        final String phone = fixture.create(String.class);
        final String primarySicCode = fixture.create(String.class);

        final Company company = new Company(symbol, companyName, exchange,
                industry, website, description, ceo, securityName, issueType, sector, employees, tags, address,
                address2, state, city, zip, country, phone, primarySicCode);

        assertThat(company.getSymbol()).isEqualTo(symbol);
        assertThat(company.getCompanyName()).isEqualTo(companyName);
        assertThat(company.getExchange()).isEqualTo(exchange);
        assertThat(company.getIndustry()).isEqualTo(industry);
        assertThat(company.getWebsite()).isEqualTo(website);
        assertThat(company.getDescription()).isEqualTo(description);
        assertThat(company.getCEO()).isEqualTo(ceo);
        assertThat(company.getIssueType()).isEqualTo(issueType);
        assertThat(company.getSector()).isEqualTo(sector);
        assertThat(company.getTags()).isEqualTo(tags);
        assertThat(company.getSecurityName()).isEqualTo(securityName);
        assertThat(company.getEmployees()).isEqualByComparingTo(employees);
        assertThat(company.getAddress()).isEqualTo(address);
        assertThat(company.getAddress2()).isEqualTo(address2);
        assertThat(company.getState()).isEqualTo(state);
        assertThat(company.getCity()).isEqualTo(city);
        assertThat(company.getZip()).isEqualTo(zip);
        assertThat(company.getCountry()).isEqualTo(country);
        assertThat(company.getPhone()).isEqualTo(phone);
        assertThat(company.getPrimarySicCode()).isEqualTo(primarySicCode);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Company.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Company.class))
                .verify();
    }

}
