package pl.zankowski.iextrading4j.client.endpoint.stats.request;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;

import java.util.Optional;

/**
 * @author Wojciech Zankowski
 */
public class StatsRequest {

    private final RequestFilter requestFilter;

    public StatsRequest(RequestFilter requestFilter) {
        this.requestFilter = requestFilter;
    }

    public Optional<RequestFilter> getRequestFilter() {
        return Optional.ofNullable(requestFilter);
    }

    public static StatsRequest.Builder builder() {
        return new StatsRequest.Builder();
    }

    public static class Builder {

        private RequestFilter requestFilter;

        public StatsRequest.Builder withRequestFilter(RequestFilter requestFilter) {
            this.requestFilter = requestFilter;
            return this;
        }

        public StatsRequest build() {
            return new StatsRequest(requestFilter);
        }

    }

}
