package pl.zankowski.iextrading4j.client.endpoint.marketdata.hist;

import pl.zankowski.iextrading4j.client.endpoint.marketdata.hist.request.HISTRequest;
import pl.zankowski.iextrading4j.api.marketdata.HIST;

/**
 * @author Wojciech Zankowski
 */
public interface HISTEndpoint {

    HIST[] requestHIST(HISTRequest histRequest);

}
