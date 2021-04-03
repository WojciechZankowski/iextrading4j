package pl.zankowski.iextrading4j.test.rest.v1.corporate;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.corporate.AdvancedSplits;
import pl.zankowski.iextrading4j.client.rest.request.corporate.AdvancedSplitsRequestBuilder;
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

public class AdvancedSplitsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void advancedSplitsServiceTest() {
        stubFor(get(urlEqualTo(path("/time-series/advanced_splits/CRPYF")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/corporate/AdvancedSplitsResponse.json")));

        final List<AdvancedSplits> advancedSplits = cloudClient.executeRequest(new AdvancedSplitsRequestBuilder()
                .withSymbol("CRPYF")
                .build());

        final AdvancedSplits advancedSplit = advancedSplits.get(0);
        assertThat(advancedSplit.getSymbol()).isEqualTo("CRPYF");
        assertThat(advancedSplit.getExDate()).isEqualTo(LocalDate.of(2020, 1, 15));
        assertThat(advancedSplit.getFromFactor()).isEqualTo(BigDecimal.valueOf(10));
        assertThat(advancedSplit.getToFactor()).isEqualTo(BigDecimal.valueOf(1));
        assertThat(advancedSplit.getRatio()).isEqualTo(BigDecimal.valueOf(10));
        assertThat(advancedSplit.getDescription()).isEqualTo("Ordinary Shares");
        assertThat(advancedSplit.getFlag()).isEqualTo("Stock");
        assertThat(advancedSplit.getSecurityType()).isEqualTo("Equity Shares");
        assertThat(advancedSplit.getNotes()).isEqualTo(
                "(As on 07/11/2019) ZAJSE<BR>Share Consolidation<BR>It is intendVd tha:t following completion of the Proposed Transaction, the Company s issued share capital will be consolidated on the basis of 10 Ordinary Shares of 1 pence each for 1 new ordinary share of 10 pence (a  Consolidated Ordinary Share ), by reference to the Capital & Regional Shares in issue at 6.00 p.m. on 14 January 2020 on the UK Register");
        assertThat(advancedSplit.getFigi()).isEqualTo("BBG000CQTXJ4");
        assertThat(advancedSplit.getLastUpdated()).isEqualTo(LocalDate.of(2019, 11, 8));
        assertThat(advancedSplit.getCountryCode()).isEqualTo("US");
        assertThat(advancedSplit.getParValue()).isEqualByComparingTo(BigDecimal.valueOf(0.01));
        assertThat(advancedSplit.getParValueCurrency()).isEqualTo("GBP");
        assertThat(advancedSplit.getRefid()).isEqualTo("6057319");
        assertThat(advancedSplit.getCreated()).isEqualTo(LocalDate.of(2019, 11, 7));
        assertThat(advancedSplit.getId()).isEqualTo("ADVANCED_SPLITS");
        assertThat(advancedSplit.getSource()).isEqualTo("IEX Cloud");
        assertThat(advancedSplit.getKey()).isEqualTo("CRPYF");
        assertThat(advancedSplit.getSubkey()).isEqualTo("6057319");
        assertThat(advancedSplit.getDate()).isEqualTo(1579046400000L);
        assertThat(advancedSplit.getUpdated()).isEqualTo(1574689890000L);
        assertThat(advancedSplit.getRecordDate()).isEqualTo(LocalDate.of(2020, 1, 14));
        assertThat(advancedSplit.getPaymentDate()).isEqualTo(LocalDate.of(2020, 1, 15));
        assertThat(advancedSplit.getOldParValue()).isEqualByComparingTo(BigDecimal.valueOf(0.01));
        assertThat(advancedSplit.getOldParValueCurrency()).isEqualTo("GBP");
        assertThat(advancedSplit.getSplitType()).isEqualTo("Reverse Split");
    }

}
