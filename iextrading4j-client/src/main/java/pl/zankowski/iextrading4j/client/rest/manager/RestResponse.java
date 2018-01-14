package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class RestResponse<R> {

    private final R response;
    private final String message;

    public RestResponse(final R response, final String message) {
        this.response = response;
        this.message = message;
    }

    public R getResponse() {
        return response;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestResponse<?> that = (RestResponse<?>) o;
        return Objects.equal(response, that.response) &&
                Objects.equal(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(response, message);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("response", response)
                .add("message", message)
                .toString();
    }
}
