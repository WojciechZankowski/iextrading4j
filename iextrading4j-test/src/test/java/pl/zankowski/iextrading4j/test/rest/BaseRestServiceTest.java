package pl.zankowski.iextrading4j.test.rest;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.manager.RestClientMetadata;
import pl.zankowski.iextrading4j.client.rest.manager.RestManager;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({IEXTradingClient.class})
@PowerMockIgnore({"javax.net.ssl.*"})
public abstract class BaseRestServiceTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    protected IEXTradingClient iexTradingClient;

    @Before
    public void setUp() throws Exception {
        final RestClientMetadata restClientMetadata = mock(RestClientMetadata.class);
        when(restClientMetadata.getUrl()).thenReturn("http://localhost:8089");

        whenNew(RestClientMetadata.class).withAnyArguments().thenReturn(restClientMetadata);

        iexTradingClient = IEXTradingClient.create();
    }

    @After
    public void tearDown() {
        iexTradingClient = null;
    }
}
