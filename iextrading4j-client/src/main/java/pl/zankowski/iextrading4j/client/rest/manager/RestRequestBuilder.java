package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.collect.Maps;

import javax.ws.rs.core.GenericType;
import java.util.Map;

import static pl.zankowski.iextrading4j.client.rest.manager.MethodType.GET;

public class RestRequestBuilder<R> implements IRestPathRequestBuilder<R>,
        IRestRequestTypeBuilder<R>, IRestResponseTypeRequestBuilder<R>, IRestParamRequestBuilder<R> {

    private GenericType<R> responseType;
    private String path;
    private MethodType methodType;
    private Map<String, String> headerParams;
    private Map<String, String> queryParams;
    private Map<String, String> pathParams;

    private RestRequestBuilder() {
        this.headerParams = Maps.newHashMap();
        this.queryParams = Maps.newHashMap();
        this.pathParams = Maps.newHashMap();
    }

    public static <R> IRestPathRequestBuilder<R> builder() {
        return new RestRequestBuilder<>();
    }

    @Override
    public IRestRequestTypeBuilder<R> withPath(final String path) {
        this.path = path;
        return this;
    }

    @Override
    public IRestRequestTypeBuilder<R> addPathParam(final String key, final String value) {
        this.pathParams.put(key, value);
        return this;
    }

    @Override
    public IRestParamRequestBuilder<R> addHeaderParam(final String key, final String value) {
        this.headerParams.put(key, value);
        return this;
    }

    @Override
    public IRestParamRequestBuilder<R> addQueryParam(final String key, final String value) {
        this.queryParams.put(key, value);
        return this;
    }

    @Override
    public IRestParamRequestBuilder<R> addQueryParam(Map<String, String> queryParams) {
        this.queryParams.putAll(queryParams);
        return this;
    }

    @Override
    public IRestResponseTypeRequestBuilder<R> get() {
        this.methodType = GET;
        return this;
    }

    @Override
    public IRestParamRequestBuilder<R> withResponse(final Class<R> responseType) {
        this.responseType = new GenericType<>(responseType);
        return this;
    }

    @Override
    public IRestParamRequestBuilder<R> withResponse(final GenericType<R> responseType) {
        this.responseType = responseType;
        return this;
    }

    @Override
    public RestRequest<R> build() {
        return new RestRequest<>(this.responseType, this.path, this.methodType, this.headerParams,
                this.queryParams, this.pathParams);
    }

}
