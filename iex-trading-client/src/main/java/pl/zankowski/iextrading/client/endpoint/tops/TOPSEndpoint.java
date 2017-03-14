package pl.zankowski.iextrading.client.endpoint.tops;

import pl.zankowski.iextrading.api.filter.RequestFilter;
import pl.zankowski.iextrading.api.tops.LastTrade;
import pl.zankowski.iextrading.api.tops.TOPS;

/**
 * @author Wojciech Zankowski
 */
public interface TOPSEndpoint {

    TOPS[] requestTOPS(final String... symbols);

    TOPS[] requestTOPS(final RequestFilter requestFilter, final String... symbols);

    LastTrade[] requestLastTrades(final String... symbols);

    LastTrade[] requestLastTrades(final RequestFilter requestFilter, final String... symbols);

}
