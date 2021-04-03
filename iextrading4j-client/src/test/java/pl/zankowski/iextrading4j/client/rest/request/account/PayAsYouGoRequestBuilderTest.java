package pl.zankowski.iextrading4j.client.rest.request.account;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;

public class PayAsYouGoRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {

        final RestRequest<String> request = new PayAsYouGoRequestBuilder()
                .withDisallowed()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.POST);
        assertThat(request.getPath()).isEqualTo("/account/payasyougo");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<String>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();

        final Boolean isAllow = ((PayAsYouGoRequestBuilder.PayAsYouGoPostEntity) request.getRequestEntity()).isAllow();
        assertThat(isAllow).isFalse();
    }

    @Test
    void shouldSuccessfullyCreateRequestWithAllow() {

        final RestRequest<String> request = new PayAsYouGoRequestBuilder()
                .withAllowed()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.POST);
        assertThat(request.getPath()).isEqualTo("/account/payasyougo");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<String>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();

        final Boolean isAllow = ((PayAsYouGoRequestBuilder.PayAsYouGoPostEntity) request.getRequestEntity()).isAllow();
        assertThat(isAllow).isTrue();
    }

}
