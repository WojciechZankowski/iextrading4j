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
import pl.zankowski.iextrading4j.client.sse.endpoint.GenericSseEndpoint;
import pl.zankowski.iextrading4j.client.sse.manager.SseClient;
import pl.zankowski.iextrading4j.client.sse.manager.SseClientMetadata;
import pl.zankowski.iextrading4j.client.sse.manager.SseManager;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

import javax.ws.rs.client.Client;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.jackson.JacksonFeature;

import java.util.Map;
import java.util.function.Consumer;

public class IEXTradingClient implements IEXApiClient, IEXCloudClient {

    private static final Map<IEXTradingApiVersion, PropertyType> REST_PATHS =
            ImmutableMap.<IEXTradingApiVersion, PropertyType>builder()
                    .put(IEXTradingApiVersion.IEX_API_V1, PropertyType.API_REST_V1)
                    .put(IEXTradingApiVersion.IEX_CLOUD_BETA, PropertyType.API_REST_V2_BETA)
                    .put(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX, PropertyType.API_REST_V2_BETA_SANDBOX)
                    .put(IEXTradingApiVersion.IEX_CLOUD_V1, PropertyType.API_REST_V2)
                    .put(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX, PropertyType.API_REST_V2_SANDBOX)
                    .build();

    private static final Map<IEXTradingApiVersion, PropertyType> SSE_PATHS =
            ImmutableMap.<IEXTradingApiVersion, PropertyType>builder()
                    .put(IEXTradingApiVersion.IEX_CLOUD_BETA, PropertyType.API_SSE_V2)
                    .put(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX, PropertyType.API_SSE_V2_SANDBOX)
                    .put(IEXTradingApiVersion.IEX_CLOUD_V1, PropertyType.API_SSE_V2)
                    .put(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX, PropertyType.API_SSE_V2_SANDBOX)
                    .build();

    private static final Map<IEXTradingApiVersion, PropertyType> SOCKET_PATHS =
            ImmutableMap.<IEXTradingApiVersion, PropertyType>builder()
                    .put(IEXTradingApiVersion.IEX_API_V1, PropertyType.API_SOCKET_V1)
                    .put(IEXTradingApiVersion.IEX_CLOUD_BETA, PropertyType.API_SOCKET_V2)
                    .put(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX, PropertyType.API_SOCKET_V2_SANDBOX)
                    .put(IEXTradingApiVersion.IEX_CLOUD_V1, PropertyType.API_SOCKET_V2)
                    .put(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX, PropertyType.API_SOCKET_V2_SANDBOX)
                    .build();

    private final GenericRestEndpoint genericRestEndpoint;
    private final GenericSocketEndpoint genericSocketEndpoint;
    private final GenericSseEndpoint genericSseEndpoint;

    private IEXTradingClient() {
        this(IEXTradingApiVersion.IEX_API_V1, null);
    }

    private IEXTradingClient(final IEXTradingApiVersion version, final IEXCloudToken token) {
        // JacksonFeature must be assigned by JerseyClientBuilder instead of ClientBuilder
        final Client client = new JerseyClientBuilder().build().register(JacksonFeature.class);
        final RestClient restClient = new RestClient(client, new RestClientMetadata(
                PropertiesReader.getInstance().getString(REST_PATHS.get(version)), token));
        final SseClient sseClient = new SseClient(client, new SseClientMetadata(
                PropertiesReader.getInstance().getString(SSE_PATHS.get(version)), token));
        restClient.getClient().register(IEXTradingMapperContextResolver.class);

        genericRestEndpoint = new GenericRestEndpoint(new RestManager(restClient));
        genericSocketEndpoint = new GenericSocketEndpoint(new SocketManager(new SocketWrapper(),
                PropertiesReader.getInstance().getString(PropertyType.API_SOCKET_V1)));
        genericSseEndpoint = new GenericSseEndpoint(new SseManager(sseClient));
    }

    public static IEXApiClient create() {
        return new IEXTradingClient();
    }

    public static IEXCloudClient create(final IEXCloudToken token) {
        return new IEXTradingClient(IEXTradingApiVersion.IEX_CLOUD_BETA, token);
    }

    public static IEXCloudClient create(final IEXTradingApiVersion version, final IEXCloudToken token) {
        return new IEXTradingClient(version, token);
    }

    public <R> R executeRequest(final RestRequest<R> restRequest) {
        return genericRestEndpoint.executeRequest(restRequest);
    }

    @Override
    public <R> void subscribe(final SseRequest<R> sseRequest, final Consumer<R> consumer) {
        genericSseEndpoint.subscribe(sseRequest, consumer);
    }

    @Override
    public <R> void unsubscribe(final SseRequest<R> sseRequest) {
        genericSseEndpoint.unsubscribe(sseRequest);
    }

    public <R> void subscribe(final SocketRequest<R> socketRequest, final Consumer<R> consumer) {
        genericSocketEndpoint.subscribe(socketRequest, consumer);
    }

    public <R> void unsubscribe(final SocketRequest<R> socketRequest) {
        genericSocketEndpoint.unsubscribe(socketRequest);
    }

}
