package pl.zankowski.iextrading4j.client;

import pl.zankowski.iextrading4j.client.endpoint.market.MarketEndpoint;
import pl.zankowski.iextrading4j.client.endpoint.market.MarketEndpointImpl;
import pl.zankowski.iextrading4j.client.endpoint.marketdata.tops.TOPSEndpoint;
import pl.zankowski.iextrading4j.client.endpoint.marketdata.tops.TOPSEndpointImpl;
import pl.zankowski.iextrading4j.client.endpoint.refdata.RefDataEndpoint;
import pl.zankowski.iextrading4j.client.endpoint.refdata.RefDataEndpointImpl;
import pl.zankowski.iextrading4j.client.endpoint.stats.StatsEndpoint;
import pl.zankowski.iextrading4j.client.endpoint.stats.StatsEndpointImpl;
import pl.zankowski.iextrading4j.client.endpoint.stocks.StocksEndpoint;
import pl.zankowski.iextrading4j.client.endpoint.stocks.StocksEndpointImpl;
import pl.zankowski.iextrading4j.client.socket.IOSocketImpl;
import pl.zankowski.iextrading4j.client.socket.IOSocketWrapper;
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

    private final StocksEndpoint stocksEndpoint;
    private final TOPSEndpoint topsEndpoint;
    private final StatsEndpoint statsEndpoint;
    private final MarketEndpoint marketEndpoint;
    private final RefDataEndpoint refDataEndpoint;

    private final WebSocket webSocket;

    private Client restClient;

    private IEXTradingClient() {
        this(null);
    }

    private IEXTradingClient(DataReceiver dataReceiver) {
        stocksEndpoint = new StocksEndpointImpl(getRESTClient(), getBaseApiUrl());
        topsEndpoint = new TOPSEndpointImpl(getRESTClient(), getBaseApiUrl());
        statsEndpoint = new StatsEndpointImpl(getRESTClient(), getBaseApiUrl());
        marketEndpoint = new MarketEndpointImpl(getRESTClient(), getBaseApiUrl());
        refDataEndpoint = new RefDataEndpointImpl(getRESTClient(), getBaseApiUrl());
        this.webSocket = new IOSocketImpl(new IOSocketWrapper(), dataReceiver);
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

    public StocksEndpoint getStocksEndpoint() {
        return stocksEndpoint;
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

    public RefDataEndpoint getRefDataEndpoint() {
        return refDataEndpoint;
    }

    public WebSocket getWebSocket() {
        return webSocket;
    }
}
