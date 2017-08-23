package pl.zankowski.iextrading4j.client.endpoint.marketdata.tops;

import pl.zankowski.iextrading4j.api.tops.LastTrade;
import pl.zankowski.iextrading4j.api.tops.TOPS;
import pl.zankowski.iextrading4j.client.endpoint.Endpoint;
import pl.zankowski.iextrading4j.client.endpoint.marketdata.tops.request.TOPSRequest;

/**
 * @author Wojciech Zankowski
 */
public interface TOPSEndpoint extends Endpoint {

    TOPS[] requestTOPS(TOPSRequest topsRequest);

    LastTrade[] requestLastTrades(TOPSRequest topsRequest);

}
