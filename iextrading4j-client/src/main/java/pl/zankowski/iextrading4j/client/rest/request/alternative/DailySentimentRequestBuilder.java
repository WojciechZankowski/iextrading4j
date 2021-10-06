package pl.zankowski.iextrading4j.client.rest.request.alternative;

import pl.zankowski.iextrading4j.api.alternative.Sentiment;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;

import static pl.zankowski.iextrading4j.client.rest.request.util.RequestUtil.IEX_DATE_FORMATTER;

public class DailySentimentRequestBuilder extends AbstractSentimentRequestBuilder<Sentiment, DailySentimentRequestBuilder>
        implements IEXCloudV1RestRequest<Sentiment> {

    public DailySentimentRequestBuilder() {
        sentimentType = SentimentType.DAILY;
    }

    @Override
    public RestRequest<Sentiment> build() {
        if (date != null) {
            return requestWithDate();
        } else if (sentimentType != null) {
            return requestWithType();
        }
        return request();
    }

    private RestRequest<Sentiment> request() {
        return RestRequestBuilder.<Sentiment>builder()
                .withPath("/stock/{symbol}/sentiment")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(new GenericType<Sentiment>() {})
                .build();
    }

    private RestRequest<Sentiment> requestWithType() {
        return RestRequestBuilder.<Sentiment>builder()
                .withPath("/stock/{symbol}/sentiment/{type}")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol())
                .addPathParam(TYPE_PARAM_NAME, sentimentType.name().toLowerCase()).get()
                .withResponse(new GenericType<Sentiment>() {})
                .build();
    }

    private RestRequest<Sentiment> requestWithDate() {
        return RestRequestBuilder.<Sentiment>builder()
                .withPath("/stock/{symbol}/sentiment/{type}/{date}")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol())
                .addPathParam(TYPE_PARAM_NAME, sentimentType.name().toLowerCase())
                .addPathParam(DATE_PARAM_NAME, IEX_DATE_FORMATTER.format(date)).get()
                .withResponse(new GenericType<Sentiment>() {})
                .build();
    }

}
