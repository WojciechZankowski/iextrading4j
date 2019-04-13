package pl.zankowski.iextrading4j.client.rest.request.account;

import pl.zankowski.iextrading4j.api.account.Usage;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;

public class UsageRequestBuilder extends AbstractRequestFilterBuilder<Usage, UsageRequestBuilder>
        implements IEXCloudV1RestRequest<Usage> {

    private UsageType usageType;

    public UsageRequestBuilder withUsageType(final UsageType usageType) {
        this.usageType = usageType;
        return this;
    }

    @Override
    public RestRequest<Usage> build() {
        return RestRequestBuilder.<Usage>builder()
                .withPath("/account/usage/{type}")
                .addPathParam("type", usageType.getType()).get()
                .withResponse(new GenericType<Usage>() {})
                .addQueryParam(getFilterParams())
                .withSecretToken()
                .build();
    }

}
