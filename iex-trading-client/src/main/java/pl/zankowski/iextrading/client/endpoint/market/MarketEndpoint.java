package pl.zankowski.iextrading.client.endpoint.market;

import pl.zankowski.iextrading.api.filter.RequestFilter;
import pl.zankowski.iextrading.api.market.MarketVolume;
import pl.zankowski.iextrading.client.endpoint.Endpoint;

/**
 * @author Wojciech Zankowski
 */
public interface MarketEndpoint extends Endpoint {

    MarketVolume[] requestMarketVolume();

    MarketVolume[] requestMarketVolume(RequestFilter requestFilter);

}
