package pl.zankowski.iextrading4j.sample.iexcloud.rest;

import pl.zankowski.iextrading4j.api.forex.ExchangeRate;
import pl.zankowski.iextrading4j.api.refdata.v1.Pair;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.forex.ExchangeRateRequestBuilder;

public class ForexSample {

    final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final ForexSample forexSample = new ForexSample();

        // This data is not available to free tier accounts
        forexSample.exchangeRateRequestSample();
    }

    private void exchangeRateRequestSample() {
        final ExchangeRate exchangeRate = cloudClient.executeRequest(new ExchangeRateRequestBuilder()
                .withPair(new Pair("EUR", "CHF"))
                .build());
        System.out.println(exchangeRate);
    }

}
