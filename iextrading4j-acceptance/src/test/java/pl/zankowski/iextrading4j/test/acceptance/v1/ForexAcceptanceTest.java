package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.Ignore;
import org.junit.Test;
import pl.zankowski.iextrading4j.api.forex.CurrencyConversion;
import pl.zankowski.iextrading4j.api.forex.CurrencyRate;
import pl.zankowski.iextrading4j.api.forex.ExchangeRate;
import pl.zankowski.iextrading4j.api.refdata.v1.Pair;
import pl.zankowski.iextrading4j.client.rest.request.forex.CurrencyConversionRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.forex.ExchangeRateRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.forex.LatestCurrencyRatesRequestBuilder;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ForexAcceptanceTest extends IEXCloudV1AcceptanceTestBase {

    @Test
    public void forexAcceptanceTest() {
        final ExchangeRate result = cloudClient.executeRequest(new ExchangeRateRequestBuilder()
                .withPair(new Pair("EUR", "CHF"))
                .build());

        assertThat(result).isNotNull();
    }

    @Ignore // Not available in sandbox
    @Test
    public void currencyConversionTest() {
        final List<CurrencyConversion> result = cloudClient.executeRequest(new CurrencyConversionRequestBuilder()
                .withSymbol("USDGBP")
                .withAmount(BigDecimal.TEN)
                .build());

        assertThat(result).isNotNull();
    }

    @Ignore // Not available in sandbox
    @Test
    public void latestCurrencyRatesTest() {
        final List<CurrencyRate> result = cloudClient.executeRequest(new LatestCurrencyRatesRequestBuilder()
                .withSymbol("USDGBP")
                .build());

        assertThat(result).isNotNull();
    }

}
