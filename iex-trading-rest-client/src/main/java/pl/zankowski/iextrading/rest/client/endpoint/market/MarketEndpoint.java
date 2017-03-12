package pl.zankowski.iextrading.rest.client.endpoint.market;

import pl.zankowski.iextrading.api.market.MarketVolume;
import pl.zankowski.iextrading.rest.client.endpoint.Endpoint;

/**
 * @author Wojciech Zankowski
 */
public interface MarketEndpoint extends Endpoint {

    MarketVolume[] requestMarketVolume();

}
