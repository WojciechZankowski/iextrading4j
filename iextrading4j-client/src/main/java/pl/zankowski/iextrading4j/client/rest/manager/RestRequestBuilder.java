package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.collect.Maps;

import javax.ws.rs.core.GenericType;
import java.util.Map;

import static pl.zankowski.iextrading4j.client.rest.manager.MethodType.GET;
import static pl.zankowski.iextrading4j.client.rest.manager.MethodType.POST;

public class RestRequestBuilder<R> implements IRestPathRequestBuilder<R>,
        IRestRequestTypeBuilder<R>, IRestResponseTypeRequestBuilder<R>, IRestParamRequestBuilder<R>,
        IRestRequestBodyBuilder<R> {

    private GenericType<R> responseType;
    private PostEntity requestEntity;
    private String path;
    private MethodType methodType;
    private Map<String, String> headerParams;
    private Map<String, String> queryParams;
    private Map<String, String> pathParams;
    private Boolean useSecretToken = Boolean.FALSE;

    protected RestRequestBuilder() {
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
    public IRestParamRequestBuilder<R> addQueryParam(final Map<String, String> queryParams) {
        this.queryParams.putAll(queryParams);
        return this;
    }

    @Override
    public IRestResponseTypeRequestBuilder<R> get() {
        this.methodType = GET;
        return this;
    }

    @Override
    public IRestRequestBodyBuilder<R> post() {
        this.methodType = POST;
        return this;
    }

    @Override
    public IRestResponseTypeRequestBuilder<R> withRequest(final PostEntity requestEntity) {
        this.requestEntity = requestEntity;
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
    public IRestParamRequestBuilder<R> withSecretToken() {
        this.useSecretToken = true;
        return this;
    }

    @Override
    public RestRequest<R> build() {
        return new RestRequest<R>(this.responseType, this.requestEntity, this.path, this.methodType, this.headerParams,
                this.queryParams, this.pathParams, this.useSecretToken);
    }

}
