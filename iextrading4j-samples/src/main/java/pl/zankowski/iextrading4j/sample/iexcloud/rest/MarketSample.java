package pl.zankowski.iextrading4j.sample.iexcloud.rest;

import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.market.MarketRequestBuilder;

import java.util.List;

public class MarketSample {

    private final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final MarketSample marketSample = new MarketSample();

        marketSample.marketRequestSample();
    }

    private void marketRequestSample() {
        final List<MarketVolume> marketVolumes = cloudClient.executeRequest(new MarketRequestBuilder().build());
        System.out.println(marketVolumes);
    }

}
