package pl.zankowski.iextrading4j.sample.rest;

import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.refdata.SymbolsRequestBuilder;

import java.util.List;

public class RefDataSample {

    private final IEXTradingClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        final RefDataSample sampleSuite = new RefDataSample();

        sampleSuite.symbolsRequestSample();
    }

    private void symbolsRequestSample() {
        final List<ExchangeSymbol> exchangeSymbolList = iexTradingClient.executeRequest(new SymbolsRequestBuilder()
                .build());
        System.out.println(exchangeSymbolList);
    }

}
