package pl.zankowski.iextrading4j.client.rest.request;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.filter.RequestFilter;
import pl.zankowski.iextrading4j.client.rest.request.filter.RequestFilterBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.AuctionRequestBuilder;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class AbstractRequestFilterBuilderTest {

    @Test
    void shouldSuccessfullyAddFilterToQueryParameters() {
        final String column = "symbol";
        final RequestFilter requestFilter = new RequestFilterBuilder()
                .withColumn(column)
                .build();

        final RestRequest<Map<String, Auction>> request = new AuctionRequestBuilder()
                .withRequestFilter(requestFilter)
                .build();

        assertThat(request.getQueryParams()).contains(entry("filter", column));
    }

    @Test
    void shouldNotAddFilterToQueryParameters() {
        final RestRequest<Map<String, Auction>> request = new AuctionRequestBuilder()
                .build();

        assertThat(request.getQueryParams()).doesNotContainKeys("filter");
    }

}
