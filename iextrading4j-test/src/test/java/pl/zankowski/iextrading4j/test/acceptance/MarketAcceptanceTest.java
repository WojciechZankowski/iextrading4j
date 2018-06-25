package pl.zankowski.iextrading4j.test.acceptance;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.rest.request.market.MarketRequestBuilder;

import java.util.List;

public class MarketAcceptanceTest extends AcceptanceTestBase {

    @Test
    public void marketVolumeAcceptanceTest() {
        final List<MarketVolume> marketVolumeList = iexTradingClient.executeRequest(new MarketRequestBuilder()
                .build());
    }

}
