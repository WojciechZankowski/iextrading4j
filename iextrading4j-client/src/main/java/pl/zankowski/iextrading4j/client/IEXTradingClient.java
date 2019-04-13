package pl.zankowski.iextrading4j.client;

import com.google.common.collect.ImmutableMap;
import pl.zankowski.iextrading4j.client.mapper.IEXTradingMapperContextResolver;
import pl.zankowski.iextrading4j.client.properties.PropertiesReader;
import pl.zankowski.iextrading4j.client.properties.PropertyType;
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
import java.util.Map;
import java.util.function.Consumer;

public class IEXTradingClient implements IEXApiClient, IEXCloudClient {

    private static final Map<IEXTradingApiVersion, PropertyType> REST_PATHS =
            ImmutableMap.<IEXTradingApiVersion, PropertyType>builder()
                    .put(IEXTradingApiVersion.IEX_API_V1, PropertyType.API_REST_V1)
                    .put(IEXTradingApiVersion.IEX_CLOUD_V1, PropertyType.API_REST_V2)
                    .put(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX, PropertyType.API_REST_V2_SANDBOX)
                    .build();

    private final GenericRestEndpoint genericRestEndpoint;
    private final GenericSocketEndpoint genericSocketEndpoint;

    private IEXTradingClient() {
        this(IEXTradingApiVersion.IEX_API_V1, null);
    }

    private IEXTradingClient(final IEXTradingApiVersion version, final String publishableToken) {
        final RestClient restClient = new RestClient(ClientBuilder.newClient(), new RestClientMetadata(
                PropertiesReader.getInstance().getString(REST_PATHS.get(version)), publishableToken));
        restClient.getClient().register(IEXTradingMapperContextResolver.class);

        genericRestEndpoint = new GenericRestEndpoint(new RestManager(restClient));
        genericSocketEndpoint = new GenericSocketEndpoint(new SocketManager(new SocketWrapper(),
                PropertiesReader.getInstance().getString(PropertyType.API_SOCKET_V1)));
    }

    public static IEXApiClient create() {
        return new IEXTradingClient();
    }

    public static IEXCloudClient create(final String publishableToken) {
        return new IEXTradingClient(IEXTradingApiVersion.IEX_CLOUD_V1, publishableToken);
    }

    public static IEXCloudClient create(final IEXTradingApiVersion version, final String publishableToken) {
        return new IEXTradingClient(version, publishableToken);
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
