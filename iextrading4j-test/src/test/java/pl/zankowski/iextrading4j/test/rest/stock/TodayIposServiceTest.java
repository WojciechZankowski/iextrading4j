package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Ipo;
import pl.zankowski.iextrading4j.api.stocks.IpoSummary;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.api.stocks.TodayIpos;
import pl.zankowski.iextrading4j.client.rest.request.stocks.TodayIposRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class TodayIposServiceTest extends BaseRestServiceTest {

    @Test
    public void todayIposServiceTest() {
        stubFor(get(urlEqualTo("/stock/market/today-ipos"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/TodayIposResponse.json")));

        final TodayIpos ipos = iexTradingClient.executeRequest(new TodayIposRequestBuilder()
                .build());

        final Ipo ipo = ipos.getRawData().get(0);
        assertThat(ipo.getSymbol()).isEqualTo("ALZH");
        assertThat(ipo.getCompanyName()).isEqualTo("ALZHEON, INC.");
        assertThat(ipo.getExpectedDate()).isEqualTo(LocalDate.of(2018, 11, 9));
        assertThat(ipo.getLeadUnderwriters()).containsExactly("H.C. Wainwright & Co., LLC",
                "ThinkEquity, a division of Fordham Financial Management, Inc");
        assertThat(ipo.getUnderwriters()).containsExactly("The Benchmark Company, LLC");
        assertThat(ipo.getCompanyCounsel()).containsExactly("Latham & Watkins LLP");
        assertThat(ipo.getUnderwriterCounsel()).containsExactly("Mintz, Levin, Cohn, Ferris, Glovsky and Popeo, P.C.");
        assertThat(ipo.getAuditor()).isEqualTo("American Stock Transfer & Trust Company, LLC");
        assertThat(ipo.getMarket()).isEqualTo("NASDAQ Capital");
        assertThat(ipo.getCik()).isEqualTo("0001582636");
        assertThat(ipo.getAddress()).isEqualTo("111 SPEEN STREET");
        assertThat(ipo.getCity()).isEqualTo("FRAMINGHAM");
        assertThat(ipo.getState()).isEqualTo("MA");
        assertThat(ipo.getZip()).isEqualTo("01701");
        assertThat(ipo.getPhone()).isEqualTo("857-214-7242");
        assertThat(ipo.getCeo()).isEqualTo("Martin Tolar");
        assertThat(ipo.getEmployees()).isEqualTo(BigDecimal.valueOf(6));
        assertThat(ipo.getUrl()).isEqualTo("www.alzheon.com");
        assertThat(ipo.getStatus()).isEqualTo("Filed");
        assertThat(ipo.getSharesOffered()).isEqualTo(BigDecimal.valueOf(6000000));
        assertThat(ipo.getPriceLow()).isEqualTo(BigDecimal.valueOf(4));
        assertThat(ipo.getPriceHigh()).isEqualTo(BigDecimal.valueOf(6));
        assertThat(ipo.getOfferAmount()).isNull();
        assertThat(ipo.getTotalExpenses()).isEqualTo(BigDecimal.valueOf(1500000));
        assertThat(ipo.getSharesOverAlloted()).isEqualTo(BigDecimal.valueOf(900000));
        assertThat(ipo.getShareholderShares()).isNull();
        assertThat(ipo.getSharesOutstanding()).isEqualTo(BigDecimal.valueOf(16268967));
        assertThat(ipo.getLockupPeriodExpiration()).isNull();
        assertThat(ipo.getQuietPeriodExpiration()).isNull();
        assertThat(ipo.getRevenue()).isEqualTo(BigDecimal.ZERO);
        assertThat(ipo.getNetIncome()).isEqualTo(BigDecimal.valueOf(-5578000));
        assertThat(ipo.getTotalAssets()).isEqualTo(BigDecimal.valueOf(3252000));
        assertThat(ipo.getTotalLiabilities()).isEqualTo(BigDecimal.valueOf(1782000));
        assertThat(ipo.getStockholderEquity()).isEqualTo(BigDecimal.valueOf(1470000));
        assertThat(ipo.getCompanyDescription()).isEqualTo("company description");
        assertThat(ipo.getBusinessDescription()).isEqualTo("business description");
        assertThat(ipo.getUseOfProceeds()).isEqualTo("use of proceeds");
        assertThat(ipo.getCompetition()).isEqualTo("competition");
        assertThat(ipo.getAmount()).isEqualTo(BigDecimal.valueOf(30000000));
        assertThat(ipo.getPercentOffered()).isEqualTo(BigDecimal.valueOf(36.88));

        final IpoSummary ipoSummary = ipos.getViewData().get(0);
        assertThat(ipoSummary.getCompany()).isEqualTo("ALZHEON, INC.");
        assertThat(ipoSummary.getSymbol()).isEqualTo("ALZH");
        assertThat(ipoSummary.getPrice()).isEqualTo("$4.00 - 6.00");
        assertThat(ipoSummary.getShares()).isEqualTo("6,000,000");
        assertThat(ipoSummary.getAmount()).isEqualTo("30,000,000");
        assertThat(ipoSummary.getFloat()).isEqualTo("16,268,967");
        assertThat(ipoSummary.getPercent()).isEqualTo("36.88%");
        assertThat(ipoSummary.getMarket()).isEqualTo("NASDAQ Capital");
        assertThat(ipoSummary.getExpected()).isEqualTo("2018-11-09");

        final Quote quote = ipoSummary.getQuote();
        assertThat(quote.getChangePercent()).isEqualTo(BigDecimal.valueOf(0.9584615384615385));
        assertThat(quote.getLatestPrice()).isEqualTo(BigDecimal.valueOf(25.46));

        assertThat(ipos.getLastUpdate()).isEqualTo(LocalDate.of(2018, 11, 8));
    }
}
