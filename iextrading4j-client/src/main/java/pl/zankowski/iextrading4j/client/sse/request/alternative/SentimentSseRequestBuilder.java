package pl.zankowski.iextrading4j.client.sse.request.alternative;

import pl.zankowski.iextrading4j.api.alternative.Sentiment;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

public class SentimentSseRequestBuilder extends AbstractSymbolSseRequestBuilder<Sentiment, SentimentSseRequestBuilder> {

    @Override
    public SseRequest<Sentiment> build() {
        return SseRequestBuilder.<Sentiment>builder()
                .withPath("/sentiment")
                .withResponse(Sentiment.class)
                .addQueryParam("symbols", getSymbol())
                .addQueryParam("nosnaphot", isNoSnapshot())
                .build();
    }

}
