package pl.zankowski.iextrading4j.client.rest.request.alternative;

import pl.zankowski.iextrading4j.api.alternative.Sentiment;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static pl.zankowski.iextrading4j.client.rest.request.util.RequestUtil.IEX_DATE_FORMATTER;

public class SentimentRequestBuilder extends AbstractSentimentRequestBuilder<List<Sentiment>, SentimentRequestBuilder>
        implements IEXCloudV1RestRequest<List<Sentiment>> {

    public SentimentRequestBuilder withSentimentType(final SentimentType sentimentType) {
        this.sentimentType = sentimentType;
        return this;
    }

    @Override
    public RestRequest<List<Sentiment>> build() {
        if (date != null) {
            return requestWithDate();
        } else if (sentimentType != null) {
            return requestWithType();
        }
        return request();
    }

    private RestRequest<List<Sentiment>> request() {
        return RestRequestBuilder.<List<Sentiment>>builder()
                .withPath("/stock/{symbol}/sentiment")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol()).get()
                .withResponse(new GenericType<List<Sentiment>>() {})
                .build();
    }

    private RestRequest<List<Sentiment>> requestWithType() {
        return RestRequestBuilder.<List<Sentiment>>builder()
                .withPath("/stock/{symbol}/sentiment/{type}")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol())
                .addPathParam(TYPE_PARAM_NAME, sentimentType.name().toLowerCase()).get()
                .withResponse(new GenericType<List<Sentiment>>() {})
                .build();
    }

    private RestRequest<List<Sentiment>> requestWithDate() {
        return RestRequestBuilder.<List<Sentiment>>builder()
                .withPath("/stock/{symbol}/sentiment/{type}/{date}")
                .addPathParam(SYMBOL_PARAM_NAME, getSymbol())
                .addPathParam(TYPE_PARAM_NAME, sentimentType.name().toLowerCase())
                .addPathParam(DATE_PARAM_NAME, IEX_DATE_FORMATTER.format(date)).get()
                .withResponse(new GenericType<List<Sentiment>>() {})
                .build();
    }

}
