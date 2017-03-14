package pl.zankowski.iextrading.rest.client.endpoint.market;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static pl.zankowski.iextrading.api.market.MarketVolumeDataBuilder.defaultMarketVolume;

import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

import pl.zankowski.iextrading.api.market.MarketVolume;
import pl.zankowski.iextrading.rest.client.endpoint.EndpointTestBase;

/**
 * @author Wojciech Zankowski
 */
public class MarketEndpointImplTest extends EndpointTestBase {

	final UriBuilder API_PATH = UriBuilder.fromPath("http://localhost:8080");

	@Test
	public void shouldCallMarketVolumePath() {
		final MarketVolume[] expectedMarketVolumes = new MarketVolume[]{defaultMarketVolume()};
		when(builderMock.get(MarketVolume[].class)).thenReturn(expectedMarketVolumes);

		MarketEndpoint marketEndpoint = new MarketEndpointImpl(clientMock, API_PATH);
		MarketVolume[] actualMarketVolumes = marketEndpoint.requestMarketVolume();

		assertThat(actualMarketVolumes).isEqualTo(expectedMarketVolumes);
		verifyCorrectPaths(MarketEndpointImpl.MARKET_PATH);
		verify(webTargetMock, times(0)).queryParam(any(), any());
	}

}
