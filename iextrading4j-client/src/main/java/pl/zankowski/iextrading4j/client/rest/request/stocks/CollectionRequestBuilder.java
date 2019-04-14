package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXApiRestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.IRestRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class CollectionRequestBuilder implements IEXApiRestRequest<List<Quote>>, IEXCloudV1RestRequest<List<Quote>> {

    private CollectionType collectionType;
    private String collectionName;

    public CollectionRequestBuilder withCollectionType(final CollectionType collectionType) {
        this.collectionType = collectionType;
        return this;
    }

    public CollectionRequestBuilder withCollectionName(final String collectionName) {
        this.collectionName = collectionName;
        return this;
    }

    @Override
    public RestRequest<List<Quote>> build() {
        requireNonNull(collectionType);
        requireNonNull(collectionName);

        return RestRequestBuilder.<List<Quote>>builder()
                .withPath("/stock/market/collection/{type}")
                .addPathParam("type", collectionType.name().toLowerCase()).get()
                .withResponse(new GenericType<List<Quote>>() {})
                .addQueryParam("collectionName", collectionName)
                .build();
    }

}
