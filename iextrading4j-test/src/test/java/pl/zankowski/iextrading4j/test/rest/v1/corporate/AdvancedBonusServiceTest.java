package pl.zankowski.iextrading4j.test.rest.v1.corporate;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.corporate.AdvancedBonus;
import pl.zankowski.iextrading4j.client.rest.request.corporate.AdvancedBonusRequestBuilder;
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

public class AdvancedBonusServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void advancedBonusServiceTest() {
        stubFor(get(urlEqualTo(path("/time-series/advanced_bonus/AAPL")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/corporate/AdvancedBonusResponse.json")));

        final List<AdvancedBonus> advancedBonuses = cloudClient.executeRequest(new AdvancedBonusRequestBuilder()
                .withSymbol("AAPL")
                .build());

        final AdvancedBonus advancedBonus = advancedBonuses.get(0);
        assertThat(advancedBonus.getSymbol()).isEqualTo("BVHMF");
        assertThat(advancedBonus.getExDate()).isEqualTo(LocalDate.of(2020, 1, 3));
        assertThat(advancedBonus.getRecordDate()).isEqualTo(LocalDate.of(2020, 1, 2));
        assertThat(advancedBonus.getPaymentDate()).isEqualTo(LocalDate.of(2020, 1, 3));
        assertThat(advancedBonus.getFromFactor()).isEqualTo(BigDecimal.ONE);
        assertThat(advancedBonus.getToFactor()).isEqualTo(BigDecimal.valueOf(0.03819));
        assertThat(advancedBonus.getRatio()).isEqualTo(BigDecimal.valueOf(26.184865147944485));
        assertThat(advancedBonus.getDescription()).isEqualTo("Ordinary Shares");
        assertThat(advancedBonus.getFlag()).isEqualTo("Stock");
        assertThat(advancedBonus.getSecurityType()).isEqualTo("Equity Shares");
        assertThat(advancedBonus.getResultSecurityType()).isEqualTo("Equity Shares");
        assertThat(advancedBonus.getNotes()).isEqualTo("(As on 10/09/2019) CAB<BR><BR>SITUATION:     BONUS ISSUE <BR>");
        assertThat(advancedBonus.getFigi()).isEqualTo("BBG000FZ8989");
        assertThat(advancedBonus.getLastUpdated()).isEqualTo(LocalDate.of(2019, 11, 8));
        assertThat(advancedBonus.getCurrency()).isEmpty();
        assertThat(advancedBonus.getCountryCode()).isEqualTo("US");
        assertThat(advancedBonus.getParValue()).isEqualTo(BigDecimal.valueOf(0.5));
        assertThat(advancedBonus.getParValueCurrency()).isEqualTo("GBP");
        assertThat(advancedBonus.getLapsedPremium()).isEqualTo(BigDecimal.ZERO);
        assertThat(advancedBonus.getRefid()).isEqualTo("5951486");
        assertThat(advancedBonus.getCreated()).isEqualTo(LocalDate.of(2019, 9, 11));
        assertThat(advancedBonus.getId()).isEqualTo("ADVANCED_BONUS");
        assertThat(advancedBonus.getSource()).isEqualTo("IEX Cloud");
        assertThat(advancedBonus.getKey()).isEqualTo("BVHMF");
        assertThat(advancedBonus.getSubkey()).isEqualTo("5951486");
        assertThat(advancedBonus.getDate()).isEqualTo(1578009600000L);
        assertThat(advancedBonus.getUpdated()).isEqualTo(1574690010000L);
    }

}
