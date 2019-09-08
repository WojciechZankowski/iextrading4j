package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.Test;
import pl.zankowski.iextrading4j.api.forex.ExchangeRate;
import pl.zankowski.iextrading4j.api.refdata.v1.Pair;
import pl.zankowski.iextrading4j.client.rest.request.forex.ExchangeRateRequestBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class ForexAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Test
    public void forexAcceptanceTest() {
        final ExchangeRate result = cloudClient.executeRequest(new ExchangeRateRequestBuilder()
                .withPair(new Pair("EUR", "CHF"))
                .build());

        assertThat(result).isNotNull();
    }

}
