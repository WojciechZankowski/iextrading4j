package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.IncomeStatement;
import pl.zankowski.iextrading4j.api.stocks.v1.IncomeStatements;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.IncomeStatementRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class IncomeStatementServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void incomeStatementServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/income")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/IncomeStatementResponse.json")));

        final IncomeStatements result = cloudClient.executeRequest(new IncomeStatementRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result.getSymbol()).isEqualTo("AAPL");
        assertThat(result.getIncome()).hasSize(1);

        final IncomeStatement incomeStatement = result.getIncome().get(0);
        assertThat(incomeStatement.getReportDate()).isEqualTo(LocalDate.of(2019, 3, 31));
        assertThat(incomeStatement.getTotalRevenue()).isEqualTo(BigDecimal.valueOf(57918000000L));
        assertThat(incomeStatement.getCostOfRevenue()).isEqualTo(BigDecimal.valueOf(36270000000L));
        assertThat(incomeStatement.getGrossProfit()).isEqualTo(BigDecimal.valueOf(21648000000L));
        assertThat(incomeStatement.getResearchAndDevelopment()).isEqualTo(BigDecimal.valueOf(3948000000L));
        assertThat(incomeStatement.getSellingGeneralAndAdmin()).isEqualTo(BigDecimal.valueOf(4458000000L));
        assertThat(incomeStatement.getOperatingExpense()).isEqualTo(BigDecimal.valueOf(44676000000L));
        assertThat(incomeStatement.getOperatingIncome()).isEqualTo(BigDecimal.valueOf(13242000000L));
        assertThat(incomeStatement.getOtherIncomeExpenseNet()).isEqualTo(BigDecimal.valueOf(551000000L));
        assertThat(incomeStatement.getEbit()).isEqualTo(BigDecimal.valueOf(13242000000L));
        assertThat(incomeStatement.getInterestIncome()).isEqualTo(BigDecimal.valueOf(1010000000L));
        assertThat(incomeStatement.getPretaxIncome()).isEqualTo(BigDecimal.valueOf(13793000000L));
        assertThat(incomeStatement.getIncomeTax()).isEqualTo(BigDecimal.valueOf(2232000000L));
        assertThat(incomeStatement.getMinorityInterest()).isEqualTo(BigDecimal.ZERO);
        assertThat(incomeStatement.getNetIncome()).isEqualTo(BigDecimal.valueOf(11561000000L));
        assertThat(incomeStatement.getNetIncomeBasic()).isEqualTo(BigDecimal.valueOf(11561000000L));
    }

}
