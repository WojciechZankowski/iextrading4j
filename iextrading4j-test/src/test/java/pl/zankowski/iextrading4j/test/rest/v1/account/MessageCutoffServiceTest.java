package pl.zankowski.iextrading4j.test.rest.v1.account;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.client.rest.request.account.MessageCutoffRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class MessageCutoffServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void messageCutoffServiceTest() {
        stubFor(post(urlEqualTo("/account/circuitbreaker"))
                .withHeader("Accept", equalTo("application/json"))
                .withRequestBody(bodyContent(CLOUD_TOKEN.getSecretToken(), "\"totalMessages\": 10000"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/account/MessageCutoffResponse.json")));

        final String response = cloudClient.executeRequest(new MessageCutoffRequestBuilder()
                .withTotalMessages(10000L)
                .build());

        assertThat(response).isEqualTo("SUCCESS");
    }
}
