package pl.zankowski.iextrading4j.client;

import pl.zankowski.iextrading4j.client.endpoint.market.MarketEndpoint;
import pl.zankowski.iextrading4j.client.endpoint.market.MarketEndpointImpl;
import pl.zankowski.iextrading4j.client.endpoint.stats.StatsEndpoint;
import pl.zankowski.iextrading4j.client.endpoint.stats.StatsEndpointImpl;
import pl.zankowski.iextrading4j.client.endpoint.tops.TOPSEndpoint;
import pl.zankowski.iextrading4j.client.endpoint.tops.TOPSEndpointImpl;
import pl.zankowski.iextrading4j.client.socket.IOSocketImpl;
import pl.zankowski.iextrading4j.client.socket.WebSocket;
import pl.zankowski.iextrading4j.client.socket.listener.DataReceiver;
import pl.zankowski.iextrading4j.client.util.LocalDateObjectMapperContextResolver;

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

    private final WebSocket webSocket;

    private Client restClient;

    private IEXTradingClient() {
        this(null);
    }

    private IEXTradingClient(DataReceiver dataReceiver) {
        topsEndpoint = new TOPSEndpointImpl(getRESTClient(), getBaseApiUrl());
        statsEndpoint = new StatsEndpointImpl(getRESTClient(), getBaseApiUrl());
        marketEndpoint = new MarketEndpointImpl(getRESTClient(), getBaseApiUrl());
        this.webSocket = new IOSocketImpl(dataReceiver);
    }

    public static IEXTradingClient create() {
        return new IEXTradingClient();
    }

    public static IEXTradingClient create(DataReceiver dataReceiver) {
        return new IEXTradingClient(dataReceiver);
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

    public WebSocket getWebSocket() {
        return webSocket;
    }
}
