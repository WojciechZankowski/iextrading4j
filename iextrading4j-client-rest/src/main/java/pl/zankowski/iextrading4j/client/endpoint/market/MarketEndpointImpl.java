package pl.zankowski.iextrading4j.client.endpoint.market;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.endpoint.util.PathUtil;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

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
        webTarget = PathUtil.appendPaths(webTarget, MARKET_PATH);
        return webTarget.request(MediaType.APPLICATION_JSON).get(MarketVolume[].class);
    }

    @Override
    public MarketVolume[] requestMarketVolume(RequestFilter requestFilter) {
        WebTarget webTarget = restClient.target(baseApiUrl);
        webTarget = PathUtil.appendPaths(webTarget, MARKET_PATH);
        webTarget = PathUtil.appendQuery(webTarget, RequestFilter.FILTER_QUERY_NAME, requestFilter.getColumnList());
        return webTarget.request(MediaType.APPLICATION_JSON).get(MarketVolume[].class);
    }

}
