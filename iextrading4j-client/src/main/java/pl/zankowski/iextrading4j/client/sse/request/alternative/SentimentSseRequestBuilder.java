package pl.zankowski.iextrading4j.client.sse.request.alternative;

import pl.zankowski.iextrading4j.api.alternative.SentimentEvent;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;
import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class SentimentSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<SentimentEvent>, SentimentSseRequestBuilder> {

    @Override
    public SseRequest<List<SentimentEvent>> build() {
        return SseRequestBuilder.<List<SentimentEvent>>builder()
                .withPath("/sentiment")
                .withResponse(new GenericType<List<SentimentEvent>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
