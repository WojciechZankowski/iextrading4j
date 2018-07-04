package pl.zankowski.iextrading4j.test.rest.marketdata;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.api.marketdata.AuctionType;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.AuctionRequestBuilder;
import pl.zankowski.iextrading4j.test.rest.BaseRestServiceTest;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class AuctionServiceTest extends BaseRestServiceTest {

    @Test
    public void auctionServiceTest() {
        stubFor(get(urlEqualTo("/deep/auction?symbols=ZIEXT"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Accept", "application/json")
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("rest/marketdata/AuctionResponse.json")));

        final Map<String, Auction> auctionMap = iexTradingClient.executeRequest(new AuctionRequestBuilder()
                .withSymbol("ZIEXT")
                .build());

        final Auction auction = auctionMap.get("ZIEXT");
        assertThat(auction.getAuctionType()).isEqualTo(AuctionType.Open);
        assertThat(auction.getPairedShares()).isEqualTo(BigDecimal.valueOf(3600));
        assertThat(auction.getImbalanceShares()).isEqualTo(BigDecimal.valueOf(600));
        assertThat(auction.getReferencePrice()).isEqualTo(BigDecimal.valueOf(1.05));
        assertThat(auction.getIndicativePrice()).isEqualTo(BigDecimal.valueOf(1.05));
        assertThat(auction.getAuctionBookPrice()).isEqualTo(BigDecimal.valueOf(1.05));
        assertThat(auction.getCollarReferencePrice()).isEqualTo(BigDecimal.valueOf(1.05));
        assertThat(auction.getLowerCollarPrice()).isEqualTo(BigDecimal.valueOf(0.5));
        assertThat(auction.getUpperCollarPrice()).isEqualTo(BigDecimal.valueOf(1.6));
        assertThat(auction.getExtensionNumber()).isEqualTo(BigDecimal.ZERO);
        assertThat(auction.getStartTime()).isEqualTo(LocalTime.of(9, 30, 0));
        assertThat(auction.getLastUpdate()).isEqualTo(1506706199025L);
    }

}
