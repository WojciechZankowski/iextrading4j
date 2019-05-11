package pl.zankowski.iextrading4j.test.rest.v1.account;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.account.Metadata;
import pl.zankowski.iextrading4j.client.rest.request.account.MetadataRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class MetadataServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void metadataServiceTest() {
        stubFor(get(urlEqualTo(secretPath("/account/metadata")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/account/MetadataResponse.json")));

        final Metadata metadata = cloudClient.executeRequest(new MetadataRequestBuilder()
                .build());

        assertThat(metadata.getOveragesEnabled()).isFalse();
        assertThat(metadata.getEffectiveDate()).isEqualTo(1551620046000L);
        assertThat(metadata.getEndDateEffective()).isNull();
        assertThat(metadata.getSubscriptionTermType()).isEqualTo("annual");
        assertThat(metadata.getTierName()).isEqualTo("start");
        assertThat(metadata.getMessageLimit()).isEqualTo(500000L);
        assertThat(metadata.getMessagesUsed()).isEqualTo(161L);
    }

}
