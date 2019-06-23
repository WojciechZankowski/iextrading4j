package pl.zankowski.iextrading4j.client.sse.manager;

import java.io.Serializable;

public interface ISsePathRequestBuilder<R extends Serializable> {

    ISseResponseTypeRequestBuilder<R> withPath(String path);

}
