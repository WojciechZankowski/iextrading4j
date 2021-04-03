package pl.zankowski.iextrading4j.client.rest.request.account;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageCutoffRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final Long totalMessages = 10000L;

        final RestRequest<String> request = new MessageCutoffRequestBuilder()
                .withTotalMessages(totalMessages)
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.POST);
        assertThat(request.getPath()).isEqualTo("/account/circuitbreaker");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<String>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();

        final Long messages = ((MessageCutoffRequestBuilder.MessageCutoffPostEntity) request.getRequestEntity()).getTotalMessages();
        assertThat(messages).isEqualTo(totalMessages);
    }

}
