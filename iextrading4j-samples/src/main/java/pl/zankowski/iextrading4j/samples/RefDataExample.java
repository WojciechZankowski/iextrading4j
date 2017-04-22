package pl.zankowski.iextrading4j.samples;

import pl.zankowski.iextrading4j.api.filter.RequestFilter;
import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.IEXTradingClient;

import java.util.Arrays;

/**
 * @author Wojciech Zankowski
 */
public class RefDataExample {

    public static void main(String[] args) {
        IEXTradingClient iexTradingClient = IEXTradingClient.create();

        RefDataExample refDataExample = new RefDataExample();
        refDataExample.requestExchangeSymbols(iexTradingClient);
        refDataExample.requestExchangeSymbolsWithRequestFilter(iexTradingClient);
    }

    private void requestExchangeSymbols(IEXTradingClient iexTradingClient) {
        ExchangeSymbol[] exchangeSymbols = iexTradingClient.getRefDataEndpoint().requestExchangeSymbols();
        Arrays.stream(exchangeSymbols).forEach(System.out::println);
    }

    private void requestExchangeSymbolsWithRequestFilter(IEXTradingClient iexTradingClient) {
        RequestFilter requestFilter = RequestFilter.builder()
                .with("symbol")
                .with("name")
                .build();
        ExchangeSymbol[] exchangeSymbols = iexTradingClient.getRefDataEndpoint().requestExchangeSymbols(requestFilter);
        Arrays.stream(exchangeSymbols).forEach(System.out::println);
    }

}
