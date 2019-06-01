package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import com.github.tomakehurst.wiremock.matching.ContentPattern;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.SymbolMapping;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.IsinMapperRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class IsinServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void isinServiceTest() {
        stubFor(post(urlEqualTo("/ref-data/isin"))
                .withHeader("Accept", equalTo("application/json"))
                .withRequestBody(bodyContent(CLOUD_TOKEN.getPublishableToken(), "\"isin\": [\"US0378331005\"]"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/IsinResponse.json")));

        final List<List<SymbolMapping>> result = cloudClient.executeRequest(new IsinMapperRequestBuilder()
                .addIsin("US0378331005")
                .build());

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).hasSize(1);

        final SymbolMapping symbolMapping = result.get(0).get(0);
        assertThat(symbolMapping.getSymbol()).isEqualTo("foo");
        assertThat(symbolMapping.getExchange()).isEqualTo("NAS");
        assertThat(symbolMapping.getRegion()).isEqualTo("US");
        assertThat(symbolMapping.getIexId()).isEqualTo("IEX_4D48333344362D52");
    }

}
