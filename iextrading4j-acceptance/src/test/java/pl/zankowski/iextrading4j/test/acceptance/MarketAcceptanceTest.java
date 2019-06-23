package pl.zankowski.iextrading4j.test.acceptance;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.rest.request.market.MarketRequestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class MarketAcceptanceTest extends AcceptanceTestBase {

    @Test
    public void marketVolumeAcceptanceTest() {
        final List<MarketVolume> marketVolumeList = iexTradingClient.executeRequest(new MarketRequestBuilder()
                .build());
        assertThat(marketVolumeList).isNotNull();
    }

}
