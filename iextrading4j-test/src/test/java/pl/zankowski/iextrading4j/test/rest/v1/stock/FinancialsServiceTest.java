package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.Financial;
import pl.zankowski.iextrading4j.api.stocks.v1.Financials;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.FinancialsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class FinancialsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void financialsServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/financials")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/FinancialsResponse.json")));

        final Financials financials = cloudClient.executeRequest(new FinancialsRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(financials.getSymbol()).isEqualTo("AAPL");
        assertThat(financials.getFinancials()).hasSize(1);

        final Financial financial = financials.getFinancials().get(0);
        assertThat(financial.getReportDate()).isEqualTo(LocalDate.of(2019, 3, 31));
        assertThat(financial.getGrossProfit()).isEqualTo(BigDecimal.valueOf(21648000000L));
        assertThat(financial.getCostOfRevenue()).isEqualTo(BigDecimal.valueOf(36270000000L));
        assertThat(financial.getOperatingRevenue()).isEqualTo(BigDecimal.valueOf(57918000000L));
        assertThat(financial.getTotalRevenue()).isEqualTo(BigDecimal.valueOf(57918000000L));
        assertThat(financial.getOperatingIncome()).isEqualTo(BigDecimal.valueOf(13242000000L));
        assertThat(financial.getNetIncome()).isEqualTo(BigDecimal.valueOf(11561000000L));
        assertThat(financial.getResearchAndDevelopment()).isEqualTo(BigDecimal.valueOf(3948000000L));
        assertThat(financial.getOperatingExpense()).isEqualTo(BigDecimal.valueOf(44676000000L));
        assertThat(financial.getCurrentAssets()).isEqualTo(BigDecimal.valueOf(123346000000L));
        assertThat(financial.getTotalAssets()).isEqualTo(BigDecimal.valueOf(341998000000L));
        assertThat(financial.getTotalLiabilities()).isEqualTo(BigDecimal.valueOf(236138000000L));
        assertThat(financial.getCurrentCash()).isEqualTo(BigDecimal.valueOf(38329000000L));
        assertThat(financial.getCurrentDebt()).isEqualTo(BigDecimal.valueOf(22429000000L));
        assertThat(financial.getShortTermDebt()).isEqualTo(BigDecimal.valueOf(22429000000L));
        assertThat(financial.getLongTermDebt()).isEqualTo(BigDecimal.valueOf(90201000000L));
        assertThat(financial.getTotalCash()).isEqualTo(BigDecimal.valueOf(80433000000L));
        assertThat(financial.getTotalDebt()).isEqualTo(BigDecimal.valueOf(112630000000L));
        assertThat(financial.getShareholderEquity()).isEqualTo(BigDecimal.valueOf(105860000000L));
        assertThat(financial.getCashChange()).isEqualTo(BigDecimal.valueOf(-4954000000L));
        assertThat(financial.getCashFlow()).isEqualTo(BigDecimal.valueOf(11155000000L));
    }

}
