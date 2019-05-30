package pl.zankowski.iextrading4j.sample.iexcloud.rest;

import pl.zankowski.iextrading4j.api.refdata.v1.*;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.*;

import java.util.List;

public class RefDataSample {

    final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_BETA_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                    .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                    .build());

    public static void main(String[] args) {
        final RefDataSample refDataSample = new RefDataSample();

        // The requested data is not available to free tier accounts
        // refDataSample.fxSymbolsRequestSample();

        refDataSample.symbolsRequestSample();
        refDataSample.iexSymbolsRequestSample();
        refDataSample.regionSymbolsRequestSample();
        refDataSample.exchangeSymbolsRequestSample();
        refDataSample.exchangeRequestSample();
        refDataSample.usExchangeRequestSample();
        refDataSample.mutualFundsRequestSample();
        refDataSample.otcFundsRequestSample();
        refDataSample.usHolidayAndTradingDateSample();
        refDataSample.sectorsSample();
        refDataSample.tagsSample();
        refDataSample.isinSample();
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

    private void exchangeRequestSample() {
        final List<Exchange> exchanges = cloudClient.executeRequest(new ExchangeRequestBuilder().build());
        System.out.println(exchanges);
    }

    private void usExchangeRequestSample() {
        final List<UsExchange> usExchanges = cloudClient.executeRequest(new UsExchangeRequestBuilder().build());
        System.out.println(usExchanges);
    }

    private void mutualFundsRequestSample() {
        final List<ExchangeSymbol> symbols = cloudClient.executeRequest(new MutualFundSymbolsRequestBuilder().build());
        System.out.println(symbols);
    }

    private void otcFundsRequestSample() {
        final List<ExchangeSymbol> symbols = cloudClient.executeRequest(new OtcSymbolsRequestBuilder().build());
        System.out.println(symbols);
    }

    private void fxSymbolsRequestSample() {
        final FxSymbol symbol = cloudClient.executeRequest(new FxSymbolRequestBuilder().build());
        System.out.println(symbol);
    }

    private void usHolidayAndTradingDateSample() {
        final List<HolidayAndTradingDate> result = cloudClient.executeRequest(new UsHolidayAndTradingDateRequestBuilder()
                .withType(DateType.TRADE)
                .withDirection(DateDirection.NEXT)
                .build());
        System.out.println(result);
    }

    private void sectorsSample() {
        final List<Sector> sectors = cloudClient.executeRequest(new SectorRequestBuilder().build());
        System.out.println(sectors);
    }

    private void tagsSample() {
        final List<Tag> tags = cloudClient.executeRequest(new TagRequestBuilder().build());
        System.out.println(tags);
    }

    private void isinSample() {
        final List<List<SymbolMapping>> result = cloudClient.executeRequest(new IsinMapperRequestBuilder()
                .addIsin("US0378331005")
                .build());
        System.out.println(result);
    }

}
