package pl.zankowski.iextrading4j.client.rest.request.marketdata;

import com.google.common.collect.ImmutableMap;
import pl.zankowski.iextrading4j.api.marketdata.HIST;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static pl.zankowski.iextrading4j.client.rest.request.util.RequestUtil.IEX_DATE_FORMATTER;

public class HistRequestBuilder extends AbstractRequestFilterBuilder<List<HIST>, HistRequestBuilder> {

    private LocalDate date;

    public HistRequestBuilder withDate(final LocalDate date) {
        this.date = date;
        return this;
    }

    private Map<String, String> getDateParams() {
        if (date != null) {
            return ImmutableMap.<String, String>builder()
                    .put("date", IEX_DATE_FORMATTER.format(date))
                    .build();
        }
        return ImmutableMap.of();
    }

    @Override
    public RestRequest<List<HIST>> build() {
        return RestRequestBuilder.<List<HIST>>builder()
                .withPath("/hist").get()
                .withResponse(new GenericType<List<HIST>>() {})
                .addQueryParam(getDateParams())
                .addQueryParam(getFilterParams())
                .build();
    }

}
