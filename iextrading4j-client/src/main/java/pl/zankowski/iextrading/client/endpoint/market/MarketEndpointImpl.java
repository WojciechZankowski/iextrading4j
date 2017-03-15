package pl.zankowski.iextrading.client.endpoint.market;

import pl.zankowski.iextrading.api.filter.RequestFilter;
import pl.zankowski.iextrading.api.market.MarketVolume;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import static pl.zankowski.iextrading.api.filter.RequestFilter.FILTER_QUERY_NAME;
import static pl.zankowski.iextrading.client.util.PathUtil.appendPaths;
import static pl.zankowski.iextrading.client.util.PathUtil.appendQuery;

/**
 * @author Wojciech Zankowski
 */
public class MarketEndpointImpl implements MarketEndpoint {

    public static final String MARKET_PATH = "market";

    private final Client restClient;
    private final UriBuilder baseApiUrl;

    public MarketEndpointImpl(Client restClient, UriBuilder baseApiUrl) {
        this.restClient = restClient;
        this.baseApiUrl = baseApiUrl;
    }

    @Override
    public MarketVolume[] requestMarketVolume() {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, MARKET_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(MarketVolume[].class);
    }

    @Override
    public MarketVolume[] requestMarketVolume(RequestFilter requestFilter) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = appendPaths(webTarget, MARKET_PATH);
        webTarget = appendQuery(webTarget, FILTER_QUERY_NAME, requestFilter.getColumnList());
        return webTarget.request(MediaType.APPLICATION_JSON).get(MarketVolume[].class);
    }

}
