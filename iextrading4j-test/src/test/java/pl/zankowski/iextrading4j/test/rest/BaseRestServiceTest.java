package pl.zankowski.iextrading4j.test.rest;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import pl.zankowski.iextrading4j.client.IEXTradingClient;

public abstract class BaseRestServiceTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    protected IEXTradingClient iexTradingClient;

    @Before
    public void setUp() throws Exception {
        iexTradingClient = IEXTradingClient.create();
    }

    @After
    public void tearDown() {
        iexTradingClient = null;
    }
}
