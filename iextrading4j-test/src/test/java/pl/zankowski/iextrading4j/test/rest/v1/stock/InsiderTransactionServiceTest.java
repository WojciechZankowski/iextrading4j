package pl.zankowski.iextrading4j.test.rest.v1.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.v1.DirectIndirect;
import pl.zankowski.iextrading4j.api.stocks.v1.InsiderTransaction;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.InsiderTransactionRequestBuilder;
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

public class InsiderTransactionServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void insiderTransactionServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/insider-transactions")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/stock/InsiderTransactionResponse.json")));

        final List<InsiderTransaction> result = cloudClient.executeRequest(new InsiderTransactionRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result).hasSize(1);

        final InsiderTransaction insiderTransaction = result.get(0);
        assertThat(insiderTransaction.getSymbol()).isEqualTo("TWTR");
        assertThat(insiderTransaction.getEffectiveDate()).isEqualTo(1590189080797L);
        assertThat(insiderTransaction.getFullName()).isEqualTo("Joe Smith");
        assertThat(insiderTransaction.getReportedTitle()).isEqualTo("Vice President");
        assertThat(insiderTransaction.getTransactionCode()).isEqualTo("S");
        assertThat(insiderTransaction.isIs10b51()).isFalse();
        assertThat(insiderTransaction.getPostShares()).isEqualTo(BigDecimal.valueOf(589673));
        assertThat(insiderTransaction.getTransactionDate()).isEqualTo(LocalDate.of(2019, 12, 29));
        assertThat(insiderTransaction.getTransactionPrice()).isEqualTo(BigDecimal.valueOf(32.3));
        assertThat(insiderTransaction.getTransactionShares()).isEqualTo(BigDecimal.valueOf(-1787));
        assertThat(insiderTransaction.getTransactionValue()).isEqualTo(BigDecimal.valueOf(56684));
        assertThat(insiderTransaction.getTranPrice()).isEqualTo(BigDecimal.valueOf(31.5));
        assertThat(insiderTransaction.getTranShares()).isEqualTo(BigDecimal.valueOf(-1753));
        assertThat(insiderTransaction.getTranValue()).isEqualTo(BigDecimal.valueOf(56402));
        assertThat(insiderTransaction.getDirectIndirect()).isEqualTo(DirectIndirect.DIRECT);
    }

}
