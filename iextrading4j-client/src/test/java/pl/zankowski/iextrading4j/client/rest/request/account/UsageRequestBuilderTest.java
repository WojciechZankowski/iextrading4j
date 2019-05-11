package pl.zankowski.iextrading4j.client.rest.request.account;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.account.Usage;
import pl.zankowski.iextrading4j.api.marketdata.Auction;
import pl.zankowski.iextrading4j.api.marketdata.Book;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.AuctionRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.marketdata.BookRequestBuilder;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class UsageRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateUsageRequest() {
        final RestRequest<Map<String, List<Usage>>> request = new UsageRequestBuilder().build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/account/usage");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Map<String, List<Usage>>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateSingleRequest() {
        final UsageType usageType = UsageType.MESSAGES;

        final RestRequest<List<Usage>> request = new UsageRequestBuilder()
                .withUsageType(usageType)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/account/usage/{type}");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Usage>>() {});
        assertThat(request.getPathParams()).contains(entry("type", usageType.getType()));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
