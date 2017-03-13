package pl.zankowski.iextrading.rest.client;

import pl.zankowski.iextrading.rest.client.endpoint.market.MarketEndpoint;
import pl.zankowski.iextrading.rest.client.endpoint.market.MarketEndpointImpl;
import pl.zankowski.iextrading.rest.client.endpoint.stats.StatsEndpoint;
import pl.zankowski.iextrading.rest.client.endpoint.stats.StatsEndpointImpl;
import pl.zankowski.iextrading.rest.client.endpoint.tops.TOPSEndpoint;
import pl.zankowski.iextrading.rest.client.endpoint.tops.TOPSEndpointImpl;
import pl.zankowski.iextrading.rest.client.util.LocalDateObjectMapperContextResolver;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;

/**
 * @author Wojciech Zankowski
 */
public class IEXTradingClient {

    public static final UriBuilder API_BASE_URL_V1 = UriBuilder.fromPath("https://api.iextrading.com/1.0");

    private final TOPSEndpoint topsEndpoint;
    private final StatsEndpoint statsEndpoint;
    private final MarketEndpoint marketEndpoint;

    private Client restClient;

    private IEXTradingClient() {
        topsEndpoint = new TOPSEndpointImpl(getRESTClient(), getBaseApiUrl());
        statsEndpoint = new StatsEndpointImpl(getRESTClient(), getBaseApiUrl());
        marketEndpoint = new MarketEndpointImpl(getRESTClient(), getBaseApiUrl());
    }

    public static IEXTradingClient create() {
        return new IEXTradingClient();
    }

    protected Client getRESTClient() {
        if (restClient == null) {
            restClient = ClientBuilder.newClient();
            restClient.register(LocalDateObjectMapperContextResolver.class);
        }
        return restClient;
    }

    protected UriBuilder getBaseApiUrl() {
        return API_BASE_URL_V1;
    }

    public TOPSEndpoint getTopsEndpoint() {
        return topsEndpoint;
    }

    public StatsEndpoint getStatsEndpoint() {
        return statsEndpoint;
    }

    public MarketEndpoint getMarketEndpoint() {
        return marketEndpoint;
    }

}
