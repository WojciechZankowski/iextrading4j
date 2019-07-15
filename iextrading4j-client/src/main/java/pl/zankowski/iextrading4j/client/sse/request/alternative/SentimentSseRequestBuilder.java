package pl.zankowski.iextrading4j.client.sse.request.alternative;

import pl.zankowski.iextrading4j.api.alternative.Sentiment;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class SentimentSseRequestBuilder extends AbstractSymbolSseRequestBuilder<List<Sentiment>, SentimentSseRequestBuilder> {

    @Override
    public SseRequest<List<Sentiment>> build() {
        return SseRequestBuilder.<List<Sentiment>>builder()
                .withPath("/sentiment")
                .withResponse(new GenericType<List<Sentiment>>() {})
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
