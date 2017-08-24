package pl.zankowski.iextrading4j.client.endpoint.marketdata.hist.request;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author Wojciech Zankowski
 */
public class HISTRequest {

    private final LocalDate date;
    private final RequestFilter requestFilter;

    public HISTRequest(LocalDate date, RequestFilter requestFilter) {
        this.date = date;
        this.requestFilter = requestFilter;
    }

    public Optional<LocalDate> getDate() {
        return Optional.ofNullable(date);
    }

    public Optional<RequestFilter> getRequestFilter() {
        return Optional.ofNullable(requestFilter);
    }

    public static HISTRequest.Builder builder() {
        return new HISTRequest.Builder();
    }

    public static class Builder {

        private LocalDate date;
        private RequestFilter requestFilter;

        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder withRequestFilter(RequestFilter requestFilter) {
            this.requestFilter = requestFilter;
            return this;
        }

        public HISTRequest build() {
            return new HISTRequest(date, requestFilter);
        }

    }

}
