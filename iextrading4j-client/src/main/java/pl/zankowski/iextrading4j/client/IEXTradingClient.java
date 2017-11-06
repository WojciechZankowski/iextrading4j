package pl.zankowski.iextrading4j.client;

import pl.zankowski.iextrading4j.client.rest.endpoint.GenericRestEndpoint;
import pl.zankowski.iextrading4j.client.rest.manager.RestManager;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.socket.IOSocketImpl;
import pl.zankowski.iextrading4j.client.socket.IOSocketWrapper;
import pl.zankowski.iextrading4j.client.socket.WebSocket;
import pl.zankowski.iextrading4j.client.socket.listener.DataReceiver;

public class IEXTradingClient {

    private final GenericRestEndpoint genericRestEndpoint;
    private final WebSocket webSocket;

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

    public <R> R executeRequest(final RestRequest<R> restRequest) {
        return genericRestEndpoint.executeRequest(restRequest);
    }

}
