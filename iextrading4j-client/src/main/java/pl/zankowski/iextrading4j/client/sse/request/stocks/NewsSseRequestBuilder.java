package pl.zankowski.iextrading4j.client.sse.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.v1.News;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequestBuilder;
import pl.zankowski.iextrading4j.client.sse.request.AbstractSymbolSseRequestBuilder;

public class NewsSseRequestBuilder extends AbstractSymbolSseRequestBuilder<News, NewsSseRequestBuilder> {

    @Override
    public SseRequest<News> build() {
        return SseRequestBuilder.<News>builder()
                .withPath("/news-stream")
                .withResponse(News.class)
                .addQueryParam(SYMBOL_PARAM, getSymbol())
                .addQueryParam(NO_SNAPSHOT_PARAM, isNoSnapshot())
                .build();
    }

}
