package pl.zankowski.iextrading4j.test.rest.v1;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudToken;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;

public class BaseIEXCloudV1ServiceTest {

    private static final IEXCloudToken CLOUD_TOKEN = new IEXCloudTokenBuilder()
            .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
            .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
            .build();

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    protected IEXCloudClient cloudClient;

    @Before
    public void setUp() throws Exception {
        cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX, CLOUD_TOKEN);
    }

    @After
    public void tearDown() {
        cloudClient = null;
    }

    protected String path(final String path) {
        return path(path, CLOUD_TOKEN.getPublishableToken());
    }

    protected String secretPath(final String path) {
        return path(path, CLOUD_TOKEN.getSecretToken());
    }

    private String path(final String path, final String token) {
        return path + "?token=" + token;
    }


}
