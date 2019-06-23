package pl.zankowski.iextrading4j.client.sse.endpoint;

import pl.zankowski.iextrading4j.client.sse.ISseEndpoint;
import pl.zankowski.iextrading4j.client.sse.manager.SseManager;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

import java.io.Serializable;
import java.util.function.Consumer;

public class GenericSseEndpoint implements ISseEndpoint {

    private final SseManager sseManager;

    public GenericSseEndpoint(final SseManager sseManager) {
        this.sseManager = sseManager;
    }

    @Override
    public <R extends Serializable> void subscribe(final SseRequest<R> sseRequest, final Consumer<R> consumer) {
        sseManager.subscribe(sseRequest, consumer);
    }

    @Override
    public <R extends Serializable> void unsubscribe(final SseRequest<R> sseRequest) {
        sseManager.unsubscribe(sseRequest);
    }

}
