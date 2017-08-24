package pl.zankowski.iextrading4j.client.endpoint.refdata;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.endpoint.util.PathUtil;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 * @author Wojciech Zankowski
 */
public class RefDataEndpointImpl implements RefDataEndpoint {

    public static final String REF_DATA_PATH = "ref-data";
    public static final String SYMBOLS_PATH = "symbols";

    private final Client restClient;
    private final UriBuilder baseApiUrl;

    public RefDataEndpointImpl(Client restClient, UriBuilder baseApiUrl) {
        this.restClient = restClient;
        this.baseApiUrl = baseApiUrl;
    }

    @Override
    public ExchangeSymbol[] requestExchangeSymbols() {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, REF_DATA_PATH, SYMBOLS_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(ExchangeSymbol[].class);
    }

    @Override
    public ExchangeSymbol[] requestExchangeSymbols(RequestFilter requestFilter) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, REF_DATA_PATH, SYMBOLS_PATH);
        webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilter.getColumnList());
        return webTarget.request(MediaType.APPLICATION_JSON).get(ExchangeSymbol[].class);
    }

}
