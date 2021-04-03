package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IpoTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final String companyName = fixture.create(String.class);
        final LocalDate expectedDate = fixture.create(LocalDate.class);
        final List<String> leadUnderwriters = Lists.newArrayList(fixture.collections().createCollection(String.class));
        final List<String> underwriters = Lists.newArrayList(fixture.collections().createCollection(String.class));
        final List<String> companyCounsel = Lists.newArrayList(fixture.collections().createCollection(String.class));
        final List<String> underwriterCounsel = Lists.newArrayList(fixture.collections().createCollection(String.class));
        final String auditor = fixture.create(String.class);
        final String market = fixture.create(String.class);
        final String cik = fixture.create(String.class);
        final String address = fixture.create(String.class);
        final String city = fixture.create(String.class);
        final String state = fixture.create(String.class);
        final String zip = fixture.create(String.class);
        final String phone = fixture.create(String.class);
        final String ceo = fixture.create(String.class);
        final BigDecimal employees = fixture.create(BigDecimal.class);
        final String url = fixture.create(String.class);
        final String status = fixture.create(String.class);
        final BigDecimal sharesOffered = fixture.create(BigDecimal.class);
        final BigDecimal priceLow = fixture.create(BigDecimal.class);
        final BigDecimal priceHigh = fixture.create(BigDecimal.class);
        final BigDecimal offerAmount = fixture.create(BigDecimal.class);
        final BigDecimal totalExpenses = fixture.create(BigDecimal.class);
        final BigDecimal sharesOverAlloted = fixture.create(BigDecimal.class);
        final BigDecimal shareholderShares = fixture.create(BigDecimal.class);
        final BigDecimal sharesOutstanding = fixture.create(BigDecimal.class);
        final LocalDate lockupPeriodExpiration = fixture.create(LocalDate.class);
        final LocalDate quietPeriodExpiration = fixture.create(LocalDate.class);
        final BigDecimal revenue = fixture.create(BigDecimal.class);
        final BigDecimal netIncome = fixture.create(BigDecimal.class);
        final BigDecimal totalAssets = fixture.create(BigDecimal.class);
        final BigDecimal totalLiabilities = fixture.create(BigDecimal.class);
        final BigDecimal stockholderEquity = fixture.create(BigDecimal.class);
        final String companyDescription = fixture.create(String.class);
        final String businessDescription = fixture.create(String.class);
        final String useOfProceeds = fixture.create(String.class);
        final String competition = fixture.create(String.class);
        final BigDecimal amount = fixture.create(BigDecimal.class);
        final BigDecimal percentOffered = fixture.create(BigDecimal.class);

        final Ipo ipo = new Ipo(symbol, companyName, expectedDate, leadUnderwriters, underwriters, companyCounsel,
                underwriterCounsel, auditor, market, cik, address, city, state, zip, phone, ceo, employees, url,
                status, sharesOffered, priceLow, priceHigh, offerAmount, totalExpenses, sharesOverAlloted,
                shareholderShares, sharesOutstanding, lockupPeriodExpiration, quietPeriodExpiration, revenue,
                netIncome, totalAssets, totalLiabilities, stockholderEquity, companyDescription, businessDescription,
                useOfProceeds, competition, amount, percentOffered);

        assertThat(ipo.getSymbol()).isEqualTo(symbol);
        assertThat(ipo.getCompanyName()).isEqualTo(companyName);
        assertThat(ipo.getExpectedDate()).isEqualTo(expectedDate);
        assertThat(ipo.getLeadUnderwriters()).isEqualTo(leadUnderwriters);
        assertThat(ipo.getUnderwriters()).isEqualTo(underwriters);
        assertThat(ipo.getCompanyCounsel()).isEqualTo(companyCounsel);
        assertThat(ipo.getUnderwriterCounsel()).isEqualTo(underwriterCounsel);
        assertThat(ipo.getAuditor()).isEqualTo(auditor);
        assertThat(ipo.getMarket()).isEqualTo(market);
        assertThat(ipo.getCik()).isEqualTo(cik);
        assertThat(ipo.getAddress()).isEqualTo(address);
        assertThat(ipo.getCity()).isEqualTo(city);
        assertThat(ipo.getState()).isEqualTo(state);
        assertThat(ipo.getZip()).isEqualTo(zip);
        assertThat(ipo.getPhone()).isEqualTo(phone);
        assertThat(ipo.getCeo()).isEqualTo(ceo);
        assertThat(ipo.getEmployees()).isEqualTo(employees);
        assertThat(ipo.getUrl()).isEqualTo(url);
        assertThat(ipo.getStatus()).isEqualTo(status);
        assertThat(ipo.getSharesOffered()).isEqualTo(sharesOffered);
        assertThat(ipo.getPriceLow()).isEqualTo(priceLow);
        assertThat(ipo.getPriceHigh()).isEqualTo(priceHigh);
        assertThat(ipo.getOfferAmount()).isEqualTo(offerAmount);
        assertThat(ipo.getTotalExpenses()).isEqualTo(totalExpenses);
        assertThat(ipo.getSharesOverAlloted()).isEqualTo(sharesOverAlloted);
        assertThat(ipo.getShareholderShares()).isEqualTo(shareholderShares);
        assertThat(ipo.getSharesOutstanding()).isEqualTo(sharesOutstanding);
        assertThat(ipo.getLockupPeriodExpiration()).isEqualTo(lockupPeriodExpiration);
        assertThat(ipo.getQuietPeriodExpiration()).isEqualTo(quietPeriodExpiration);
        assertThat(ipo.getRevenue()).isEqualTo(revenue);
        assertThat(ipo.getNetIncome()).isEqualTo(netIncome);
        assertThat(ipo.getTotalAssets()).isEqualTo(totalAssets);
        assertThat(ipo.getTotalLiabilities()).isEqualTo(totalLiabilities);
        assertThat(ipo.getStockholderEquity()).isEqualTo(stockholderEquity);
        assertThat(ipo.getCompanyDescription()).isEqualTo(companyDescription);
        assertThat(ipo.getBusinessDescription()).isEqualTo(businessDescription);
        assertThat(ipo.getUseOfProceeds()).isEqualTo(useOfProceeds);
        assertThat(ipo.getCompetition()).isEqualTo(competition);
        assertThat(ipo.getAmount()).isEqualTo(amount);
        assertThat(ipo.getPercentOffered()).isEqualTo(percentOffered);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Ipo.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Ipo.class))
                .verify();
    }

}
