package pl.zankowski.iextrading4j.client.rest.request.refdata;

import pl.zankowski.iextrading4j.api.refdata.NextDayExDate;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class NextDayExDateRequestBuilder extends AbstractDailyListRequestBuilder<List<NextDayExDate>, NextDayExDateRequestBuilder> {

    @Override
    public RestRequest<List<NextDayExDate>> build() {
        return RestRequestBuilder.<List<NextDayExDate>>builder()
                .withPath("/ref-data/daily-list/next-day-ex-date/{date}")
                .addPathParam("date", getPeriod()).get()
                .withResponse(new GenericType<List<NextDayExDate>>() {})
                .build();
    }

}
