package pl.zankowski.iextrading4j.client.sse.manager;

import com.google.common.collect.Maps;

import javax.ws.rs.core.GenericType;
import java.io.Serializable;
import java.util.Map;

public class SseRequestBuilder<R extends Serializable> implements ISseParamRequestBuilder<R>,
        ISsePathRequestBuilder<R>, ISseResponseTypeRequestBuilder<R> {

    private GenericType<R> responseType;
    private String path;
    private Map<String, String> headerParams;
    private Map<String, String> pathParams;
    private Map<String, String> queryParams;
    private Boolean useSecretToken = Boolean.FALSE;

    protected SseRequestBuilder() {
        this.headerParams = Maps.newHashMap();
        this.pathParams = Maps.newHashMap();
        this.queryParams = Maps.newHashMap();
    }

    public static <R extends Serializable> ISsePathRequestBuilder<R> builder() {
        return new SseRequestBuilder<>();
    }

    @Override
    public ISseParamRequestBuilder<R> withResponse(final Class<R> responseType) {
        this.responseType = new GenericType<>(responseType);
        return this;
    }

    @Override
    public ISseResponseTypeRequestBuilder<R> addPathParam(final String key, final String value) {
        this.pathParams.put(key, value);
        return this;
    }

    @Override
    public ISseParamRequestBuilder<R> withResponse(final GenericType<R> responseType) {
        this.responseType = responseType;
        return this;
    }

    @Override
    public ISseParamRequestBuilder<R> addHeaderParam(final String key, final String value) {
        this.headerParams.put(key, value);
        return this;
    }

    @Override
    public ISseParamRequestBuilder<R> addQueryParam(final String key, final String value) {
        this.queryParams.put(key, value);
        return this;
    }

    @Override
    public ISseParamRequestBuilder<R> addQueryParam(final Map<String, String> queryParams) {
        this.queryParams.putAll(queryParams);
        return this;
    }

    @Override
    public ISseParamRequestBuilder<R> withSecretToken() {
        this.useSecretToken = true;
        return this;
    }

    @Override
    public ISseResponseTypeRequestBuilder<R> withPath(final String path) {
        this.path = path;
        return this;
    }

    @Override
    public SseRequest<R> build() {
        return new SseRequest<R>(this.responseType, this.path, this.headerParams, this.queryParams,
                this.useSecretToken);
    }

}
