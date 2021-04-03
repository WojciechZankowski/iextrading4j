package pl.zankowski.iextrading4j.client.rest.request.account;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.account.Metadata;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import javax.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;

public class MetadataRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final RestRequest<Metadata> request = new MetadataRequestBuilder().build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/account/metadata");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Metadata>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();
    }

}
