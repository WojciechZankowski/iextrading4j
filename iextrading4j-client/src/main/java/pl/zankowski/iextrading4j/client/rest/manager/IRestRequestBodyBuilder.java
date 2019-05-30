package pl.zankowski.iextrading4j.client.rest.manager;

public interface IRestRequestBodyBuilder<R> {

    IRestResponseTypeRequestBuilder<R> withRequest(PostEntity entity);

}
