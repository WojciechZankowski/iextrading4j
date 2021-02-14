package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.Dividends;
import pl.zankowski.iextrading4j.client.rest.request.stocks.DividendRange;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.DividendsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class DividendsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void dividendsServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/dividends/1m")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/DividendsResponse.json")));

        final List<Dividends> dividendsList = cloudClient.executeRequest(new DividendsRequestBuilder()
                .withDividendRange(DividendRange.ONE_MONTH)
                .withSymbol("AAPL")
                .build());

        final Dividends dividends = dividendsList.get(0);
        assertThat(dividends.getSymbol()).isEqualTo("AAPL");
        assertThat(dividends.getExDate()).isEqualTo(LocalDate.of(2019, 5, 10));
        assertThat(dividends.getPaymentDate()).isEqualTo(LocalDate.of(2019, 5, 16));
        assertThat(dividends.getRecordDate()).isEqualTo(LocalDate.of(2019, 5, 13));
        assertThat(dividends.getDeclaredDate()).isEqualTo(LocalDate.of(2019, 4, 30));
        assertThat(dividends.getAmount()).isEqualTo(BigDecimal.valueOf(0.77));
        assertThat(dividends.getFlag()).isEqualTo("Increase");
        assertThat(dividends.getCurrency()).isEqualTo("USD");
        assertThat(dividends.getDescription()).isEqualTo("Apple Hikes Quarterly Dividend 5.5%");
        assertThat(dividends.getFrequency()).isEqualTo("Quarterly");
        assertThat(dividends.getDate()).isEqualTo(1574121600000L);
    }

    @Test
    public void dividendsServiceWithErrorsTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/dividends/1m")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/DividendsWithErrorsResponse.json")));

        final List<Dividends> dividendsList = cloudClient.executeRequest(new DividendsRequestBuilder()
                .withDividendRange(DividendRange.ONE_MONTH)
                .withSymbol("AAPL")
                .build());

        final Dividends dividends = dividendsList.get(0);
        assertThat(dividends.getSymbol()).isEqualTo("AAPL");
        assertThat(dividends.getExDate()).isEqualTo(LocalDate.of(2019, 5, 10));
        assertThat(dividends.getPaymentDate()).isEqualTo(LocalDate.of(2019, 5, 16));
        assertThat(dividends.getRecordDate()).isEqualTo(LocalDate.of(2019, 5, 13));
        assertThat(dividends.getDeclaredDate()).isNull();
        assertThat(dividends.getAmount()).isEqualTo(BigDecimal.valueOf(0.77));
        assertThat(dividends.getFlag()).isEqualTo("Increase");
        assertThat(dividends.getCurrency()).isEqualTo("USD");
        assertThat(dividends.getDescription()).isEqualTo("Apple Hikes Quarterly Dividend 5.5%");
        assertThat(dividends.getFrequency()).isEqualTo("Quarterly");
    }

}
