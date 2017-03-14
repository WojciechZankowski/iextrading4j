package pl.zankowski.iextrading.client.endpoint.market;

import pl.zankowski.iextrading.api.market.MarketVolume;
import pl.zankowski.iextrading.client.endpoint.Endpoint;

/**
 * @author Wojciech Zankowski
 */
public interface MarketEndpoint extends Endpoint {

    MarketVolume[] requestMarketVolume();

}
