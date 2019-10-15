package pl.zankowski.iextrading4j.client.rest.request.alternative;

import pl.zankowski.iextrading4j.client.rest.request.stocks.AbstractStocksRequestBuilder;

import java.time.LocalDate;

public abstract class AbstractSentimentRequestBuilder<R, B extends AbstractSentimentRequestBuilder<R, B>>
        extends AbstractStocksRequestBuilder<R, B> {

    protected static final String TYPE_PARAM_NAME = "type";
    protected static final String DATE_PARAM_NAME = "date";

    protected SentimentType sentimentType;
    protected LocalDate date;

    public B withDate(final LocalDate date) {
        this.date = date;
        return (B) this;
    }

}
