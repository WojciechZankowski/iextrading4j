package pl.zankowski.iextrading4j.client;

import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.mapper.IEXTradingMapperContextResolver;
import pl.zankowski.iextrading4j.client.rest.endpoint.GenericRestEndpoint;
import pl.zankowski.iextrading4j.client.rest.manager.RestManager;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.BookRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.LastTradeRequestBuilder;
import pl.zankowski.iextrading4j.client.socket.IOSocketImpl;
import pl.zankowski.iextrading4j.client.socket.IOSocketWrapper;
import pl.zankowski.iextrading4j.client.socket.WebSocket;
import pl.zankowski.iextrading4j.client.socket.listener.DataReceiver;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author Wojciech Zankowski
 */
public class IEXTradingClient {

    public static final UriBuilder API_BASE_URL_V1 = UriBuilder.fromPath("https://api.iextrading.com/1.0");

    private final GenericRestEndpoint genericRestEndpoint;

    private final WebSocket webSocket;

    private Client restClient;

    private IEXTradingClient() {
        this(null);
    }

    private IEXTradingClient(DataReceiver dataReceiver) {
        genericRestEndpoint = new GenericRestEndpoint(new RestManager());
        this.webSocket = new IOSocketImpl(new IOSocketWrapper(), dataReceiver);
    }

    public static IEXTradingClient create() {
        return new IEXTradingClient();
    }

    public static IEXTradingClient create(DataReceiver dataReceiver) {
        return new IEXTradingClient(dataReceiver);
    }

    public WebSocket getWebSocket() {
        return webSocket;
    }

    public <R extends Serializable> R executeRequest(final RestRequest<R> restRequest) {
        return genericRestEndpoint.executeRequest(restRequest);
    }

    public static void main(String[] args) {
        final IEXTradingClient iexTradingClient = IEXTradingClient.create();
        final List<LastTrade> lastTradeList = iexTradingClient.executeRequest(new LastTradeRequestBuilder()
                .withSymbol("AAPL")
                .withSymbol("SNAP")
                .build());

        HashMap<String, Book> aapl = iexTradingClient.executeRequest(new BookRequestBuilder()
                .withSymbol("AAPL")
                .build());

        System.out.println(aapl);
    }

}
