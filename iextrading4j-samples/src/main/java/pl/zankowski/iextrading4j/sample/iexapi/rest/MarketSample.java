package pl.zankowski.iextrading4j.sample.iexapi.rest;

import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.IEXApiClient;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.market.MarketRequestBuilder;

import java.util.List;

@Deprecated
public class MarketSample {

    private final IEXApiClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        final MarketSample sampleSuite = new MarketSample();

        sampleSuite.marketVolumeRequestSample();
    }

    private void marketVolumeRequestSample() {
        final List<MarketVolume> marketVolumeList = iexTradingClient.executeRequest(new MarketRequestBuilder()
                .build());
        System.out.println(marketVolumeList);
    }

}
