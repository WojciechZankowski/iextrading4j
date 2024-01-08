package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.ws.rs.core.GenericType;

import java.util.Map;

import static pl.zankowski.iextrading4j.api.util.MapUtil.immutableMap;

public class RestRequest<R> {

    private final GenericType<R> responseType;
    private final PostEntity requestEntity;
    private final String path;
    private final MethodType methodType;
    private final Map<String, String> headerParams;
    private final Map<String, String> queryParams;
    private final Map<String, String> pathParams;
    private final Boolean useSecretToken;

    public RestRequest(final GenericType<R> responseType, final PostEntity requestEntity, final String path,
                       final MethodType methodType, final Map<String, String> headerParams,
                       final Map<String, String> queryParams, final Map<String, String> pathParams,
                       final Boolean useSecretToken) {
        this.responseType = responseType;
        this.requestEntity = requestEntity;
        this.path = path;
        this.methodType = methodType;
        this.headerParams = immutableMap(headerParams);
        this.queryParams = immutableMap(queryParams);
        this.pathParams = immutableMap(pathParams);
        this.useSecretToken = useSecretToken;
    }

    public GenericType<R> getResponseType() {
        return responseType;
    }

    public PostEntity getRequestEntity() {
        return requestEntity;
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
        final RestRequest<?> that = (RestRequest<?>) o;
        return Objects.equal(responseType, that.responseType) &&
                Objects.equal(requestEntity, that.requestEntity) &&
                Objects.equal(path, that.path) &&
                methodType == that.methodType &&
                Objects.equal(headerParams, that.headerParams) &&
                Objects.equal(queryParams, that.queryParams) &&
                Objects.equal(pathParams, that.pathParams) &&
                Objects.equal(useSecretToken, that.useSecretToken);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(responseType, requestEntity, path, methodType,
                headerParams, queryParams, pathParams, useSecretToken);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("responseType", responseType)
                .add("requestEntity", requestEntity)
                .add("path", path)
                .add("methodType", methodType)
                .add("headerParams", headerParams)
                .add("queryParams", queryParams)
                .add("pathParams", pathParams)
                .add("useSecretToken", useSecretToken)
                .toString();
    }

}
