package pl.zankowski.iextrading4j.client.rest.request.refdata;

import pl.zankowski.iextrading4j.api.refdata.IEXSymbolDirectory;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class IEXSymbolDirectoryRequestBuilder extends AbstractDailyListRequestBuilder<List<IEXSymbolDirectory>, IEXSymbolDirectoryRequestBuilder> {

    @Override
    public RestRequest<List<IEXSymbolDirectory>> build() {
        return RestRequestBuilder.<List<IEXSymbolDirectory>>builder()
                .withPath("/ref-data/daily-list/symbol-directory/{date}")
                .addPathParam("date", getPeriod()).get()
                .withResponse(new GenericType<List<IEXSymbolDirectory>>() {})
                .build();
    }
}
