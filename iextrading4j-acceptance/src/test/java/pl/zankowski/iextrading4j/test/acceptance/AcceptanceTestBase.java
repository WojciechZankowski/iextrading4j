package pl.zankowski.iextrading4j.test.acceptance;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pl.zankowski.iextrading4j.client.IEXApiClient;
import pl.zankowski.iextrading4j.client.IEXTradingClient;

/**
 * @deprecated Old IEX API service https://iextrading.com/developer/
 */
@Deprecated
public abstract class AcceptanceTestBase {

    protected static IEXApiClient iexTradingClient;

    @BeforeAll
    public static void setUp() throws Exception {
        iexTradingClient = IEXTradingClient.create();
    }

    @AfterAll
    public static void tearDown() {
        iexTradingClient = null;
    }

}
