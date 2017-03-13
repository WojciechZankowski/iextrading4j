package pl.zankowski.iextrading.rest.client.endpoint.market;

import pl.zankowski.iextrading.api.market.MarketVolume;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import static pl.zankowski.iextrading.rest.client.util.PathUtil.appendPaths;

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

}
