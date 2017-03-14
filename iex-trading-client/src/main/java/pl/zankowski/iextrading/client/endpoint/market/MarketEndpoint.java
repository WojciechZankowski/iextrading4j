package pl.zankowski.iextrading.client.endpoint.market;

import pl.zankowski.iextrading.api.filter.RequestFilter;
import pl.zankowski.iextrading.api.market.MarketVolume;

/**
 * @author Wojciech Zankowski
 */
public interface MarketEndpoint {

    MarketVolume[] requestMarketVolume();

    MarketVolume[] requestMarketVolume(RequestFilter requestFilter);

}
