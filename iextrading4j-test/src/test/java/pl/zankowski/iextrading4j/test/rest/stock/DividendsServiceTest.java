package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.DividendQualification;
import pl.zankowski.iextrading4j.api.stocks.DividendType;
import pl.zankowski.iextrading4j.api.stocks.Dividends;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DividendRange;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DividendsRequestBuilder;
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

public class DividendsServiceTest extends BaseRestServiceTest {

    @Test
    public void dividendsServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/dividends/1m"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/OneMonthDividendsResponse.json")));

        final List<Dividends> dividendsList = iexTradingClient.executeRequest(new DividendsRequestBuilder()
                .withDividendRange(DividendRange.ONE_MONTH)
                .withSymbol("aapl")
                .build());

        final Dividends dividends = dividendsList.get(0);
        assertThat(dividends.getExDate()).isEqualTo(LocalDate.of(2017, 11, 10));
        assertThat(dividends.getPaymentDate()).isEqualTo(LocalDate.of(2017, 11, 16));
        assertThat(dividends.getRecordDate()).isEqualTo(LocalDate.of(2017, 11, 13));
        assertThat(dividends.getDeclaredDate()).isEqualTo(LocalDate.of(2017, 11, 2));
        assertThat(dividends.getAmount()).isEqualTo(BigDecimal.valueOf(0.63));
        assertThat(dividends.getFlag()).isEqualTo("");
        assertThat(dividends.getType()).isEqualTo(DividendType.DIVIDEND_INCOME);
        assertThat(dividends.getQualified()).isEqualTo(DividendQualification.QUALIFIED_INCOME);
        assertThat(dividends.getIndicated()).isEqualTo("");
    }

}
