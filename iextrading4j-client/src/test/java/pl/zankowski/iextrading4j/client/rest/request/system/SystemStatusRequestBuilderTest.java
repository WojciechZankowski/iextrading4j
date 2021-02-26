package pl.zankowski.iextrading4j.client.rest.request.system;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.system.SystemStatus;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;

public class SystemStatusRequestBuilderTest {

    @Test
    public void shouldSuccessfullyCreateRequest() {
        final RestRequest<SystemStatus> request = new SystemStatusRequestBuilder()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/status");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<SystemStatus>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();
    }

}
