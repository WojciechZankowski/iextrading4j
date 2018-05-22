package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.ws.rs.core.GenericType;
import java.util.Map;

import static pl.zankowski.iextrading4j.api.util.MapUtil.immutableMap;

public class RestRequest<R> {

    private final GenericType<R> responseType;
    private final String path;
    private final MethodType methodType;
    private final Map<String, String> headerParams;
    private final Map<String, String> queryParams;
    private final Map<String, String> pathParams;

    public RestRequest(final GenericType<R> responseType, final String path, final MethodType methodType,
                final Map<String, String> headerParams, final Map<String, String> queryParams,
                final Map<String, String> pathParams) {
        this.responseType = responseType;
        this.path = path;
        this.methodType = methodType;
        this.headerParams = immutableMap(headerParams);
        this.queryParams = immutableMap(queryParams);
        this.pathParams = immutableMap(pathParams);
    }

    public GenericType<R> getResponseType() {
        return responseType;
    }

    public String getPath() {
        return path;
    }

    public MethodType getMethodType() {
        return methodType;
    }

    public Map<String, String> getHeaderParams() {
        return headerParams;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public Map<String, String> getPathParams() {
        return pathParams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestRequest<?> that = (RestRequest<?>) o;
        return Objects.equal(responseType, that.responseType) &&
                Objects.equal(path, that.path) &&
                methodType == that.methodType &&
                Objects.equal(headerParams, that.headerParams) &&
                Objects.equal(queryParams, that.queryParams) &&
                Objects.equal(pathParams, that.pathParams);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(responseType, path, methodType, headerParams, queryParams, pathParams);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("responseType", responseType)
                .add("path", path)
                .add("methodType", methodType)
                .add("headerParams", headerParams)
                .add("queryParams", queryParams)
                .add("pathParams", pathParams)
                .toString();
    }
}
