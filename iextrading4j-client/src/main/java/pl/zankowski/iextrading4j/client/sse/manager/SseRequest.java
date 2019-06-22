package pl.zankowski.iextrading4j.client.sse.manager;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.ws.rs.core.GenericType;
import java.io.Serializable;
import java.util.Map;

public class SseRequest<R extends Serializable> {

    private final GenericType<R> responseType;
    private final String path;
    private final Map<String, String> headerParams;
    private final Map<String, String> queryParams;
    private final Boolean useSecretToken;

    public SseRequest(
            final GenericType<R> responseType,
            final String path,
            final Map<String, String> headerParams,
            final Map<String, String> queryParams,
            final Boolean useSecretToken) {
        this.responseType = responseType;
        this.path = path;
        this.headerParams = headerParams;
        this.queryParams = queryParams;
        this.useSecretToken = useSecretToken;
    }

    public GenericType<R> getResponseType() {
        return responseType;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getHeaderParams() {
        return headerParams;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public Boolean getUseSecretToken() {
        return useSecretToken;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SseRequest<?> that = (SseRequest<?>) o;
        return Objects.equal(responseType, that.responseType) &&
                Objects.equal(path, that.path) &&
                Objects.equal(headerParams, that.headerParams) &&
                Objects.equal(queryParams, that.queryParams) &&
                Objects.equal(useSecretToken, that.useSecretToken);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(responseType, path, headerParams, queryParams, useSecretToken);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("responseType", responseType)
                .add("path", path)
                .add("headerParams", headerParams)
                .add("queryParams", queryParams)
                .add("useSecretToken", useSecretToken)
                .toString();
    }

}
