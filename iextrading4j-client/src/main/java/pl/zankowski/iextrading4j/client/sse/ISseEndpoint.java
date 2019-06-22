package pl.zankowski.iextrading4j.client.sse;

import pl.zankowski.iextrading4j.client.IEndpoint;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

import java.io.Serializable;
import java.util.function.Consumer;

public interface ISseEndpoint extends IEndpoint {

    <R extends Serializable> void subscribe(SseRequest<R> asyncRequest, Consumer<R> consumer);

    <R extends Serializable> void unsubscribe(SseRequest<R> asyncRequest);

}
