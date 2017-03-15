package pl.zankowski.iextrading.client.endpoint.tops;

import pl.zankowski.iextrading.api.filter.RequestFilter;
import pl.zankowski.iextrading.api.tops.LastTrade;
import pl.zankowski.iextrading.api.tops.TOPS;
import pl.zankowski.iextrading.client.endpoint.Endpoint;

/**
 * @author Wojciech Zankowski
 */
public interface TOPSEndpoint extends Endpoint {

    TOPS[] requestTOPS(String... symbols);

    TOPS[] requestTOPS(RequestFilter requestFilter, String... symbols);

    LastTrade[] requestLastTrades(String... symbols);

    LastTrade[] requestLastTrades(RequestFilter requestFilter, String... symbols);

}
