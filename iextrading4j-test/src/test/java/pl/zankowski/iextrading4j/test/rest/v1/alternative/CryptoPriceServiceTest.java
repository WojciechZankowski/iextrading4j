package pl.zankowski.iextrading4j.test.rest.v1.alternative;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.alternative.CryptoPrice;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CryptoPriceRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

class CryptoPriceServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void cryptoServiceTest() {
        stubFor(get(urlEqualTo(path("/crypto/BTCUSD/price")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/alternative/CryptoPriceResponse.json")));

        final CryptoPrice price = cloudClient.executeRequest(new CryptoPriceRequestBuilder()
                .withSymbol("BTCUSD")
                .build());

        assertThat(price.getPrice()).isEqualTo(BigDecimal.valueOf(8324.08));
        assertThat(price.getSymbol()).isEqualTo("BTCUSD");
    }

}
