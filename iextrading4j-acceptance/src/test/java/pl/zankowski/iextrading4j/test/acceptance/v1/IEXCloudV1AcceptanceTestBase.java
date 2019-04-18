package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.After;
import org.junit.Before;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;

public class IEXCloudV1AcceptanceTestBase {

    protected IEXCloudClient cloudClient;

    @Before
    public void setUp() {
        cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX, new IEXCloudTokenBuilder()
                .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                .build());
    }

    @After
    public void tearDown() {
        cloudClient = null;
    }

}
