package pl.zankowski.iextrading4j.client.sse.manager;

import java.io.Serializable;
import java.util.Map;

public interface ISseParamRequestBuilder<R extends Serializable> {

    ISseParamRequestBuilder<R> addHeaderParam(String key, String value);

    ISseParamRequestBuilder<R> addQueryParam(String key, String value);

    ISseParamRequestBuilder<R> addQueryParam(Map<String, String> queryParams);

    ISseParamRequestBuilder<R> withSecretToken();

    SseRequest<R> build();

}
