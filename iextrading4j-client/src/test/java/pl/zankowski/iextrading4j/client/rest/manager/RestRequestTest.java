package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.collect.ImmutableMap;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import jakarta.ws.rs.core.GenericType;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class RestRequestTest {

    @Test
    void constructor() {
        final GenericType<Object> responseTypeMock = mock(GenericType.class);
        final PostEntity postEntity = mock(PostEntity.class);
        final String path = "path";
        final MethodType methodType = MethodType.GET;
        final Map<String, String> headerParams = ImmutableMap.of();
        final Map<String, String> queryParams = ImmutableMap.of();
        final Map<String, String> pathParams = ImmutableMap.of();
        final Boolean useSecretToken = true;

        final RestRequest restRequest = new RestRequest<>(responseTypeMock, postEntity, path, methodType,
                headerParams, queryParams, pathParams, useSecretToken);

        assertThat(restRequest.getResponseType()).isEqualTo(responseTypeMock);
        assertThat(restRequest.getRequestEntity()).isEqualTo(postEntity);
        assertThat(restRequest.getPath()).isEqualTo(path);
        assertThat(restRequest.getMethodType()).isEqualTo(methodType);
        assertThat(restRequest.getHeaderParams()).isEqualTo(headerParams);
        assertThat(restRequest.getQueryParams()).isEqualTo(queryParams);
        assertThat(restRequest.getPathParams()).isEqualTo(pathParams);
        assertThat(restRequest.getUseSecretToken()).isTrue();
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(RestRequest.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(new RestRequest<>(null, null, null, null,
                null, null, null, null))
                .verify();
    }

}
