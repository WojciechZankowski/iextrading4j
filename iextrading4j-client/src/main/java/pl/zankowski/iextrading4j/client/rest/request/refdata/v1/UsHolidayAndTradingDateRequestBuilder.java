package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import pl.zankowski.iextrading4j.api.refdata.v1.HolidayAndTradingDate;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.util.List;

import static pl.zankowski.iextrading4j.client.rest.request.util.RequestUtil.IEX_DATE_FORMATTER;

public class UsHolidayAndTradingDateRequestBuilder extends AbstractRequestFilterBuilder<List<HolidayAndTradingDate>, UsHolidayAndTradingDateRequestBuilder>
        implements IEXCloudV1RestRequest<List<HolidayAndTradingDate>> {

    private DateType type;
    private DateDirection direction;
    private Integer last;
    private LocalDate startDate;

    public UsHolidayAndTradingDateRequestBuilder withType(final DateType type) {
        this.type = type;
        return this;
    }

    public UsHolidayAndTradingDateRequestBuilder withDirection(final DateDirection direction) {
        this.direction = direction;
        return this;
    }

    public UsHolidayAndTradingDateRequestBuilder withLast(final Integer last) {
        this.last = last;
        return this;
    }

    public UsHolidayAndTradingDateRequestBuilder withStartDate(final LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    private RestRequest<List<HolidayAndTradingDate>> request() {
        return RestRequestBuilder.<List<HolidayAndTradingDate>>builder()
                .withPath("/ref-data/us/dates/{type}/{direction}")
                .addPathParam("type", type.name().toLowerCase())
                .addPathParam("direction", direction.name().toLowerCase()).get()
                .withResponse(new GenericType<List<HolidayAndTradingDate>>() {
                })
                .addQueryParam(getFilterParams())
                .build();
    }

    private RestRequest<List<HolidayAndTradingDate>> requestWithLast() {
        return RestRequestBuilder.<List<HolidayAndTradingDate>>builder()
                .withPath("/ref-data/us/dates/{type}/{direction}/{last}")
                .addPathParam("type", type.name().toLowerCase())
                .addPathParam("direction", direction.name().toLowerCase())
                .addPathParam("last", String.valueOf(last)).get()
                .withResponse(new GenericType<List<HolidayAndTradingDate>>() {
                })
                .addQueryParam(getFilterParams())
                .build();
    }

    private RestRequest<List<HolidayAndTradingDate>> requestWithLastAndDirection() {
        return RestRequestBuilder.<List<HolidayAndTradingDate>>builder()
                .withPath("/ref-data/us/dates/{type}/{direction}/{last}/{startDate}")
                .addPathParam("type", type.name().toLowerCase())
                .addPathParam("direction", direction.name().toLowerCase())
                .addPathParam("last", String.valueOf(last))
                .addPathParam("startDate", IEX_DATE_FORMATTER.format(startDate)).get()
                .withResponse(new GenericType<List<HolidayAndTradingDate>>() {
                })
                .addQueryParam(getFilterParams())
                .build();
    }

    @Override
    public RestRequest<List<HolidayAndTradingDate>> build() {
        if (startDate != null) {
            return requestWithLastAndDirection();
        }
        if (last != null) {
            return requestWithLast();
        }
        return request();
    }
}
