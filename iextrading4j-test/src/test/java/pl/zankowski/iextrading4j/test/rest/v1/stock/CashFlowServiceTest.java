package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.CashFlow;
import pl.zankowski.iextrading4j.api.stocks.v1.CashFlows;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.CashFlowRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class CashFlowServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void cashFlowServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/cash-flow")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/CashFlowResponse.json")));

        final CashFlows cashFlows = cloudClient.executeRequest(new CashFlowRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(cashFlows.getSymbol()).isEqualTo("AAPL");
        assertThat(cashFlows.getCashFlow()).hasSize(1);

        final CashFlow result = cashFlows.getCashFlow().get(0);
        assertThat(result.getReportDate()).isEqualTo(LocalDate.of(2019, 3, 31));
        assertThat(result.getNetIncome()).isEqualTo(BigDecimal.valueOf(11561000000L));
        assertThat(result.getDepreciation()).isEqualTo(BigDecimal.valueOf(3040000000L));
        assertThat(result.getChangesInReceivables()).isEqualTo(BigDecimal.valueOf(2992000000L));
        assertThat(result.getChangesInInventories()).isEqualTo(BigDecimal.valueOf(70000000L));
        assertThat(result.getCashChange()).isEqualTo(BigDecimal.valueOf(-4954000000L));
        assertThat(result.getCashFlow()).isEqualTo(BigDecimal.valueOf(11155000000L));
        assertThat(result.getCapitalExpenditures()).isEqualTo(BigDecimal.valueOf(-2363000000L));
        assertThat(result.getInvestments()).isEqualTo(BigDecimal.valueOf(15749000000L));
        assertThat(result.getInvestingActivityOther()).isEqualTo(BigDecimal.valueOf(56000000L));
        assertThat(result.getTotalInvestingCashFlows()).isEqualTo(BigDecimal.valueOf(13348000000L));
        assertThat(result.getDividendsPaid()).isEqualTo(BigDecimal.valueOf(-3443000000L));
        assertThat(result.getNetBorrowings()).isEqualTo(BigDecimal.valueOf(-2506000000L));
        assertThat(result.getOtherFinancingCashFlows()).isEqualTo(BigDecimal.valueOf(-196000000L));
        assertThat(result.getCashFlowFinancing()).isEqualTo(BigDecimal.valueOf(-29457000000L));
        assertThat(result.getExchangeRateEffect()).isNull();
    }

}
