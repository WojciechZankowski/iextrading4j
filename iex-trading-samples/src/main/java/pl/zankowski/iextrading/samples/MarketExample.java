package pl.zankowski.iextrading.samples;

import pl.zankowski.iextrading.api.filter.RequestFilter;
import pl.zankowski.iextrading.api.market.MarketVolume;
import pl.zankowski.iextrading.rest.client.IEXTradingClient;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class MarketExample {

    public static void main(String[] args) {
        IEXTradingClient iexTradingClient = IEXTradingClient.create();

        requestMarketsVolume(iexTradingClient);
        requestMarketsVolumeWithRequestFilter(iexTradingClient);
    }

    private static void requestMarketsVolume(IEXTradingClient iexTradingClient) {
        MarketVolume[] marketsVolume = iexTradingClient.getMarketEndpoint().requestMarketVolume();
        Arrays.stream(marketsVolume).forEach(System.out::println);
    }

    private static void requestMarketsVolumeWithRequestFilter(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("mic")
                .with("marketPercent")
                .build();
        MarketVolume[] marketsVolume = iexTradingClient.getMarketEndpoint().requestMarketVolume(requestFilter);
        Arrays.stream(marketsVolume).forEach(System.out::println);
    }

}
