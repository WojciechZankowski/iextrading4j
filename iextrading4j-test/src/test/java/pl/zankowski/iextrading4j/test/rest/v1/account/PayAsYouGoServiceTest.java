package pl.zankowski.iextrading4j.test.rest.v1.account;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.client.rest.request.account.PayAsYouGoRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class PayAsYouGoServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void payAsYouGoServiceTest() {
        stubFor(post(urlEqualTo("/account/payasyougo"))
                .withHeader("Accept", equalTo("application/json"))
                .withRequestBody(bodyContent(CLOUD_TOKEN.getSecretToken(), "\"allow\": false"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/account/PayAsYouGoResponse.json")));

        final String response = cloudClient.executeRequest(new PayAsYouGoRequestBuilder()
                .withDisallowed()
                .build());

        assertThat(response).isEqualTo("SUCCESS");
    }

}
