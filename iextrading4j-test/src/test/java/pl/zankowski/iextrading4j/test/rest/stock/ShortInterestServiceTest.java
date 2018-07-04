package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.Flag;
import pl.zankowski.iextrading4j.api.stocks.ShortInterest;
import pl.zankowski.iextrading4j.client.rest.request.stocks.ShortInterestRequestBuilder;
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

public class ShortInterestServiceTest extends BaseRestServiceTest {

    @Test
    public void shortInterestServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/short-interest/"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/ShortInterestResponse.json")));

        final List<ShortInterest> shortInterestList = iexTradingClient.executeRequest(new ShortInterestRequestBuilder()
                .withSymbol("aapl")
                .build());

        assertThat(shortInterestList).hasSize(1);

        final ShortInterest shortInterest = shortInterestList.get(0);
        assertThat(shortInterest.getSettlementDate()).isEqualTo(LocalDate.of(2017, 10, 13));
        assertThat(shortInterest.getSecurityName()).isEqualTo("ZIEXT Common Stock");
        assertThat(shortInterest.getCurrentShortInterest()).isEqualByComparingTo(BigDecimal.valueOf(5363));
        assertThat(shortInterest.getPreviousShortInterest()).isEqualByComparingTo(BigDecimal.valueOf(5730));
        assertThat(shortInterest.getPercentChange()).isEqualByComparingTo(BigDecimal.valueOf(-0.064049));
        assertThat(shortInterest.getAverageDailyVolume()).isEqualByComparingTo(BigDecimal.valueOf(2113));
        assertThat(shortInterest.getDaystoCover()).isEqualByComparingTo(BigDecimal.valueOf(2.54));
        assertThat(shortInterest.getStockAdjustmentFlag()).isEqualTo(Flag.NO);
        assertThat(shortInterest.getRevisionFlag()).isEqualTo(Flag.NO);
        assertThat(shortInterest.getSymbolInINETSymbology()).isEqualTo("ZIEXT");
        assertThat(shortInterest.getSymbolInCQSSymbology()).isEqualTo("ZIEXT");
        assertThat(shortInterest.getSymbolInCMSSymbology()).isEqualTo("ZIEXT");
        assertThat(shortInterest.getNewIssueFlag()).isEqualTo(Flag.NO);
        assertThat(shortInterest.getCompanyName()).isEqualTo("ZIEXT Test Company");
    }
}
