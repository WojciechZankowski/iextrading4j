package pl.zankowski.iextrading4j.client.sse.manager;

import com.google.common.collect.Maps;
import pl.zankowski.iextrading4j.client.IEXCloudToken;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.SseEventSource;
import java.io.Serializable;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

public class SseManager {

    private static final String TOKEN_QUERY_PARAM = "token";

    private final Map<SseRequest, SseEventSource> sseStore = Maps.newConcurrentMap();

    private final SseClient sseClient;

    public SseManager(final SseClient sseClient) {
        this.sseClient = sseClient;
    }

    public <T extends Serializable> void subscribe(final SseRequest<T> request, final Consumer<T> consumer) {
        final String url = createURL(request, sseClient.getSseClientMetadata().getToken(),
                sseClient.getSseClientMetadata().getUrl());

        final SseEventSource eventSource = SseEventSource.target(sseClient.getClient().target(url)).build();

        try {
            if (sseStore.containsKey(request)) {
                return;
            }

            eventSource.register(event -> {
                final T receivedData = event.readData(request.getResponseType(), MediaType.APPLICATION_JSON_TYPE);
                consumer.accept(receivedData);
            });
            eventSource.open();

            sseStore.put(request, eventSource);
        } catch (final Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public <T extends Serializable> void unsubscribe(final SocketRequest<T> request) {
        final SseEventSource socket = sseStore.remove(request);
        if (socket == null) {
            return;
        }

        socket.close();
    }

    private <R extends Serializable> String createURL(final SseRequest<R> sseRequest, final IEXCloudToken token,
            final String url) {
        return new StringBuilder()
                .append(url)
                .append(createQueryParameters(sseRequest.getQueryParams(), resolveUrlToken(sseRequest, token)))
                .toString();
    }

    private <R extends Serializable> String resolveUrlToken(final SseRequest<R> sseRequest, final IEXCloudToken token) {
        return resolveToken(sseRequest, token);
    }

    private <R extends Serializable> String resolveToken(final SseRequest<R> sseRequest, final IEXCloudToken token) {
        return token == null
                ? null
                : sseRequest.getUseSecretToken()
                ? token.getSecretToken()
                : token.getPublishableToken();
    }

    private String createQueryParameters(final Map<String, String> queryParams, final String publishableToken) {
        if (queryParams.isEmpty() && publishableToken == null) {
            return "";
        }

        final Map<String, String> paramsCopy = Maps.newHashMap(queryParams);
        if (publishableToken != null) {
            paramsCopy.put(TOKEN_QUERY_PARAM, publishableToken);
        }

        return paramsCopy.entrySet().stream()
                .map(this::createQueryParam)
                .collect(joining("&", "?", ""));
    }

    private String createQueryParam(final Map.Entry<String, String> queryParam) {
        return queryParam.getKey() + "=" + queryParam.getValue();
    }

}
