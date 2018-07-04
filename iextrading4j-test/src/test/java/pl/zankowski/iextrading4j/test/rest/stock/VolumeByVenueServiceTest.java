package pl.zankowski.iextrading4j.test.rest.stock;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.stocks.VenueVolume;
import pl.zankowski.iextrading4j.client.rest.request.stocks.VenueVolumeRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class VolumeByVenueServiceTest extends BaseRestServiceTest {

    @Test
    public void volumeByVenueServiceTest() {
        stubFor(get(urlEqualTo("/stock/aapl/volume-by-venue"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/stock/VolumeByVenueResponse.json")));

        final List<VenueVolume> venueVolumeList = iexTradingClient.executeRequest(new VenueVolumeRequestBuilder()
                .withSymbol("aapl")
                .build());

        final VenueVolume venueVolume = venueVolumeList.get(0);
        assertThat(venueVolume.getVolume()).isEqualTo(BigDecimal.valueOf(857742));
        assertThat(venueVolume.getVenue()).isEqualTo("BATS");
        assertThat(venueVolume.getVenueName()).isEqualTo("BATS BZX");
        assertThat(venueVolume.getDate()).isEqualTo(LocalDate.of(2017, 11, 17));
        assertThat(venueVolume.getMarketPercent()).isEqualTo(BigDecimal.valueOf(0.06388208913472272));
        assertThat(venueVolume.getAvgMarketPercent()).isEqualTo(BigDecimal.valueOf(0.05339074601492377));
    }

}
