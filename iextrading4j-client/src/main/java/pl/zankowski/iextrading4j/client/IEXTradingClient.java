package pl.zankowski.iextrading4j.client;

import pl.zankowski.iextrading4j.client.mapper.IEXTradingMapperContextResolver;
import pl.zankowski.iextrading4j.client.rest.endpoint.GenericRestEndpoint;
import pl.zankowski.iextrading4j.client.rest.manager.RestClient;
import pl.zankowski.iextrading4j.client.rest.manager.RestClientMetadata;
import pl.zankowski.iextrading4j.client.rest.manager.RestManager;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.socket.endpoint.GenericSocketEndpoint;
import pl.zankowski.iextrading4j.client.socket.manager.SocketManager;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;
import pl.zankowski.iextrading4j.client.socket.manager.SocketWrapper;

import javax.ws.rs.client.ClientBuilder;
import java.util.function.Consumer;

public class IEXTradingClient {

    private final GenericRestEndpoint genericRestEndpoint;
    private final GenericSocketEndpoint genericSocketEndpoint;

    private IEXTradingClient() {
        final RestClient restClient = new RestClient(ClientBuilder.newClient(), new RestClientMetadata());
        restClient.getClient().register(IEXTradingMapperContextResolver.class);

        genericRestEndpoint = new GenericRestEndpoint(new RestManager(restClient));
        genericSocketEndpoint = new GenericSocketEndpoint(new SocketManager(new SocketWrapper()));
    }

    public static IEXTradingClient create() {
        return new IEXTradingClient();
    }

    public <R> R executeRequest(final RestRequest<R> restRequest) {
        return genericRestEndpoint.executeRequest(restRequest);
    }

    public <R> void subscribe(final SocketRequest<R> socketRequest, final Consumer<R> consumer) {
        genericSocketEndpoint.subscribe(socketRequest, consumer);
    }

    public <R> void unsubscribe(final SocketRequest<R> socketRequest) {
        genericSocketEndpoint.unsubscribe(socketRequest);
    }

}
