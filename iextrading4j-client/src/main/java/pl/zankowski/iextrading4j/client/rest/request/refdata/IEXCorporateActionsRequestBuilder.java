package pl.zankowski.iextrading4j.client.rest.request.refdata;

import pl.zankowski.iextrading4j.api.refdata.IEXCorporateActions;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class IEXCorporateActionsRequestBuilder extends AbstractDailyListRequestBuilder<List<IEXCorporateActions>, IEXCorporateActionsRequestBuilder>
        implements IEXApiRestRequest<List<IEXCorporateActions>> {

    @Override
    public RestRequest<List<IEXCorporateActions>> build() {
        return RestRequestBuilder.<List<IEXCorporateActions>>builder()
                .withPath("/ref-data/daily-list/corporate-actions/{date}")
                .addPathParam("date", getPeriod()).get()
                .withResponse(new GenericType<List<IEXCorporateActions>>() {
                })
                .build();
    }
}
