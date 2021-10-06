package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;
import java.util.Map;

public class OptionsSymbolsRequestBuilder extends AbstractRequestFilterBuilder<Map<String, List<String>>, OptionsSymbolsRequestBuilder>
        implements IEXCloudV1RestRequest<Map<String, List<String>>> {

    @Override
    public RestRequest<Map<String, List<String>>> build() {
        return RestRequestBuilder.<Map<String, List<String>>>builder()
                .withPath("/ref-data/options/symbols").get()
                .withResponse(new GenericType<Map<String, List<String>>>() {
                })
                .addQueryParam(getFilterParams())
                .build();
    }

}
