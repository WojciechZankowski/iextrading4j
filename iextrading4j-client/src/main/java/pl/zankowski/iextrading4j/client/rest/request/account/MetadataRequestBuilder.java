package pl.zankowski.iextrading4j.client.rest.request.account;

import pl.zankowski.iextrading4j.api.account.Metadata;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXTradingApiV2RestRequest;

import javax.ws.rs.core.GenericType;

public class MetadataRequestBuilder extends AbstractRequestFilterBuilder<Metadata, MetadataRequestBuilder>
        implements IEXTradingApiV2RestRequest<Metadata> {

    @Override
    public RestRequest<Metadata> build() {
        return RestRequestBuilder.<Metadata>builder()
                .withPath("/account/metadata").get()
                .withResponse(new GenericType<Metadata>() {})
                .addQueryParam(getFilterParams())
                .build();
    }

}
