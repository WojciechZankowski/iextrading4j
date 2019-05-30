package pl.zankowski.iextrading4j.test.rest.v1.refdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.Sector;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.SectorRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.v1.BaseIEXCloudV1ServiceTest;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class SectorsServiceTest extends BaseIEXCloudV1ServiceTest {

    @Test
    public void sectorsServiceTest() {
        stubFor(get(urlEqualTo(path("/ref-data/sectors")))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/v1/refdata/SectorsResponse.json")));

        final List<Sector> result = cloudClient.executeRequest(new SectorRequestBuilder()
                .build());

        assertThat(result).hasSize(2);

        final Sector firstSector = result.get(0);
        assertThat(firstSector.getName()).isEqualTo("Electronic Technology");

        final Sector secondSector = result.get(1);
        assertThat(secondSector.getName()).isEqualTo("Distribution Services");
    }

}
