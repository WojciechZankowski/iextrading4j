package pl.zankowski.iextrading4j.client.rest.request;

import com.google.common.collect.ImmutableMap;
import pl.zankowski.iextrading4j.client.rest.request.filter.RequestFilter;

import java.util.Map;

public abstract class AbstractRequestFilterBuilder<R, B extends IRestRequestBuilder>
        implements IRestRequestBuilder<R> {

    private RequestFilter requestFilter;

    public B withRequestFilter(RequestFilter requestFilter) {
        this.requestFilter = requestFilter;
        return (B) this;
    }

    protected Map<String, String> getFilterParams() {
        if (requestFilter != null) {
            return ImmutableMap.<String, String>builder()
                    .put("filter", requestFilter.getColumnList())
                    .build();
        }
        return ImmutableMap.of();
    }

}
