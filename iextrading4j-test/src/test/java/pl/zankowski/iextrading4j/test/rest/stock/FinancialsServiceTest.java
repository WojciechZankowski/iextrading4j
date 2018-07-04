package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.Financial;
import pl.zankowski.iextrading4j.api.stocks.Financials;
import pl.zankowski.iextrading4j.client.rest.request.stocks.FinancialsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class FinancialsServiceTest extends BaseRestServiceTest {

    @Test
    public void financialsServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/financials"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/FinancialsResponse.json")));

        final Financials financials = iexTradingClient.executeRequest(new FinancialsRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(financials.getSymbol()).isEqualTo("AAPL");

        final List<Financial> financialList = financials.getFinancials();
        final Financial financial = financialList.get(0);
        assertThat(financial.getReportDate()).isEqualTo(LocalDate.of(2017, 9, 30));
        assertThat(financial.getGrossProfit()).isEqualTo(BigDecimal.valueOf(19931000000L));
        assertThat(financial.getCostOfRevenue()).isEqualTo(BigDecimal.valueOf(32648000000L));
        assertThat(financial.getOperatingRevenue()).isEqualTo(BigDecimal.valueOf(52579000000L));
        assertThat(financial.getTotalRevenue()).isEqualTo(BigDecimal.valueOf(52579000000L));
        assertThat(financial.getOperatingIncome()).isEqualTo(BigDecimal.valueOf(13120000000L));
        assertThat(financial.getNetIncome()).isEqualTo(BigDecimal.valueOf(10714000000L));
        assertThat(financial.getResearchAndDevelopment()).isEqualTo(BigDecimal.valueOf(2997000000L));
        assertThat(financial.getOperatingExpense()).isEqualTo(BigDecimal.valueOf(6811000000L));
        assertThat(financial.getCurrentAssets()).isEqualTo(BigDecimal.valueOf(128645000000L));
        assertThat(financial.getTotalAssets()).isEqualTo(BigDecimal.valueOf(375319000000L));
        assertThat(financial.getTotalLiabilities()).isEqualTo(BigDecimal.valueOf(241272000000L));
        assertThat(financial.getCurrentCash()).isEqualTo(BigDecimal.valueOf(20289000000L));
        assertThat(financial.getCurrentDebt()).isEqualTo(BigDecimal.valueOf(18473000000L));
        assertThat(financial.getTotalCash()).isEqualTo(BigDecimal.valueOf(74181000000L));
        assertThat(financial.getTotalDebt()).isEqualTo(BigDecimal.valueOf(115680000000L));
        assertThat(financial.getShareholderEquity()).isEqualTo(BigDecimal.valueOf(134047000000L));
        assertThat(financial.getCashChange()).isEqualTo(BigDecimal.valueOf(1718000000L));
        assertThat(financial.getCashFlow()).isEqualTo(BigDecimal.valueOf(15656000000L));
        assertThat(financial.getOperatingGainsLosses()).isNull();
    }

}
