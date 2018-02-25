package pl.zankowski.iextrading4j.sample.rest;

import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;
import pl.zankowski.iextrading4j.api.refdata.IEXCorporateActions;
import pl.zankowski.iextrading4j.api.refdata.IEXDividends;
import pl.zankowski.iextrading4j.api.refdata.IEXNextDayExDate;
import pl.zankowski.iextrading4j.api.refdata.IEXSymbolDirectory;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.refdata.IEXCorporateActionsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.IEXDividendsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.IEXNextDayExDateRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.IEXSymbolDirectoryRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.refdata.SymbolsRequestBuilder;

import java.util.List;

public class RefDataSample {

    private final IEXTradingClient iexTradingClient = IEXTradingClient.create();

    public static void main(String[] args) {
        final RefDataSample sampleSuite = new RefDataSample();

        sampleSuite.symbolsRequestSample();
        sampleSuite.nextDayExDateRequestSample();
        sampleSuite.corporateActionsRequestSample();
        sampleSuite.dividendsRequestSample();
        sampleSuite.symbolDirectoryRequestSample();
    }

    private void symbolsRequestSample() {
        final List<ExchangeSymbol> exchangeSymbolList = iexTradingClient.executeRequest(new SymbolsRequestBuilder()
                .build());
        System.out.println(exchangeSymbolList);
    }

    private void nextDayExDateRequestSample() {
        final List<IEXNextDayExDate> nextDayExDateList = iexTradingClient.executeRequest(new IEXNextDayExDateRequestBuilder()
                .withSample()
                .build());
        System.out.println(nextDayExDateList);
    }

    private void corporateActionsRequestSample() {
        final List<IEXCorporateActions> corporateActions = iexTradingClient.executeRequest(new IEXCorporateActionsRequestBuilder()
                .withSample()
                .build());
        System.out.println(corporateActions);
    }

    private void dividendsRequestSample() {
        final List<IEXDividends> dividendsList = iexTradingClient.executeRequest(new IEXDividendsRequestBuilder()
                .withSample()
                .build());
        System.out.println(dividendsList);
    }

    private void symbolDirectoryRequestSample() {
        final List<IEXSymbolDirectory> symbolDirectoryList = iexTradingClient.executeRequest(new IEXSymbolDirectoryRequestBuilder()
                .withSample()
                .build());
        System.out.println(symbolDirectoryList);
    }

}
