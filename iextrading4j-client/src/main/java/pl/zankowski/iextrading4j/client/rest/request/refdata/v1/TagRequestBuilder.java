package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import pl.zankowski.iextrading4j.api.refdata.v1.Tag;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class TagRequestBuilder extends AbstractRequestFilterBuilder<List<Tag>, UsExchangeRequestBuilder>
        implements IEXCloudV1RestRequest<List<Tag>> {

    @Override
    public RestRequest<List<Tag>> build() {
        return RestRequestBuilder.<List<Tag>>builder()
                .withPath("/ref-data/tags").get()
                .withResponse(new GenericType<List<Tag>>() {})
                .addQueryParam(getFilterParams())
                .build();
    }

}
