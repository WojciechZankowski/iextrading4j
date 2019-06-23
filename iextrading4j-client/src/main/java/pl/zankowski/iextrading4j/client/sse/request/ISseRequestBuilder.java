package pl.zankowski.iextrading4j.client.sse.request;

import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

import java.io.Serializable;

public interface ISseRequestBuilder<R extends Serializable> {

    SseRequest<R> build();

}
