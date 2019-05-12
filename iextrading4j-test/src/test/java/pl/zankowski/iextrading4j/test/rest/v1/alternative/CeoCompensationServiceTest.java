package pl.zankowski.iextrading4j.test.rest.v1.alternative;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.alternative.CeoCompensation;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CeoCompensationRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class CeoCompensationServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void ceoCompensationServiceTest() {
        stubFor(get(urlEqualTo(path("/stock/AAPL/ceo-compensation")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/alternative/CeoCompensationResponse.json")));

        final CeoCompensation result = cloudClient.executeRequest(new CeoCompensationRequestBuilder()
                .withSymbol("AAPL")
                .build());

        assertThat(result.getSymbol()).isEqualTo("AVGO");
        assertThat(result.getName()).isEqualTo("Hock E. Tan");
        assertThat(result.getCompanyName()).isEqualTo("Broadcom Inc.");
        assertThat(result.getLocation()).isEqualTo("Singapore, Asia");
        assertThat(result.getSalary()).isEqualByComparingTo(BigDecimal.valueOf(1100000));
        assertThat(result.getBonus()).isEqualByComparingTo(BigDecimal.ZERO);
        assertThat(result.getStockAwards()).isEqualByComparingTo(BigDecimal.valueOf(98322843));
        assertThat(result.getOptionAwards()).isEqualByComparingTo(BigDecimal.ZERO);
        assertThat(result.getNonEquityIncentives()).isEqualByComparingTo(BigDecimal.valueOf(3712500));
        assertThat(result.getPensionAndDeferred()).isEqualTo(BigDecimal.ZERO);
        assertThat(result.getOtherComp()).isEqualTo(BigDecimal.valueOf(75820));
        assertThat(result.getTotal()).isEqualByComparingTo(BigDecimal.valueOf(103211163));
        assertThat(result.getYear()).isEqualTo("2017");
    }

}
