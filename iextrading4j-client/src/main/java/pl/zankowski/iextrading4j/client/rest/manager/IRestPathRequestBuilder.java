package pl.zankowski.iextrading4j.client.rest.manager;

import java.io.Serializable;

public interface IRestPathRequestBuilder<R extends Serializable> {

    IRestRequestTypeBuilder<R> withPath(String path);

}
