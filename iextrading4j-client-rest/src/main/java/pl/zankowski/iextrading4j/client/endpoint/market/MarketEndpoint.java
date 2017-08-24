package pl.zankowski.iextrading4j.client.endpoint.market;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.endpoint.Endpoint;

/**
 * @author Wojciech Zankowski
 */
public interface MarketEndpoint extends Endpoint {

    MarketVolume[] requestMarketVolume();

    MarketVolume[] requestMarketVolume(RequestFilter requestFilter);

}
