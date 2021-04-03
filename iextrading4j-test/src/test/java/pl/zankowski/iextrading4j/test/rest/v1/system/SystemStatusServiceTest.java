package pl.zankowski.iextrading4j.test.rest.v1.system;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.system.SystemStatus;
import pl.zankowski.iextrading4j.client.rest.request.system.SystemStatusRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class SystemStatusServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void systemStatusServiceTest() {
        stubFor(get(urlEqualTo(path("/status")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/system/SystemStatusResponse.json")));

        final SystemStatus systemStatus = cloudClient.executeRequest(new SystemStatusRequestBuilder()
                .build());

        assertThat(systemStatus.getStatus()).isEqualTo("up");
        assertThat(systemStatus.getVersion()).isEqualTo("1.9");
        assertThat(systemStatus.getTime()).isEqualTo(1562526609758L);
    }

}
