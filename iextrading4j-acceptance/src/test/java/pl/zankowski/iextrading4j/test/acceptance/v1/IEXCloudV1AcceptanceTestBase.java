package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;

public class IEXCloudV1AcceptanceTestBase {

    protected IEXCloudClient cloudClient;

    @BeforeEach
    public void setUp() {
        cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX, new IEXCloudTokenBuilder()
                .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                .build());
    }

    @AfterEach
    public void tearDown() {
        cloudClient = null;
    }

}
