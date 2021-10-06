package pl.zankowski.iextrading4j.client.rest.request.refdata;

import pl.zankowski.iextrading4j.api.refdata.IEXSymbolDirectory;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public class IEXSymbolDirectoryRequestBuilder extends AbstractDailyListRequestBuilder<List<IEXSymbolDirectory>, IEXSymbolDirectoryRequestBuilder>
        implements IEXApiRestRequest<List<IEXSymbolDirectory>> {

    @Override
    public RestRequest<List<IEXSymbolDirectory>> build() {
        return RestRequestBuilder.<List<IEXSymbolDirectory>>builder()
                .withPath("/ref-data/daily-list/symbol-directory/{date}")
                .addPathParam("date", getPeriod()).get()
                .withResponse(new GenericType<List<IEXSymbolDirectory>>() {
                })
                .build();
    }
}
