package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.Tag;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.TagRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class TagsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void tagsServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/tags")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/TagsResponse.json")));

        final List<Tag> result = cloudClient.executeRequest(new TagRequestBuilder()
                .build());

        assertThat(result).hasSize(2);

        final Tag firstTag = result.get(0);
        assertThat(firstTag.getName()).isEqualTo("Electronic Technology");

        final Tag secondTag = result.get(1);
        assertThat(secondTag.getName()).isEqualTo("Distribution Services");
    }

}
