package pl.zankowski.iextrading4j.client.rest.request;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.client.rest.manager.IRestParamRequestBuilder;

import java.io.Serializable;

public abstract class AbstractRequestFilterBuilder<R extends Serializable, B extends IRestRequestBuilder>
        implements IRestRequestBuilder<R> {

    private RequestFilter requestFilter;

    public RequestFilter getRequestFilter() {
        return requestFilter;
    }

    public B withRequestFilter(RequestFilter requestFilter) {
        this.requestFilter = requestFilter;
        return (B) this;
    }

    protected void applyRequestFilter(IRestParamRequestBuilder builder) {
        if (requestFilter != null) {
            builder.addQueryParam("filter", requestFilter.getColumnList());
        }
    }

}
