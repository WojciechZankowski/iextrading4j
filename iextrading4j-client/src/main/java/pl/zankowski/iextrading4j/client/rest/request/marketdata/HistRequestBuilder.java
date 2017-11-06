package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import pl.zankowski.iextrading4j.api.marketdata.HIST;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HistRequestBuilder extends AbstractRequestFilterBuilder<ArrayList<HIST>, HistRequestBuilder> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE;

    private LocalDate date;

    public HistRequestBuilder withDate(final LocalDate date) {
        this.date = date;
        return this;
    }

    private void applyDate(final IRestParamRequestBuilder restRequestBuilder) {
        if (date != null) {
            restRequestBuilder.addQueryParam("date", DATE_TIME_FORMATTER.format(date));
        }
    }

    @Override
    public RestRequest<ArrayList<HIST>> build() {
        IRestParamRequestBuilder restRequestBuilder = RestRequestBuilder.builder()
                .withPath("/hist").get()
                .withResponse(new GenericType<ArrayList<HIST>>() {});

        applyDate(restRequestBuilder);
        applyRequestFilter(restRequestBuilder);

        return restRequestBuilder.build();
    }

}
