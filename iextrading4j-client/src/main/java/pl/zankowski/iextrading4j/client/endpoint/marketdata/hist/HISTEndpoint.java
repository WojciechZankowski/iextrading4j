package pl.zankowski.iextrading4j.client.endpoint.marketdata.hist;

import pl.zankowski.iextrading4j.api.hist.HIST;
import pl.zankowski.iextrading4j.client.endpoint.marketdata.hist.request.HISTRequest;

/**
 * @author Wojciech Zankowski
 */
public interface HISTEndpoint {

    HIST[] requestHIST(HISTRequest histRequest);

}
