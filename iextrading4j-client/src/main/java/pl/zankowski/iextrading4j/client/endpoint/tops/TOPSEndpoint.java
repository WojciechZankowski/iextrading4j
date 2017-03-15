package pl.zankowski.iextrading4j.client.endpoint.tops;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.tops.LastTrade;
import pl.zankowski.iextrading4j.api.tops.TOPS;
import pl.zankowski.iextrading4j.client.endpoint.Endpoint;

/**
 * @author Wojciech Zankowski
 */
public interface TOPSEndpoint extends Endpoint {

    TOPS[] requestTOPS(String... symbols);

    TOPS[] requestTOPS(RequestFilter requestFilter, String... symbols);

    LastTrade[] requestLastTrades(String... symbols);

    LastTrade[] requestLastTrades(RequestFilter requestFilter, String... symbols);

}
