package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.collect.ImmutableMap;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import javax.ws.rs.core.GenericType;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class RestRequestTest {

    @Test
    public void constructor() {
        final GenericType<Object> responseTypeMock = mock(GenericType.class);
        final String path = "path";
        final MethodType methodType = MethodType.GET;
        final Map<String, String> headerParams = ImmutableMap.of();
        final Map<String, String> queryParams = ImmutableMap.of();
        final Map<String, String> pathParams = ImmutableMap.of();

        final RestRequest restRequest = new RestRequest<>(responseTypeMock, path, methodType,
                headerParams, queryParams, pathParams);

        assertThat(restRequest.getResponseType()).isEqualTo(responseTypeMock);
        assertThat(restRequest.getPath()).isEqualTo(path);
        assertThat(restRequest.getMethodType()).isEqualTo(methodType);
        assertThat(restRequest.getHeaderParams()).isEqualTo(headerParams);
        assertThat(restRequest.getQueryParams()).isEqualTo(queryParams);
        assertThat(restRequest.getPathParams()).isEqualTo(pathParams);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(RestRequest.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(new RestRequest<>(null, null, null,
                null, null, null))
                .verify();
    }

}
