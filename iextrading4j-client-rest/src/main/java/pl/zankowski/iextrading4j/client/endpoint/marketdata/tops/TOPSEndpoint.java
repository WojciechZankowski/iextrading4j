package pl.zankowski.iextrading4j.client.endpoint.marketdata.tops;

import pl.zankowski.iextrading4j.client.endpoint.marketdata.tops.request.TOPSRequest;
import pl.zankowski.iextrading4j.api.tops.LastTrade;
import pl.zankowski.iextrading4j.api.tops.TOPS;
import pl.zankowski.iextrading4j.client.endpoint.Endpoint;

/**
 * @author Wojciech Zankowski
 */
public interface TOPSEndpoint extends Endpoint {

    TOPS[] requestTOPS(TOPSRequest topsRequest);

    LastTrade[] requestLastTrades(TOPSRequest topsRequest);

}
