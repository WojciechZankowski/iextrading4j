package pl.zankowski.iextrading4j.client.rest.request.refdata;

import pl.zankowski.iextrading4j.api.refdata.IEXCorporateActions;
import pl.zankowski.iextrading4j.api.refdata.IEXDividends;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class IEXDividendsRequestBuilder extends AbstractDailyListRequestBuilder<List<IEXDividends>, IEXDividendsRequestBuilder>
        implements IEXApiRestRequest<List<IEXDividends>> {

    @Override
    public RestRequest<List<IEXDividends>> build() {
        return RestRequestBuilder.<List<IEXDividends>>builder()
                .withPath("/ref-data/daily-list/dividends/{date}")
                .addPathParam("date", getPeriod()).get()
                .withResponse(new GenericType<List<IEXDividends>>() {
                })
                .build();
    }

}
