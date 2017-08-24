package pl.zankowski.iextrading4j.client.endpoint.refdata;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.endpoint.Endpoint;

/**
 * @author Wojciech Zankowski
 */
public interface RefDataEndpoint extends Endpoint {

    ExchangeSymbol[] requestExchangeSymbols();

    ExchangeSymbol[] requestExchangeSymbols(RequestFilter requestFilter);

}
