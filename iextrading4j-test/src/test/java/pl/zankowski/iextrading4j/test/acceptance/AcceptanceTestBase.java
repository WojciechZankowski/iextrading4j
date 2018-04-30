package pl.zankowski.iextrading4j.test.acceptance;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.mapper.IEXTradingMapperContextResolver;
import pl.zankowski.iextrading4j.client.rest.manager.RestClient;
import pl.zankowski.iextrading4j.client.rest.manager.RestClientMetadata;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({IEXTradingClient.class})
@PowerMockIgnore({"javax.net.ssl.*"})
public abstract class AcceptanceTestBase {

    protected IEXTradingClient iexTradingClient;

    @Before
    public void setUp() throws Exception {
        final Client client = ClientBuilder.newClient();
        client.register(AcceptanceTestObjectMapperResolver.class);
        final RestClientMetadata restClientMetadata = new RestClientMetadata();

        final RestClient restClient = mock(RestClient.class);
        when(restClient.getRestClientMetadata()).thenReturn(restClientMetadata);
        when(restClient.getClient()).thenReturn(client);

        whenNew(RestClient.class).withAnyArguments().thenReturn(restClient);

        iexTradingClient = IEXTradingClient.create();
    }

    @After
    public void tearDown() {
        iexTradingClient = null;
    }

    @Provider
    public static class AcceptanceTestObjectMapperResolver implements ContextResolver<ObjectMapper> {

        private final ObjectMapper objectMapper;

        public AcceptanceTestObjectMapperResolver() {
            objectMapper = initializeObjectMapper();
        }

        @Override
        public ObjectMapper getContext(Class<?> type) {
            return objectMapper;
        }

        private ObjectMapper initializeObjectMapper() {
            final ObjectMapper customMapper = new IEXTradingMapperContextResolver().getContext(null);
            customMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
            return customMapper;
        }

    }

}
