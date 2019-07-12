package pl.zankowski.iextrading4j.client.sse.request;

import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

public interface ISseRequestBuilder<R> {

    SseRequest<R> build();

}
