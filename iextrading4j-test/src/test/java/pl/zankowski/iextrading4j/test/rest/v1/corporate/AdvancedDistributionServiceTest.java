package pl.zankowski.iextrading4j.test.rest.v1.corporate;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.corporate.AdvancedDistribution;
import pl.zankowski.iextrading4j.client.rest.request.corporate.AdvancedDistributionRequestBuilder;
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

public class AdvancedDistributionServiceTest  extends BaseIEXCloudV1ServiceTest {

    @Test
    void advancedBonusServiceTest() {
        stubFor(get(urlEqualTo(path("/time-series/advanced_distribution/KERRF")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/corporate/AdvancedDistributionResponse.json")));

        final List<AdvancedDistribution> advancedDistributions = cloudClient.executeRequest(new AdvancedDistributionRequestBuilder()
                .withSymbol("KERRF")
                .build());

        final AdvancedDistribution advancedDistribution = advancedDistributions.get(0);
        assertThat(advancedDistribution.getSymbol()).isEqualTo("KERRF");
        assertThat(advancedDistribution.getExDate()).isEqualTo(LocalDate.of(2019, 11, 26));
        assertThat(advancedDistribution.getRecordDate()).isEqualTo(LocalDate.of(2019, 11, 19));
        assertThat(advancedDistribution.getPaymentDate()).isEqualTo(LocalDate.of(2019, 11, 29));
        assertThat(advancedDistribution.getWithdrawalFromDate()).isNull();
        assertThat(advancedDistribution.getWithdrawalToDate()).isNull();
        assertThat(advancedDistribution.getElectionDate()).isNull();
        assertThat(advancedDistribution.getFromFactor()).isEqualTo(BigDecimal.valueOf(3.451963));
        assertThat(advancedDistribution.getToFactor()).isEqualTo(BigDecimal.valueOf(1));
        assertThat(advancedDistribution.getRatio()).isEqualTo(BigDecimal.valueOf(3.451963));
        assertThat(advancedDistribution.getMinPrice()).isEqualTo(BigDecimal.ZERO);
        assertThat(advancedDistribution.getMaxPrice()).isEqualTo(BigDecimal.ZERO);
        assertThat(advancedDistribution.getDescription()).isEqualTo("Ordinary Shares");
        assertThat(advancedDistribution.getFlag()).isEqualTo("Stock");
        assertThat(advancedDistribution.getSecurityType()).isEqualTo("Equity Shares");
        assertThat(advancedDistribution.getHasWithdrawalRights()).isEqualTo(BigDecimal.ONE);
        assertThat(advancedDistribution.getNotes()).isEqualTo("(As on 09/10/2019) CAB<BR>SITUATION:      CAPITAL REDUCTION AND DEMERGER <BR>");
        assertThat(advancedDistribution.getFigi()).isEqualTo("BBG00N70C5N1");
        assertThat(advancedDistribution.getLastUpdated()).isEqualTo(LocalDate.of(2019, 11, 21));
        assertThat(advancedDistribution.getCountryCode()).isEqualTo("US");
        assertThat(advancedDistribution.getParValue()).isEqualByComparingTo(BigDecimal.valueOf(0.0001));
        assertThat(advancedDistribution.getParValueCurrency()).isEqualTo("GBP");
        assertThat(advancedDistribution.getRefid()).isEqualTo("6008685");
        assertThat(advancedDistribution.getCreated()).isEqualTo(LocalDate.of(2019, 10, 9));
        assertThat(advancedDistribution.getId()).isEqualTo("ADVANCED_DISTRIBUTION");
        assertThat(advancedDistribution.getSource()).isEqualTo("IEX Cloud");
        assertThat(advancedDistribution.getKey()).isEqualTo("KERRF");
        assertThat(advancedDistribution.getSubkey()).isEqualTo("6008685");
        assertThat(advancedDistribution.getDate()).isEqualTo(1574726400000L);
        assertThat(advancedDistribution.getUpdated()).isEqualTo(1574691580000L);
    }
}
