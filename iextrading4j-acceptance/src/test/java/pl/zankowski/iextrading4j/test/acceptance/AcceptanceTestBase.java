package pl.zankowski.iextrading4j.test.acceptance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import pl.zankowski.iextrading4j.client.IEXApiClient;
import pl.zankowski.iextrading4j.client.IEXTradingClient;

public abstract class AcceptanceTestBase {

    protected static IEXApiClient iexTradingClient;

    @BeforeClass
    public static void setUp() throws Exception {
        iexTradingClient = IEXTradingClient.create();
    }

    @AfterClass
    public static void tearDown() {
        iexTradingClient = null;
    }

}
