package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompanyTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final String symbol = fixture.create(String.class);
        final String companyName = fixture.create(String.class);
        final String exchange = fixture.create(String.class);
        final String industry = fixture.create(String.class);
        final String website = fixture.create(String.class);
        final String description = fixture.create(String.class);
        final String ceo = fixture.create(String.class);
        final String issueType = fixture.create(String.class);
        final String sector = fixture.create(String.class);

        final Company company = new Company(symbol, companyName, exchange,
                industry, website, description, ceo, issueType, sector);

        assertThat(company.getSymbol()).isEqualTo(symbol);
        assertThat(company.getCompanyName()).isEqualTo(companyName);
        assertThat(company.getExchange()).isEqualTo(exchange);
        assertThat(company.getIndustry()).isEqualTo(industry);
        assertThat(company.getWebsite()).isEqualTo(website);
        assertThat(company.getDescription()).isEqualTo(description);
        assertThat(company.getCEO()).isEqualTo(ceo);
        assertThat(company.getIssueType()).isEqualTo(issueType);
        assertThat(company.getSector()).isEqualTo(sector);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Company.class)
                .usingGetClass()
                .verify();
    }

}
