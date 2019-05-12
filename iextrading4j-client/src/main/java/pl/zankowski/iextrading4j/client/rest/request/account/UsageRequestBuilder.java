package pl.zankowski.iextrading4j.client.rest.request.account;

import pl.zankowski.iextrading4j.api.account.Usage;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.AbstractRequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Map;

public class UsageRequestBuilder extends AbstractRequestFilterBuilder<Map<String, List<Usage>>, UsageRequestBuilder>
        implements IEXCloudV1RestRequest<Map<String, List<Usage>>> {

    public SingleUsageRequestBuilder withUsageType(final UsageType usageType) {
        return new SingleUsageRequestBuilder(usageType);
    }

    @Override
    public RestRequest<Map<String, List<Usage>>> build() {
        return RestRequestBuilder.<Map<String, List<Usage>>>builder()
                .withPath("/account/usage").get()
                .withResponse(new GenericType<Map<String, List<Usage>>>() {})
                .addQueryParam(getFilterParams())
                .withSecretToken()
                .build();
    }

    public static class SingleUsageRequestBuilder extends AbstractRequestFilterBuilder<List<Usage>, UsageRequestBuilder>
            implements IEXCloudV1RestRequest<List<Usage>> {

        private UsageType usageType;

        public SingleUsageRequestBuilder(final UsageType usageType) {
            this.usageType = usageType;
        }

        @Override
        public RestRequest<List<Usage>> build() {
            return RestRequestBuilder.<List<Usage>>builder()
                    .withPath("/account/usage/{type}")
                    .addPathParam("type", usageType.getType()).get()
                    .withResponse(new GenericType<List<Usage>>() {
                    })
                    .addQueryParam(getFilterParams())
                    .withSecretToken()
                    .build();
        }

    }

}
