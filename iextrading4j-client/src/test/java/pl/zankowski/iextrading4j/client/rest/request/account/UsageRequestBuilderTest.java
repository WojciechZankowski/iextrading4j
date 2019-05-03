package pl.zankowski.iextrading4j.client.rest.request.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.AbstractMap.SimpleEntry;
import javax.ws.rs.core.GenericType;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.account.Usage;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

public class UsageRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequestWithoutType() {
        final RestRequest<Usage> request = new UsageRequestBuilder().build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/account/usage");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Usage>() {
        });
        assertThat(request.getQueryParams()).isEmpty();
    }

    @Test
    public void shouldSuccessfullyCreateRequestWithType() {
        final RestRequest<Usage> request = new UsageRequestBuilder()
                .withUsageType(UsageType.MESSAGES)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/account/usage/{type}");
        assertThat(request.getPathParams()).containsExactly(new SimpleEntry<>("type", UsageType.MESSAGES.getType()));
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Usage>() {
        });
        assertThat(request.getQueryParams()).isEmpty();
    }

}