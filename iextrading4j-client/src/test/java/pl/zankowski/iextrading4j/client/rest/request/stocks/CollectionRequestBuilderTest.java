package pl.zankowski.iextrading4j.client.rest.request.stocks;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CollectionRequestBuilderTest {

    @Test
    void shouldThrowExceptionWhenCollectionTypeIsNull() {
        assertThrows(NullPointerException.class, () -> new CollectionRequestBuilder()
                .withCollectionName("name")
                .build());
    }

    @Test
    void shouldThrowExceptionWhenCollectionNameIsNull() {
        assertThrows(NullPointerException.class, () -> new CollectionRequestBuilder()
                .withCollectionType(CollectionType.SECTOR)
                .build());
    }

    @Test
    void shouldSuccessfullyCreateRequest() {
        final CollectionType collectionType = CollectionType.SECTOR;
        final String collectionName = "name";

        final RestRequest<List<Quote>> request = new CollectionRequestBuilder()
                .withCollectionType(collectionType)
                .withCollectionName(collectionName)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/market/collection/{type}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Quote>>() {});
        assertThat(request.getQueryParams()).contains(entry("collectionName", collectionName));
        assertThat(request.getPathParams()).contains(entry("type", collectionType.name().toLowerCase()));
    }

}
