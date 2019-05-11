package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.Ignore;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.alternative.CeoCompensation;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CeoCompensationRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CryptoRequestBuilder;

import static org.assertj.core.api.Assertions.assertThat;

public class AlternativeAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Ignore // Not free tier
    @Test
    public void ceoCompensationTest() {
        final CeoCompensation result = cloudClient.executeRequest(new CeoCompensationRequestBuilder()
                .withSymbol("AAPL")
                .build());
        assertThat(result).isNotNull();
    }

    @Test
    public void cryptoTest() {
        final Quote result = cloudClient.executeRequest(new CryptoRequestBuilder()
                .withSymbol("BTCUSDT")
                .build());
        assertThat(result).isNotNull();
    }

}
