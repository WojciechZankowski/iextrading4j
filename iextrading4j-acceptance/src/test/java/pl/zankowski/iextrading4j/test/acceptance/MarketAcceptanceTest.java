package pl.zankowski.iextrading4j.test.acceptance;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.rest.request.market.MarketRequestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
@Disabled
class MarketAcceptanceTest extends AcceptanceTestBase {

    @Test
    void marketVolumeAcceptanceTest() {
        final List<MarketVolume> marketVolumeList = iexTradingClient.executeRequest(new MarketRequestBuilder()
                .build());
        assertThat(marketVolumeList).isNotNull();
    }

}
