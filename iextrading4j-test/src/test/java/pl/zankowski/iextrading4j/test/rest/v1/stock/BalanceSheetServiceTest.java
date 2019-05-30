package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheet;
import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheets;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.BalanceSheetRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class BalanceSheetServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void balanceSheetServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/balance-sheet")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/BalanceSheetsResponse.json")));

        final BalanceSheets balanceSheets = cloudClient.executeRequest(new BalanceSheetRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(balanceSheets.getSymbol()).isEqualTo("AAPL");
        assertThat(balanceSheets.getBalanceSheet()).hasSize(1);

        final BalanceSheet balanceSheet = balanceSheets.getBalanceSheet().get(0);
        assertThat(balanceSheet.getReportDate()).isEqualTo(LocalDate.of(2019, 3, 31));
        assertThat(balanceSheet.getCurrentCash()).isEqualTo(BigDecimal.valueOf(38329000000L));
        assertThat(balanceSheet.getShortTermInvestments()).isEqualTo(BigDecimal.valueOf(42104000000L));
        assertThat(balanceSheet.getReceivables()).isEqualTo(BigDecimal.valueOf(15085000000L));
        assertThat(balanceSheet.getInventory()).isEqualTo(BigDecimal.valueOf(4884000000L));
        assertThat(balanceSheet.getOtherCurrentAssets()).isEqualTo(BigDecimal.valueOf(11751000000L));
        assertThat(balanceSheet.getCurrentAssets()).isEqualTo(BigDecimal.valueOf(123346000000L));
        assertThat(balanceSheet.getLongTermInvestments()).isEqualTo(BigDecimal.valueOf(146807000000L));
        assertThat(balanceSheet.getPropertyPlantEquipment()).isEqualTo(BigDecimal.valueOf(38746000000L));
        assertThat(balanceSheet.getGoodwill()).isEqualTo(BigDecimal.ZERO);
        assertThat(balanceSheet.getIntangibleAssets()).isEqualTo(BigDecimal.valueOf(38746000000L));
        assertThat(balanceSheet.getOtherAssets()).isEqualTo(BigDecimal.valueOf(33099000000L));
        assertThat(balanceSheet.getTotalAssets()).isEqualTo(BigDecimal.valueOf(341998000000L));
        assertThat(balanceSheet.getAccountsPayable()).isEqualTo(BigDecimal.valueOf(30443000000L));
        assertThat(balanceSheet.getCurrentLongTermDebt()).isEqualTo(BigDecimal.valueOf(10505000000L));
        assertThat(balanceSheet.getOtherCurrentLiabilities()).isEqualTo(BigDecimal.valueOf(40900000000L));
        assertThat(balanceSheet.getTotalCurrentLiabilities()).isEqualTo(BigDecimal.valueOf(93772000000L));
        assertThat(balanceSheet.getLongTermDebt()).isEqualTo(BigDecimal.valueOf(90201000000L));
        assertThat(balanceSheet.getOtherLiabilities()).isEqualTo(BigDecimal.valueOf(6279000000L));
        assertThat(balanceSheet.getMinorityInterest()).isEqualTo(BigDecimal.ZERO);
        assertThat(balanceSheet.getTotalLiabilities()).isEqualTo(BigDecimal.valueOf(236138000000L));
        assertThat(balanceSheet.getCommonStock()).isEqualTo(BigDecimal.valueOf(42801000000L));
        assertThat(balanceSheet.getRetainedEarnings()).isEqualTo(BigDecimal.valueOf(64558000000L));
        assertThat(balanceSheet.getTreasuryStock()).isNull();
        assertThat(balanceSheet.getCapitalSurplus()).isNull();
        assertThat(balanceSheet.getShareholderEquity()).isEqualTo(BigDecimal.valueOf(105860000000L));
        assertThat(balanceSheet.getNetTangibleAssets()).isEqualTo(BigDecimal.valueOf(105860000000L));
    }

}
