package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.OptionsSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class OptionsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    void optionsServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/options/symbols")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/OptionsSymbolsResponse.json")));

        final Map<String, List<String>> result = cloudClient.executeRequest(new OptionsSymbolsRequestBuilder().build());

        assertThat(result).hasSize(2);

        final List<String> dalOptions = result.get("DAL");
        assertThat(dalOptions).hasSize(1);
        assertThat(dalOptions.get(0)).isEqualTo("201904");

        final List<String> russOptions = result.get("RUSS");
        assertThat(russOptions).hasSize(1);
        assertThat(russOptions.get(0)).isEqualTo("201905");
    }

}
