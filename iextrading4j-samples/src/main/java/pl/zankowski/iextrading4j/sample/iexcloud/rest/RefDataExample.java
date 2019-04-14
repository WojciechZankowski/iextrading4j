package pl.zankowski.iextrading4j.sample.iexcloud.rest;

import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.api.refdata.v1.Symbol;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.ExchangeSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.IEXSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.RegionSymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.SymbolsRequestBuilder;

import java.util.List;

public class RefDataExample {

    final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final RefDataExample refDataExample = new RefDataExample();

//        refDataExample.symbolsRequestSample();
//        refDataExample.iexSymbolsRequestSample();
        refDataExample.regionSymbolsRequestSample();
        refDataExample.exchangeSymbolsRequestSample();
    }

    private void symbolsRequestSample() {
        final List<ExchangeSymbol> symbols = cloudClient.executeRequest(new SymbolsRequestBuilder().build());
        System.out.println(symbols);
    }

    private void iexSymbolsRequestSample() {
        final List<Symbol> symbols = cloudClient.executeRequest(new IEXSymbolsRequestBuilder().build());
        System.out.println(symbols);
    }

    private void regionSymbolsRequestSample() {
        final List<ExchangeSymbol> symbols = cloudClient.executeRequest(new RegionSymbolsRequestBuilder()
                .withRegion("ca")
                .build());
        System.out.println(symbols);
    }

    private void exchangeSymbolsRequestSample() {
        final List<ExchangeSymbol> symbols = cloudClient.executeRequest(new ExchangeSymbolsRequestBuilder()
                .withExchange("tse")
                .build());
        System.out.println(symbols);
    }

}
